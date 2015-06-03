package cz.zvestov.ws;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@SessionScoped
public class Counter implements Serializable {

    private AtomicInteger count = new AtomicInteger(0);

    public void increase() {
        count.addAndGet(1);
    }

    public Integer getCount() {
        return count.get();
    }

}
