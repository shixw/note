package cc.shixw.inbound.receive.strategy;

/**
 * 验收数据保存策略
 */
public interface ReceiveDataSaveStrategy<T> {

    Boolean save(T inBoundData);
}
