package cz.zvestov.ws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

@WebService
public class CounterWS {

    @Resource
    private WebServiceContext wsContext;

    public void increase() {
        Integer counter = getCounter();
        counter++;

        getSession().setAttribute("counter", counter);

    }

    public Integer getCount() {
        Integer counter = getCounter();
        return counter;
    }

    private Integer getCounter() {
        HttpSession session = getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }

        return counter;
    }

    private HttpSession getSession() {
        MessageContext messageContext = wsContext.getMessageContext();
        HttpSession session = ((HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null) {
            throw new WebServiceException("No HTTP Session found");
        }
        return session;
    }

}
