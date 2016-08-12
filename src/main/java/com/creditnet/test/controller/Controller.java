package com.creditnet.test.controller;

import com.creditnet.test.domain.Pong;
import com.creditnet.test.service.PingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private PingService pingService;

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    public ResponseEntity<Pong> ping() {
        logger.info("processing ping reqest");
        return new ResponseEntity<Pong>(
                pingService.ping(),
                HttpStatus.OK
        );
    }



}
