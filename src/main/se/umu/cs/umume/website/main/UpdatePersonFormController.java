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

import se.umu.cs.umume.website.lek.ProductManager;

public class UpdatePersonFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private PersonBean currentPerson;

    public ModelAndView onSubmit(Object command) throws ServletException {

        String userName = ((FindPerson) command).getUserName();

        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(PersonBean.class);

            Unmarshaller u = jc.createUnmarshaller();
            URL url = new URL(
                    "http://mega.cs.umu.se:8080/UmuMeREST/users/"+userName);
            PersonBean o = (PersonBean) u.unmarshal(url);
            currentPerson.setGivenName(o.getGivenName());
            
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request)
            throws ServletException {
        FindPerson findUser = new FindPerson();
        return findUser;
    }

    public void setCurrentPerson(PersonBean currentPerson) {
        this.currentPerson = currentPerson;
    }

    public PersonBean getCurrentPerson() {
        return currentPerson;
    }

}
