import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.WorkerPool;

public class LongEventHandler implements EventHandler<LongEvent>,WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event:"+longEvent);
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {

    }
}
