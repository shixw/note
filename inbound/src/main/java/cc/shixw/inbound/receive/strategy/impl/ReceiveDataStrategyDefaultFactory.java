package cc.shixw.inbound.receive.strategy.impl;

import cc.shixw.inbound.receive.vo.InBoundData;
import cc.shixw.inbound.receive.strategy.ReceiveDataAssemblyStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataCheckStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataSaveStrategy;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyFactory;
import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 需要根据上下文获取配置的策略
 * 此处可以缓存
 */
public class ReceiveDataStrategyDefaultFactory implements ReceiveDataStrategyFactory<InBoundData> {



    @Override
    public ReceiveDataCheckStrategy getReceiveDataCheckStrategy(ReceiveData receiveData) {
        return receiveData1 -> {
            System.out.println("默认策略工厂-标准校验");
            return true;
        };
    }

    @Override
    public ReceiveDataAssemblyStrategy<InBoundData> getReceiveDataAssemblyStrategy(ReceiveData receiveData) {
        return receiveData1 -> {
            System.out.println("默认策略工厂-数据转换");
            return new InBoundData();
        };
    }

    @Override
    public ReceiveDataSaveStrategy<InBoundData> getReceiveDataSaveStrategy(ReceiveData receiveData) {
        return inBoundData -> {
            System.out.println("默认策略工厂-数据保存");
            return true;
        };
    }
}
