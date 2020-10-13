package com.authentication.service;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.config.GlobalConfiguration;
import com.authentication.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GlobalConfiguration globalConfiguration;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

	// $2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6 = password

	// Here user details with encrypted password is returned and password is matched
	// with input

	// Return user with encrypted password from database

	System.out.println(userRepository.findByUserName(userName));

	final Map<String, String> user = globalConfiguration.fetchUserDetails(userName);

	if (MapUtils.isNotEmpty(user)) {

	    return new User(userName, user.get("Password"),
		    Arrays.asList(new SimpleGrantedAuthority(user.get("Role"))));

	} else {
	    throw new UsernameNotFoundException("User not found with username: " + userName);
	}

    }
}