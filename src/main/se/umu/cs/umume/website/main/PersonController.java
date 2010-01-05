package se.umu.cs.umume.website.main;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class PersonController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    private PersonBean currentPerson;
    
    public ModelAndView handleRequest(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", currentPerson.getGivenName());

        return new ModelAndView("user", "user", model);
    }

    public void setCurrentPerson(PersonBean currentPerson) {
        this.currentPerson = currentPerson;
    }

    public PersonBean getCurrentPerson() {
        return currentPerson;
    }
}
