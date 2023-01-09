package me.practice.primetime.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"prime"})
public class IsItPrimeController {

    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_XML = "application/xml";
    @RequestMapping(method = RequestMethod.GET,consumes = {"application/json"},
                                                produces = {"application/json","application/xml"})
    public ResponseEntity<Boolean> getPrime(@RequestHeader(HttpHeaders.ACCEPT) String acceptHeader){
        MediaType mediaType = null;
        if(APPLICATION_JSON.equals(acceptHeader))
            mediaType = MediaType.APPLICATION_JSON;
        else if (APPLICATION_XML.equals(acceptHeader)){
            mediaType = MediaType.APPLICATION_XML;
        }

        ResponseEntity<Boolean> response = ResponseEntity.accepted().contentType(mediaType).body(Boolean.TRUE);
        return response;
    }
}
