package cc.shixw.inbound.receive.impl;


import cc.shixw.inbound.receive.ReceiveDataService;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyContext;
import cc.shixw.inbound.receive.vo.ReceiveData;

public abstract class ReceiveDataAbstractService<T> implements ReceiveDataService<T> {


    public final boolean receive(ReceiveData receiveData){
        before(receiveData);
        ReceiveDataStrategyContext<T> receiveDataStrategyContext = getReceiveDataStrategyContext(receiveData);
        if (!receiveDataStrategyContext.check(receiveData)){
            return false;
        }
        T inBoundData = receiveDataStrategyContext.assembly(receiveData);
        if (!receiveDataStrategyContext.save(inBoundData)){
            return false;
        }
        after(receiveData);
        return true;
    }

    abstract void before(final ReceiveData receiveData);

    abstract void after(final ReceiveData receiveData);

    abstract ReceiveDataStrategyContext<T> getReceiveDataStrategyContext(ReceiveData receiveData);
}
