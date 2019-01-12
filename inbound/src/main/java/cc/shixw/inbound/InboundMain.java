package cc.shixw.inbound;

import cc.shixw.inbound.receive.vo.ReceiveData;

public class InboundMain {

    public static void main(String[] args) {
        InBoundEngine inBoundEngine = new InBoundEngine();
        ReceiveData receiveData = new ReceiveData();
        receiveData.setReceiveDataService("DEFAULT");
        inBoundEngine.receive(1,receiveData);
    }
}
