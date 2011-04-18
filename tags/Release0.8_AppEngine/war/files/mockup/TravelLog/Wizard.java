package com.amazon.aws.samplecode.travellog.web;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Journal;
import com.amazon.aws.samplecode.travellog.entity.User;

public class Wizard {

	public static void runWizard(TravelLogDAO dao, ModelMap model) {

		// We need to launch the bootstrap interface
		model.addAttribute("bootstrap", true);

		if (model.get("user") == null) {
			List<User> users = dao.getUsers();
			if (users.size() > 0) {
				// One user exists in the database which is all we need
				model.addAttribute("usercreated", true);

			}
			model.addAttribute("user", new User());
		}
		if (model.get("journal") == null) {
			model.addAttribute("journal", new Journal());
		}
		return;
	}

}
