package se.umu.cs.umume.website.main;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UpdatePersonFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private PersonBean currentPerson;

    public ModelAndView onSubmit(Object command) throws ServletException {

        String description = ((UpdatePerson) command).getDescription();
        String twitter = ((UpdatePerson) command).getTwitter();
        String password = ((UpdatePerson) command).getPassword();
        
        try {
            URL url = new URL(
                    "http://localhost:8080/UmuMeREST/users/"+currentPerson.getInstitution());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request)
            throws ServletException {
        UpdatePerson updatePerson = new UpdatePerson();
        return updatePerson;
    }

    public void setCurrentPerson(PersonBean currentPerson) {
        this.currentPerson = currentPerson;
    }

    public PersonBean getCurrentPerson() {
        return currentPerson;
    }

}
