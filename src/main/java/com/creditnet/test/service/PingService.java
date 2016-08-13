package com.creditnet.test.service;

import com.creditnet.test.domain.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by scan on 12.08.16.
 */
@Service
public class PingService {

    private final static Logger logger = LoggerFactory.getLogger(PingService.class);

    public Pong ping() {
        return new Pong("pong", LocalDateTime.now());
    }

}
