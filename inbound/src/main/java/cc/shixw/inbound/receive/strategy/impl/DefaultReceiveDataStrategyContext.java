package cc.shixw.inbound.receive.strategy.impl;

import cc.shixw.inbound.receive.strategy.ReceiveDataAssemblyStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataCheckStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataSaveStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyContext;
import cc.shixw.inbound.receive.vo.InBoundData;
import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 需要根据相关参数获取相应的策略
 */
public class DefaultReceiveDataStrategyContext implements ReceiveDataStrategyContext<InBoundData> {

    private ReceiveDataCheckStrategy receiveDataCheckStrategy;
    private ReceiveDataAssemblyStrategy<InBoundData> receiveDataAssemblyStrategy;
    private ReceiveDataSaveStrategy<InBoundData> receiveDataSaveStrategy;

    public DefaultReceiveDataStrategyContext(ReceiveDataCheckStrategy receiveDataCheckStrategy, ReceiveDataAssemblyStrategy<InBoundData> receiveDataAssemblyStrategy, ReceiveDataSaveStrategy<InBoundData> receiveDataSaveStrategy) {
        this.receiveDataCheckStrategy = receiveDataCheckStrategy;
        this.receiveDataAssemblyStrategy = receiveDataAssemblyStrategy;
        this.receiveDataSaveStrategy = receiveDataSaveStrategy;
    }

    @Override
    public boolean check(ReceiveData receiveData) {
        return receiveDataCheckStrategy.check(receiveData);
    }

    @Override
    public InBoundData assembly(ReceiveData receiveData) {
        return receiveDataAssemblyStrategy.assembly(receiveData);
    }

    @Override
    public boolean save(InBoundData inboundData) {
        return receiveDataSaveStrategy.save(inboundData);
    }
}
