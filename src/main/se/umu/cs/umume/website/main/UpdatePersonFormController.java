package se.umu.cs.umume.website.main;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UpdatePersonFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    //protected final Log logger = LogFactory.getLog(getClass());
    private static final Logger logger = LoggerFactory.getLogger(UpdatePersonFormController.class);

    public ModelAndView onSubmit(Object command) throws ServletException {

        /*
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted( java.security.cert.X509Certificate[] certs, String authType ) {
                }
                public void checkServerTrusted( java.security.cert.X509Certificate[] certs, String authType ) {
                }
            }
        };
        // Install the all-trusting trust manager
        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance( "SSL" );
            sc.init( null, trustAllCerts, new java.security.SecureRandom() );
            HttpsURLConnection.setDefaultSSLSocketFactory( sc.getSocketFactory() );
        }
        catch ( Exception e ) {
            //We can not recover from this exception.
            e.printStackTrace();
        }
         */
        /*
        ClientConfig config = new DefaultClientConfig();
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(null, sc));
        Client client = Client.create(config);
         */


        PersonBean person = new PersonBean();
        String userName = ((UpdatePerson) command).getUserName();
        String ticket = ((UpdatePerson) command).getTicket();
        person.setTwitterName(((UpdatePerson) command).getTwitter());
        person.setDescription(((UpdatePerson) command).getDescription());
        try {
            Client client = Client.create();
            WebResource webResource;
            webResource = client.resource("http://192.168.0.5:8080/UmuMeREST/users/"+userName+"?ticket="+ticket 
                    + "&service="+URLEncoder.encode("http://localhost:8080/springapp/updateperson.htm?username="+userName,"UTF-8"));

            ClientResponse response = webResource.type("application/xml").put(ClientResponse.class, person);
            logger.error(response.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ModelAndView(getSuccessView(), "username", userName);
    }

    protected Object formBackingObject(HttpServletRequest request)
    throws ServletException {
        UpdatePerson updatePerson = new UpdatePerson();

        String userName = request.getParameter("username");

        JAXBContext jc;
        PersonBean person = null;
        try {
            jc = JAXBContext.newInstance(PersonBean.class);

            Unmarshaller u = jc.createUnmarshaller();
            URL url = new URL(
                    "http://192.168.0.5:8080/UmuMeREST/users/"+userName);
            person = (PersonBean) u.unmarshal(url);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        updatePerson.setDescription(person.getDescription());
        updatePerson.setTwitter(person.getTwitterName());
        updatePerson.setTicket(request.getParameter("ticket"));
        updatePerson.setUserName(request.getParameter("username"));

        return updatePerson;
    }
}
