package com.creditnet.test.controller;

import com.creditnet.test.domain.Pong;
import com.creditnet.test.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by scan on 12.08.16.
 */
@RestController
public class Controller {

    @Autowired
    private PingService pingService;

    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public ResponseEntity<Pong> ping() {
        return new ResponseEntity<Pong>(
                pingService.ping(),
                HttpStatus.OK
        );
    }


}
