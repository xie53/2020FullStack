package com.ibm.business.remote.bean;

import java.util.Iterator;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RemoteApiServerResponseConverter<T> {

    public ResponseEntity<T> toResponseEntity(RemoteApiServerResponse<T> res) {
        ResponseEntity.BodyBuilder responseEntityBuilder = ResponseEntity.status(HttpStatus.OK);
        Map<String, String> headers = res.getHeaders();
        if (headers != null && !headers.isEmpty()) {
            Iterator<String> keyIter = headers.keySet().iterator();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                String val = headers.get(key);
                responseEntityBuilder.header(key, val);
            }
        }
        return responseEntityBuilder.body(res.getResponse());
    }

    public ResponseEntity<T> toResponseEntity(RemoteApiServerResponse<T> res,
            HttpHeaders httpHeaders) {
        ResponseEntity.BodyBuilder responseEntityBuilder = ResponseEntity.status(HttpStatus.OK);
        if (httpHeaders != null) {
            responseEntityBuilder.headers(httpHeaders);
        }
        Map<String, String> headers = res.getHeaders();
        if (headers != null && !headers.isEmpty()) {
            Iterator<String> keyIter = headers.keySet().iterator();
            while (keyIter.hasNext()) {
                String key = keyIter.next();
                String val = headers.get(key);
                responseEntityBuilder.header(key, val);
            }
        }
        return responseEntityBuilder.body(res.getResponse());
    }
}
