package cc.shixw.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.CountDownLatch;

public class FileCopierWithCamel {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:inbox?noop=true").to("file:outbox");
            }
        });

        camelContext.start();

        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
        synchronized (FileCopierWithCamel.class){
            FileCopierWithCamel.class.wait();
        }
    }
}
