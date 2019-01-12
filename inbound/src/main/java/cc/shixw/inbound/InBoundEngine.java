package cc.shixw.inbound;

import cc.shixw.inbound.receive.vo.ReceiveData;
import cc.shixw.inbound.receive.ReceiveDataServiceFactory;

/**
 * 入库引擎
 */
public class InBoundEngine {

    /**
     * 单据接受
     * @return
     */
    public boolean receipt(){

        return true;
    }

    /**
     * 验收
     * @return
     */
    public boolean receive(int receiveType,ReceiveData receiveData){
        return ReceiveDataServiceFactory.createReceiveDataService(receiveData).receive(receiveData);
    }

    /**
     * 上架
     * @return
     */
    public boolean shelves(){

        return true;
    }
}
