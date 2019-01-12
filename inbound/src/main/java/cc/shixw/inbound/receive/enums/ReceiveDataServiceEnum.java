package cc.shixw.inbound.receive.enums;

import cc.shixw.inbound.receive.action.ReceiveDataAction;
import cc.shixw.inbound.receive.ReceiveDataService;
import cc.shixw.inbound.receive.impl.ReceiveDataStandardService;
import cc.shixw.inbound.receive.strategy.ReceiveDataStrategyFactory;

import java.util.ArrayList;

/**
 * 类似配置文件
 */
public enum ReceiveDataServiceEnum {
    DEFAULT(new ReceiveDataStandardService(new ArrayList<ReceiveDataAction>(),new ArrayList<ReceiveDataAction>()));


    private ReceiveDataService receiveDataService;

    ReceiveDataServiceEnum(ReceiveDataService receiveDataService) {
        this.receiveDataService = receiveDataService;
    }

    public ReceiveDataService getReceiveDataService() {
        return receiveDataService;
    }
}
