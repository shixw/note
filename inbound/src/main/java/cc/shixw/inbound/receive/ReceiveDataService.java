package cc.shixw.inbound.receive;

import cc.shixw.inbound.receive.vo.ReceiveData;

public interface ReceiveDataService<T> {

    boolean receive(ReceiveData receiveData);
}
