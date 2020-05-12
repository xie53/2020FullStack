package com.ibm.business.util;

import java.util.Iterator;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderUtil {

    public HttpHeaders createDefaultResponseHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }
    
    public void setHttpHeaders(HttpHeaders httpHeaders, Map<String, String> headers) {
        if (httpHeaders != null && headers != null && !headers.isEmpty()) {
            Iterator<String> keyIter = headers.keySet().iterator();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                String val = headers.get(key);
                httpHeaders.add(key, val);
            }
        }
    }
    
    
    public void setHttpHeaders(ResponseEntity.BodyBuilder builder, Map<String, String> headers) {
        if ( builder != null && headers != null && !headers.isEmpty()) {
            Iterator<String> keyIter = headers.keySet().iterator();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                String val = headers.get(key);
                builder.header(key, val);
            }
        }
    }
}
