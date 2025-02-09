package com.timetable.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.timetable.entity.User;
import com.timetable.service.UserService;
import com.timetable.utility.Constants.ActiveStatus;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = this.userService.getUserByEmailAndStatus(email, ActiveStatus.ACTIVE.value());

		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails;

	}
}
