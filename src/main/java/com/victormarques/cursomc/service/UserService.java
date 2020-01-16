package com.victormarques.cursomc.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.victormarques.cursomc.security.UserSS;

public class UserService {

	public static UserSS authenticate() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}

	}

}
