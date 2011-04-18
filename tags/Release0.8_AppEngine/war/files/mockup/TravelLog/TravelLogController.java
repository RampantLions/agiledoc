/*
 * Copyright 2010-2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.aws.samplecode.travellog.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.aws.samplecode.travellog.aws.TravelLogSNSManager;
import com.amazon.aws.samplecode.travellog.dao.TravelLogDAO;
import com.amazon.aws.samplecode.travellog.entity.Comment;
import com.amazon.aws.samplecode.travellog.entity.Entry;
import com.amazon.aws.samplecode.travellog.entity.Journal;
import com.amazon.aws.samplecode.travellog.entity.Photo;
import com.amazon.aws.samplecode.travellog.entity.User;
import com.amazon.aws.samplecode.travellog.features.comments.AddComment;
import com.amazon.aws.samplecode.travellog.features.comments.DeleteComment;
import com.amazon.aws.samplecode.travellog.features.comments.GetComment;
import com.amazon.aws.samplecode.travellog.features.journal.CreateJournal;
import com.amazon.aws.samplecode.travellog.features.journal.DeleteJournal;
import com.amazon.aws.samplecode.travellog.features.photos.DeletePhoto;
import com.amazon.aws.samplecode.travellog.features.photos.GetPhoto;
import com.amazon.aws.samplecode.travellog.features.photos.UploadPhoto;
import com.amazon.aws.samplecode.travellog.features.users.VerifyUser;
import com.amazon.aws.samplecode.travellog.util.DataExtractor;
import com.amazon.aws.samplecode.travellog.util.DataLoader;

/**
 * By default, this is the root or default resource in your application, but can
 * be configured for each environment.
 * 
 * @Architecture
 */
public class TravelLogController {

	private TravelLogDAO dao;
	private static final Logger logger = Logger.getLogger(AddComment.class
			.getName());

	/**
	 * AWS Elastic Beanstalk checks your application's health by periodically
	 * sending an HTTP HEAD request to a resource in your application. By
	 * default, this is the root or default resource in your application, but
	 * can be configured for each environment.
	 * 
	 * Here, we report success as long as the app server is up, but skip
	 * generating the whole page since this is a HEAD request only. You can
	 * employ more sophisticated health checks in your application.
	 * 
	 * @param model
	 *            the spring model for the request
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.HEAD)
	public void doHealthCheck(HttpServletResponse response) {
		response.setContentLength(0);
		response.setStatus(HttpServletResponse.SC_OK);
	}

	/**
	 * The main request handler that builds out the home page for the journal
	 * 
	 * @param model
	 *            the spring model for the request
	 */
	@RequestMapping(value = "/home.do", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void doHome(ModelMap model) {
		new Home(dao, model);
	}

	/**
	 * If we have a login failure this request mapping flags the error to be
	 * shown in the UI.
	 * 
	 * @param model
	 *            the spring model for the request
	 */
	@RequestMapping("/loginFailure.do")
	public ModelAndView doLoginFailure(ModelMap map) {
		map.addAttribute("popupScreen", "login_div");
		doHome(map);
		return new ModelAndView("home", map);
	}

	@RequestMapping("/createAccount.do")
	public ModelAndView doCreateAccount(User user, BindingResult result,
			ModelMap map, @RequestParam("password2") String password2) {

		VerifyUser.verify(user, result, password2);

		if (result.hasErrors()) {
			doHome(map);
			return new ModelAndView("home", map);
		}

		// check to make sure we don't have a user account already
		List<User> users = dao.getUsers();
		if (users.size() > 0) {
			result.reject("username", "The admin user already exists");
			return new ModelAndView("home", map);
		} else {

			VerifyUser.saveUser(dao, user, map);
		}

		doHome(map);
		return new ModelAndView("redirect:home.do");

	}

	@RequestMapping("/createJournal.do")
	public ModelAndView doCreateJournal(Journal journal, BindingResult result,
			@RequestParam("preload") boolean preload, ModelMap map) {

		new CreateJournal(dao, journal, result, preload, map, logger);

		doHome(map);
		if (result.hasErrors()) {
			return new ModelAndView("home", map);
		} else {
			return new ModelAndView("redirect:home.do");
		}
	}

	@RequestMapping("/deleteEntry.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doDeleteEntry(@RequestParam("entryId") String entryId,
			ModelMap map) {

		DeleteJournal.delete(dao, entryId);

		doHome(map);
		return new ModelAndView("redirect:home.do");
	}

	@RequestMapping("/deletePhoto.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doDeletePhoto(@RequestParam("photoId") String photoId,
			ModelMap map) {

		Photo photo = GetPhoto.get(dao, photoId);

		if (photo == null) {
			// Photo shouldn't ever be null, but just in case we handle it
			doHome(map);
			return new ModelAndView("redirect:home.do");
		}

		DeletePhoto.delete(dao, photo, map);

		doHome(map);
		return new ModelAndView("redirect:home.do");

	}

	@RequestMapping("/deleteComment.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doDeleteComment(
			@RequestParam("commentId") String commentId, ModelMap map) {

		Comment comment = GetComment.get(dao, commentId, map);

		if (comment == null) {
			// Photo shouldn't ever be null, but just in case we handle it
			doHome(map);
			return new ModelAndView("redirect:home.do");
		}

		DeleteComment.doDelete(dao, comment);

		doHome(map);
		return new ModelAndView("redirect:home.do");

	}

	@RequestMapping("/saveEntry.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doSaveEntry(Entry entry, BindingResult result,
			ModelMap map) {
		if (entry.getTitle().length() == 0) {
			result.reject("title", "You must enter a title for this entry");
		}

		if (result.hasErrors()) {
			doHome(map);
			map.addAttribute("popupScreen", "entry_div");
			return new ModelAndView("home", map);
		}
		Journal journal = dao.getJournal();
		entry.setJournal(journal);

		// Make an initial save to get entry id populated
		dao.saveEntry(entry);

		TravelLogSNSManager sns = new TravelLogSNSManager();
		sns.createTopic(entry);

		// save with arn set
		dao.saveEntry(entry);

		doHome(map);
		return new ModelAndView("redirect:home.do");
	}

	@RequestMapping("/saveComment.do")
	public ModelAndView doSaveComment(Comment comment, BindingResult result,
			ModelMap map, HttpServletRequest request) {

		AddComment.verifyComment(comment, result);

		if (result.hasErrors()) {
			doHome(map);
			map.addAttribute("popupScreen", "comment_div");
			return new ModelAndView("home", map);
		}

		AddComment.addComment(dao, comment, request);

		doHome(map);

		return new ModelAndView("redirect:home.do");
	}

	@RequestMapping("/uploadPhoto.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doUploadPhoto(Photo photo, BindingResult result,
			@RequestParam("file") MultipartFile file,
			@RequestParam("entryId") String entryId, ModelMap map) {
		try {
			Entry entry = dao.getEntry(entryId);
			photo.setEntry(entry);

			if (file.getSize() > 0) {

				UploadPhoto.savePhoto(dao, photo, file);

			} else if (file.getSize() == 0
					&& StringUtils.isEmpty(photo.getId())) {
				// No file uploaded for a new photo, so error out
				result.reject("file", "You must specify a photo to upload");
				doHome(map);
				map.addAttribute("popupScreen", "photo_div");
				return new ModelAndView("home", map);
			} else {

				UploadPhoto.updatePhoto(dao, photo);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			result.reject("file", "There was an error uploading the photo");
			doHome(map);
			map.addAttribute("popupScreen", "photo_div");
			return new ModelAndView("home", map);
		}

		doHome(map);
		return new ModelAndView("redirect:home.do");
	}

	@RequestMapping("/logout.do")
	public void doLogout(HttpServletResponse response) throws IOException {
		response.sendRedirect("home.do");
	}

	@RequestMapping("/backupRestore.do")
	@Secured("ROLE_ADMIN")
	public ModelAndView doBackupRestore(ModelMap map,
			@RequestParam("backupBucket") String bucketName,
			@RequestParam("backupPath") String storagePath,
			@RequestParam("backupRestoreFlag") String flag) {

		final Thread thread;
		if (flag.equals("backup")) {
			DataExtractor extractor = new DataExtractor(bucketName,
					storagePath, dao);
			thread = new Thread(extractor);
		} else {
			DataLoader loader = new DataLoader(bucketName, storagePath, dao);
			thread = new Thread(loader);
		}

		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doHome(map);
		return new ModelAndView("redirect:home.do");
	}

	@Autowired
	public void setTravelLogDAO(TravelLogDAO dao) {
		this.dao = dao;
	}

	/**
	 * Method establishes the transformation of incoming date strings into Date
	 * objects
	 * 
	 * @param binder
	 *            the spring databinder object that we connect to the date
	 *            editor
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
