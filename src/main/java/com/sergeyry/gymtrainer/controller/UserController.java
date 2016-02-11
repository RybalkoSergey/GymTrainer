package com.sergeyry.gymtrainer.controller;

import com.sergeyry.gymtrainer.model.User;
import com.sergeyry.gymtrainer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isUserLoginUnique(user.getLogin())){
			FieldError loginError =new FieldError("user","login",messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
		    result.addError(loginError);
			return "registration";
		}
		
		service.saveUser(user);

		model.addAttribute("success", "Employee " + user.getFirstName() + " registered successfully");
		return "success";
	}

	@RequestMapping(value = { "/edit-{login}-employee" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String login, ModelMap model) {
		User employee = service.findUserByLogin(login);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isUserLoginUnique(user.getLogin())){
			FieldError loginError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
		    result.addError(loginError);
			return "registration";
		}

		service.updateUser(user);

		model.addAttribute("success", "Employee " + user.getFirstName() + " updated successfully");
		return "success";
	}

	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String login) {
		service.deleteUserByLogin(login);
		return "redirect:/list";
	}
}
