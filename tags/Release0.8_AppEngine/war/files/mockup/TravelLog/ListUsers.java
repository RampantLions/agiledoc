package com.amazon.aws.samplecode.travellog.features.users;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.User;

public class ListUsers {

	public static List<User> list(TravelLogDAO dao, ModelMap model) {

		List<User> users = dao.getUsers();

		return users;
	}

}
