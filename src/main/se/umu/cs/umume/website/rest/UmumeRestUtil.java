package se.umu.cs.umume.website.rest;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import se.umu.cs.umume.website.main.PersonBean;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

public final class UmumeRestUtil {
    public static ClientResponse updateUser(PersonBean pb, String httpsResourceAddress) throws NoSuchAlgorithmException, KeyManagementException {
        //String https = "https://mega.cs.umu.se:8443/UmuMeREST/users/aonjon04";
        //String http = "http://mega.cs.umu.se:8080/UmuMeREST/users/aonjon04";
        HostnameVerifier hv = new UmumeRestVerified();
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted( java.security.cert.X509Certificate[] certs, String authType ) {}
                    public void checkServerTrusted( java.security.cert.X509Certificate[] certs, String authType ) {}
                }
        };
        // Install the all-trusting trust manager
        SSLContext sc = null;
        // Can throw NoSuchAlgorithmException
        sc = SSLContext.getInstance( "SSL" );
        // Can throw KeyManagementException
        sc.init( null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory( sc.getSocketFactory() );

        ClientConfig config = new DefaultClientConfig();
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(hv, sc));
        Client client = Client.create(config);
        WebResource webResource = client.resource(httpsResourceAddress);
        ClientResponse response = webResource.type("application/xml").put(ClientResponse.class, pb);
        return response;
    }
}
