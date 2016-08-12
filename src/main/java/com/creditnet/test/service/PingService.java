package com.creditnet.test.service;

import com.creditnet.test.domain.Pong;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by scan on 12.08.16.
 */
@Service
public class PingService {

    public Pong ping() {
        return new Pong("pong", LocalDateTime.now());
    }

}
