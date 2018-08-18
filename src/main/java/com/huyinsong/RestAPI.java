package com.huyinsong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {
	
    @PreAuthorize("#oauth2.hasScope('admin') and hasRole('ROLE_ADMIN')")
	@GetMapping("/hello")
	public String hello(HttpServletRequest req) {
		return "hello world";
	}
}
