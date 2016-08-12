package com.creditnet.test;

import com.creditnet.test.domain.Pong;
import com.creditnet.test.service.PingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by scan on 12.08.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PingServiceTest {

    private PingService pingService;

    @Before
    public void init() {
        pingService = new PingService();
    }

    @Test
    public void pingTest() {

        Pong pong = pingService.ping();

        Assert.assertNotNull(pong);
        Assert.assertNotNull(pong.getMessage());
        Assert.assertNotNull(pong.getLocalDateTime());
    }

}
