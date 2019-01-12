package cc.shixw.inbound.receive.strategy;

import cc.shixw.inbound.receive.vo.ReceiveData;

/**
 * 验收环节数据校验策略
 */
public interface ReceiveDataCheckStrategy {

    boolean check(ReceiveData receiveData);
}
