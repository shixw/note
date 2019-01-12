package cc.shixw.inbound.receive;

import cc.shixw.inbound.receive.enums.ReceiveDataServiceEnum;
import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 验收服务工厂类
 */
public class ReceiveDataServiceFactory {

    public static ReceiveDataService createReceiveDataService(ReceiveData receiveData){
        return ReceiveDataServiceEnum.valueOf(receiveData.getReceiveDataService()).getReceiveDataService();
    }
}
