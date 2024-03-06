package com.wahid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wahid.models.LoginModel;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/login") // the default path for this controller to handle an event
public class LoginController {
	
	//Method to show the login form 
	@GetMapping("/")
	public String displayLoginForm(Model model)
	{
		model.addAttribute("loginModel", new LoginModel());
		return "loginForm.html";
	}
	
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("****************** Invalid Data");
			model.addAttribute("loginModel", loginModel); // send the 
			//login form back to the login form 
			return "loginForm.html"; // return back to login page and try again
		}
	    String username = loginModel.getUsername();
	    String password = loginModel.getPassword();
	    String email = loginModel.getEmail();
	    System.out.println("username: " + username);
	    System.out.println("email: " + email );
	    System.out.println("password: " + password);
		model.addAttribute("loginModel", loginModel);
		return "loginResults.html";
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
}
