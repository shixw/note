package cc.shixw.inbound.receive.strategy;


import cc.shixw.inbound.receive.strategy.impl.DefaultReceiveDataStrategyContext;
import cc.shixw.inbound.receive.vo.InBoundData;
import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 创建策略上下文
 */
public class ReceiveDataStrategyFactory<T>{

    private ReceiveDataStrategyFactory(){

    }

    public static ReceiveDataStrategyContext createReceiveDataStrategyContext(ReceiveData receiveData){
        //根据入参相关信息 获取策略配置信息
        return new DefaultReceiveDataStrategyContext(new ReceiveDataCheckStrategy() {
            @Override
            public boolean check(ReceiveData receiveData) {
                return true;
            }
        }, new ReceiveDataAssemblyStrategy<InBoundData>() {
            @Override
            public InBoundData assembly(ReceiveData receiveData) {
                return new InBoundData();
            }
        }, new ReceiveDataSaveStrategy<InBoundData>() {
            @Override
            public Boolean save(InBoundData inBoundData) {
                return true;
            }
        });

    }
}
