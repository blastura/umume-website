package se.umu.cs.umume.website.rest;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class UmumeRestVerified implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        // TODO: What should be checked? 
        return true;
    }
}
