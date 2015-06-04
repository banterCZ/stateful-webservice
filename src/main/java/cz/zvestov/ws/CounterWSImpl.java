package cz.zvestov.ws;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(serviceName = "CounterWS", endpointInterface = "cz.zvestov.ws.CounterWS")
public class CounterWSImpl implements CounterWS {

    @Inject
    private Counter counter;

    @Override
    public void increase() {
        counter.increase();
    }

    @Override
    public Integer getCount() {
        return counter.getCount();
    }

}
