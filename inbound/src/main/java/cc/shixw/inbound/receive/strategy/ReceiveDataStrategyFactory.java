package cc.shixw.inbound.receive.strategy;

import cc.shixw.inbound.receive.strategy.ReceiveDataAssemblyStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataCheckStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataSaveStrategy;
import cc.shixw.inbound.receive.vo.ReceiveData;

public interface ReceiveDataStrategyFactory<T> {

    ReceiveDataCheckStrategy getReceiveDataCheckStrategy(ReceiveData receiveData);


    ReceiveDataAssemblyStrategy<T> getReceiveDataAssemblyStrategy(ReceiveData receiveData) ;

    ReceiveDataSaveStrategy<T> getReceiveDataSaveStrategy(ReceiveData receiveData);
}
