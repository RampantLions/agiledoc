package com.amazon.aws.samplecode.travellog.features.users;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.User;

/**
 * 
 * @Requirement
 */
public class SaveUser {

	public static void save(TravelLogDAO dao, User user, ModelMap map) {

		dao.saveUser(user);
		map.addAttribute("usercreated", true);
	}

}
