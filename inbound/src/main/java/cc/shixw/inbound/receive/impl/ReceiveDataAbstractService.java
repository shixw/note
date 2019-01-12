package cc.shixw.inbound.receive.impl;


import cc.shixw.inbound.receive.ReceiveDataService;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyFactory;
import cc.shixw.inbound.receive.vo.ReceiveData;

public abstract class ReceiveDataAbstractService<T> implements ReceiveDataService<T> {


    public boolean receive(ReceiveData receiveData){
        before(receiveData);
        if (!getReceiveDataStrategyFactory().getReceiveDataCheckStrategy(receiveData).check(receiveData)){
            return false;
        }
        T inBoundData = getReceiveDataStrategyFactory().getReceiveDataAssemblyStrategy(receiveData).assembly(receiveData);
        if (!getReceiveDataStrategyFactory().getReceiveDataSaveStrategy(receiveData).save(inBoundData)){
            return false;
        }
        after(receiveData);
        return true;
    }

    abstract void before(final ReceiveData receiveData);

    abstract void after(final ReceiveData receiveData);

    abstract ReceiveDataStrategyFactory<T> getReceiveDataStrategyFactory();
}
