package com.sergeyry.gymtrainer.controller;

import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.user.User;
import com.sergeyry.gymtrainer.service.program.ProgramService;
import com.sergeyry.gymtrainer.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ProgramService programService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAll();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		if (!userService.isUserLoginUnique(user.getLogin())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.save(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
		User currentUser = userService.findById(id);

		if (currentUser==null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setLogin(user.getLogin());
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPassword(user.getPassword());
		currentUser.setEmail(user.getEmail());
		currentUser.setState(user.getState());

		userService.update(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = { "/user/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

	@RequestMapping(value = { "/user/{id}/program" }, method = RequestMethod.GET)
	public ResponseEntity<List<Program>> getSignedPrograms(@PathVariable int id) {
		List<Program> programs = programService.findByUserId(id);

		if (programs.isEmpty()) {
			return new ResponseEntity<List<Program>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
	}
}
