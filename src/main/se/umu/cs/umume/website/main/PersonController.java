package se.umu.cs.umume.website.main;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class PersonController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private String restService = "http://mega.cs.umu.se:8080/umume-rest/";

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse arg1) throws Exception {
        String userName = request.getParameter("username");
        logger.info("Req URL: {}, username: {}", request.getRequestURL(), userName);

        JAXBContext jc;
        PersonBean person = null;
        try {
            jc = JAXBContext.newInstance(PersonBean.class);

            Unmarshaller u = jc.createUnmarshaller();
            URL url = new URL(
                    restService + "users/" + userName);

            person = (PersonBean) u.unmarshal(url);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //        Map<String, Object> model = new HashMap<String, Object>();
        //        model.put("name", person.getGivenName());
        //        model.put("tweets", person.getTweets());
        //        model.put("description", person.getDescription());
        //        model.put("username", userName);

        return new ModelAndView("person", "person", person);
    }
}
