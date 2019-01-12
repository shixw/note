package cc.shixw.inbound.receive.impl;


import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyContext;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyFactory;
import cc.shixw.inbound.receive.vo.InBoundData;
import cc.shixw.inbound.receive.action.ReceiveDataAction;
import cc.shixw.inbound.receive.vo.ReceiveData;

import java.util.List;

/**
 * 标准的验收服务
 */
public class ReceiveDataStandardService extends ReceiveDataAbstractService<InBoundData> {
    //前置执行 List
    private List<ReceiveDataAction> beforeAction;
    //后置执行 List
    private List<ReceiveDataAction> afterAction;

    public ReceiveDataStandardService(List<ReceiveDataAction> beforeAction, List<ReceiveDataAction> afterAction) {
        this.beforeAction = beforeAction;
        this.afterAction = afterAction;
    }

    @Override
    void before(ReceiveData receiveData) {
        beforeAction.forEach(receiveDataAction -> receiveDataAction.action(receiveData));
    }

    @Override
    void after(ReceiveData receiveData) {
        afterAction.forEach(receiveDataAction -> receiveDataAction.action(receiveData));
    }

    @Override
    ReceiveDataStrategyContext<InBoundData> getReceiveDataStrategyContext(ReceiveData receiveData) {
        return ReceiveDataStrategyFactory.createReceiveDataStrategyContext(receiveData);
    }
}
