package cz.zvestov.ws;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService
public class CounterWS {

    @Inject
    private Counter counter;

    public void increase() {
        counter.increase();
    }

    public Integer getCount() {
        return counter.getCount();
    }

}
