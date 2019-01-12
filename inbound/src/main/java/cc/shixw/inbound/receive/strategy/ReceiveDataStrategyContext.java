package cc.shixw.inbound.receive.strategy;

import cc.shixw.inbound.receive.vo.ReceiveData;

public interface ReceiveDataStrategyContext<T> {

    boolean check(ReceiveData receiveData);

    T assembly(ReceiveData receiveData);

    boolean save(T inboundData);
}
