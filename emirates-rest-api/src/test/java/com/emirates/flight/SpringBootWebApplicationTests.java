package com.emirates.flight;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emirates.flight.SpringBootWebApplication;


/**
 * @author divyang.patel
 * The Class SpringBootWebApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

	/**
	 * Context loads.
	 */
	@Test
	public void contextLoads() {
	}

}
