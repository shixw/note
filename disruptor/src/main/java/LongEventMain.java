import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

public class LongEventMain {

    public static void main(String[] args) throws InterruptedException {
        LongEventFactory longEventFactory = new LongEventFactory();
        int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventFactory,bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducerWithTranslator longEventProducerWithTranslator = new LongEventProducerWithTranslator(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long l = 0; true; l++) {
            byteBuffer.putLong(0,l);
            longEventProducerWithTranslator.onData(byteBuffer);
            Thread.sleep(1000);
        }

    }
}
