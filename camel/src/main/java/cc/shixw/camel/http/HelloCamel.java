package cc.shixw.camel.http;

import cc.shixw.camel.http.processor.HttpProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.CountDownLatch;

public class HelloCamel extends RouteBuilder{

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure(HelloCamel.class.getClassLoader().getResource("log4j.properties"));
//        PropertyConfigurator.configureAndWatch("classpath:log4j.properties",1000);

        ModelCamelContext context = new DefaultCamelContext();

        context.start();
/**
 * ==========================<br>
 * 为什么我们先启动一个Camel服务 再使用addRoutes添加编排好的路由呢？<br>
 * 这是为了告诉各位读者，Apache Camel支持动态加载/卸载编排的路由 这很重要，因为后续设计的Broker需要依赖这种能力<br>
 * ==========================<br>
 */

        context.addRoutes(new HelloCamel());

        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:8282/doHelloWorld").process(new HttpProcessor()).to("log:helloworld?showExchangeId=true");
    }
}
