package se.umu.cs.umume.website.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class UserController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Jonny");
        /*
        Client client = Client.create();
        WebResource webResource = client.resource("http://example.com/base");
        String s = webResource.get(String.class);
        */

        return new ModelAndView("user", "user", model);
    }

}
