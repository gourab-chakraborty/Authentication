package com.authentication.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class GlobalConfiguration {

    @Value("#{${users}}")
    private Map<String, String> users;

    public Map<String, String> fetchUserDetails(String username) {

	final Map<String, String> result = new HashMap<String, String>();

	final String user = users.get(username);

	final String[] userInfo = user.split(",");

	result.put("Password", userInfo[0]);
	result.put("Role", userInfo[1]);

	return result;
    }

}
