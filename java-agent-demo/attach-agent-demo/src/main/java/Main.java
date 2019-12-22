import com.sun.tools.attach.spi.AttachProvider;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AttachProvider> providers = AttachProvider.providers();
        providers.forEach(item ->item.listVirtualMachines().stream().filter(pid -> !pid.displayName().contains("IntelliJ IDEA"))
                .forEach(pid -> System.out.println(pid.id() + " " + pid.displayName())));
    }
}
