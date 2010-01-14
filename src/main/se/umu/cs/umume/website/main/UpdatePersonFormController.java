package se.umu.cs.umume.website.main;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import se.umu.cs.umume.website.rest.UmumeRestUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class UpdatePersonFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    //protected final Log logger = LogFactory.getLog(getClass());
    private static final Logger logger = LoggerFactory.getLogger(UpdatePersonFormController.class);
    private String httpsRestService = "https://mega.cs.umu.se:8443/umume-rest/";
    private String httpRestService = "http://mega.cs.umu.se:8080/umume-rest/";
    
    public ModelAndView onSubmit(Object command) throws ServletException {
        String userName = ((PersonBean) command).getUid();
        String ticket = ((PersonBean) command).getTicket();
        try {
            Client client = Client.create();
            String httpsResourceAddress = httpsRestService + "users/" 
            + userName + "?ticket=" + ticket 
            + "&service="+URLEncoder.encode("http://localhost:8080/umume/updateperson.htm?username="+userName,"UTF-8");
            ClientResponse response = UmumeRestUtil.updateUser((PersonBean) command, httpsResourceAddress);
            // TODO: verify response

        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        } catch (KeyManagementException e) {
            logger.error(e.getMessage());
        }
        return new ModelAndView(getSuccessView(), "username", userName);
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws ServletException {
        logger.info("formBackingObject()");
        PersonBean updatePerson = new PersonBean();

        String userName = request.getParameter("username");

        JAXBContext jc;
        PersonBean person = null;
        try {
            jc = JAXBContext.newInstance(PersonBean.class);

            Unmarshaller u = jc.createUnmarshaller();
            URL url = new URL(
                    httpRestService + "users/"+userName);
            person = (PersonBean) u.unmarshal(url);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        updatePerson.setDescription(person.getDescription());
        updatePerson.setTwitterName(person.getTwitterName());
        updatePerson.setTicket(request.getParameter("ticket"));
        updatePerson.setUid(request.getParameter("username"));

        return updatePerson;
    }
}
