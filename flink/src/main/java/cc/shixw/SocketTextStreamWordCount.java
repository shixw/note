package cc.shixw;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author shixianwei
 * @date 2019/2/15 15:00
 */
public class SocketTextStreamWordCount {

    public static void main(String[] args) throws Exception {
        if (args.length != 2){
            return;
        }
        String host = args[0];
        Integer port = Integer.parseInt(args[1]);

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> stream = env.socketTextStream(host, port);
        SingleOutputStreamOperator<Tuple2<String,Integer>> sum = stream.flatMap(new LineSplitter()).keyBy(0).sum(1);

        sum.print();

        env.execute("java Wordcount from ");
    }

    public static final class LineSplitter implements FlatMapFunction<String,Tuple2<String,Integer>>{

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            String[] split = s.toLowerCase().split("\\W+");

            for (String ss : split){
                collector.collect(new Tuple2<>(ss,1));
            }
        }
    }

}
