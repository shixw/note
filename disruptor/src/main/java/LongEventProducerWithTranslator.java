import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LongEvent,ByteBuffer> TRANSLATOR= (longEvent, l, byteBuffer) -> longEvent.setValue(byteBuffer.getLong(0));
    public void onData(ByteBuffer byteBuffer){
        ringBuffer.publishEvent(TRANSLATOR,byteBuffer);
    }
}
