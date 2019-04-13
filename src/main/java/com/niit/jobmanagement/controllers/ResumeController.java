package com.niit.jobmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.niit.jobmanagement.entities.Resume;
import com.niit.jobmanagement.entities.User;
import com.niit.jobmanagement.repos.ResumeRepository;
import com.niit.jobmanagement.repos.UserRepository;

@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ResumeRepository resumeRepository;
	
	

	@RequestMapping("/showResume")
	public String showResume()
	{
		System.out.println("LOLOLOLOLO");
		
		return"register/resume";
	}
	
	
	
	@RequestMapping(value="/registerResume",method=RequestMethod.POST)
	public String registerResume(@RequestParam("email")String email,@RequestParam("resumeFile")String resumefile,@ModelAttribute("resume") Resume resume,ModelMap modelMap)
	{
		System.out.println("lalalalala");
		User user=userRepository.findByEmail(email);
		System.out.println("in resume email: "+email);
		Resume res=new Resume();
		User user1=new User();
		user1.setUserId(Long.parseLong(email));
		user1.setId(user1.getUserId());
		res.setUser(user1);
		res.setResumefile(resumefile.getBytes());
		//System.out.println("users id is: "+user.getId());
		//userRepository.save(user);
		resumeRepository.save(res);
		
		//return "login/login";
		
		return"redirect:/showLogin";
	}
	
	
	
}
