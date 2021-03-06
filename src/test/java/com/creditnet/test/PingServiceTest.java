package com.creditnet.test;

import com.creditnet.test.domain.Pong;
import com.creditnet.test.service.PingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by scan on 12.08.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PingServiceTest {

    @Autowired
    private PingService pingService;

    @Test
    public void pingTest() {

        Pong pong = pingService.ping();

        Assert.assertNotNull(pong);
        Assert.assertNotNull(pong.getMessage());
        Assert.assertNotNull(pong.getLocalDateTime());
        Assert.assertNotNull(pong.getVersion());
    }

}
