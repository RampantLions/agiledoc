package com.amazon.aws.samplecode.travellog.features.users;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.User;

/**
 * 
 * @Requirement
 */
public class VerifyUser {

	public static void verify(User user, BindingResult result,
			String password2) {

		// Verify user info submission
		if (user.getUsername().equals("")) {
			result.reject("username", "Username cannot be blank");
		}
		if (user.getPassword().equals("")) {
			result.reject("password", "Password cannot be blank");
		}
		if (!user.getPassword().equals(password2)) {
			result.reject("password", "Passwords do not match");
		}

	}

	public static void saveUser(TravelLogDAO dao, User user, ModelMap map) {

		dao.saveUser(user);
		map.addAttribute("usercreated", true);
	}

}
