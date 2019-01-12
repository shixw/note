package cc.shixw.inbound.receive.impl;


import cc.shixw.inbound.receive.vo.InBoundData;
import cc.shixw.inbound.receive.action.ReceiveDataAction;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyFactory;
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
    //获取校验 验收 上架 策略枚举的 接口
    private ReceiveDataStrategyFactory<InBoundData> receiveDataStrategyFactory;

    public ReceiveDataStandardService(List<ReceiveDataAction> beforeAction, List<ReceiveDataAction> afterAction, ReceiveDataStrategyFactory receiveDataStrategyFactory) {
        this.beforeAction = beforeAction;
        this.afterAction = afterAction;
        this.receiveDataStrategyFactory = receiveDataStrategyFactory;
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
    ReceiveDataStrategyFactory getReceiveDataStrategyFactory() {
        return receiveDataStrategyFactory;
    }

}
