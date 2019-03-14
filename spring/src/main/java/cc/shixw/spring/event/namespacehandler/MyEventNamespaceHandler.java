package cc.shixw.spring.event.namespacehandler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author shixianwei
 * @date 2019/3/7 20:35
 */
public class MyEventNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("application",new ApplicationBeanDefinitionParser());
    }
}
