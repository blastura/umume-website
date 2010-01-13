package se.umu.cs.umume.website.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class StartController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    private PersonBean currentPerson;
    
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse arg1) throws Exception {
        
        return new ModelAndView("start");
    }

    public void setCurrentPerson(PersonBean currentPerson) {
        this.currentPerson = currentPerson;
    }

    public PersonBean getCurrentPerson() {  
        return currentPerson;
    }
}
