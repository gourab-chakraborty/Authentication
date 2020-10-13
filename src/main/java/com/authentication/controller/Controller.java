package com.authentication.controller;

import java.io.IOException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PreAuthorize("hasAuthority('administrator')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String welcomeAdmin(@RequestHeader(value = "Authorization", required = false) String authorization)
	    throws IOException {
	return "welcome admin";

    }

    @PreAuthorize("hasAuthority('manager')")
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String welcomeManager(@RequestHeader(value = "Authorization", required = false) String authorization)
	    throws IOException {
	return "welcome manager";

    }
}
