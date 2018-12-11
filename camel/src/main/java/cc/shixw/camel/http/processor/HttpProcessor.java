package cc.shixw.camel.http.processor;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpMessage;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        HttpMessage message = (HttpMessage) exchange.getIn();

        InputStream in = (InputStream) message.getBody();

        String inputContext = this.analysisMessage(in);

        in.close();

        // 存入到exchange的out区域
        if (exchange.getPattern() == ExchangePattern.InOut) {
            Message outMessage = exchange.getOut();
            outMessage.setBody(inputContext + " || out");
//			System.out.println(outMessage.getBody());
        }
    }

    private String analysisMessage(InputStream in) throws IOException {
        String responseStr = IOUtils.toString(in, "UTF-8");

//		System.out.println(responseStr);

        return responseStr;
    }
}
