package com.huyinsong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityserverApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	@WithMockUser(username= "admin", roles= {"admin"})
	public void sayHello() {
		
	}

}
