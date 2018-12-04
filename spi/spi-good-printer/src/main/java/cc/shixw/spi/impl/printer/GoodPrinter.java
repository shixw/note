package cc.shixw.spi.impl.printer;

import cc.shixw.spi.api.printer.Printer;

/**
 * @author shixianwei
 * @date 2018/12/4 10:01
 */
public class GoodPrinter implements Printer {
    public void print() {
        System.out.println("good printer");
    }
}
