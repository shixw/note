package cc.shixw.inbound.receive.strategy;

import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 验收数据组装策略
 */
public interface ReceiveDataAssemblyStrategy<T> {

    T assembly(ReceiveData receiveData);
}
