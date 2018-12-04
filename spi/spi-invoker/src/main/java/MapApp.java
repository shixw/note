import cc.shixw.spi.api.printer.Printer;

import java.util.ServiceLoader;

/**
 * @author shixianwei
 * @date 2018/12/4 10:14
 */
public class MapApp {

    public static void main(String[] args) {
        ServiceLoader<Printer> printerServiceLoader = ServiceLoader.load(Printer.class);
        printerServiceLoader.forEach(p-> p.print());
    }
}
