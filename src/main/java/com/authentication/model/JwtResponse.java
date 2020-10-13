package com.authentication.model;

import lombok.Getter;

public class JwtResponse {

    @Getter
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
	this.jwttoken = jwttoken;
    }

}
