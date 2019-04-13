package com.niit.jobmanagement.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.jobmanagement.entities.Jobs;
import com.niit.jobmanagement.entities.Resume;
import com.niit.jobmanagement.entities.User;
import com.niit.jobmanagement.repos.JobsRepository;
import com.niit.jobmanagement.repos.ResumeRepository;
import com.niit.jobmanagement.repos.UserRepository;

@Controller
public class UserController {
int count=0;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JobsRepository jobRepository;
	
	@Autowired
	ResumeRepository resumeRepository;
	
	@RequestMapping("/showReg") 
	public String showRegisterationPage()
	{
		System.out.println(" %%%%%%%%%%%%%%%%  showing register");
		return "login/registerUser";
	}
	
	
	
	
	@RequestMapping("/showLogout") 
	public String showLogout(HttpServletRequest request)
	{
		HttpSession s=request.getSession();
		s.invalidate();
		System.out.println(" %%%%%%%%%%%%%%%%  showing showLogout");
		//HttpSession session = request.

		//session.invalidate();
		
		
		return "login/login";
	}
	
	
	
	

	@RequestMapping("/userError") 
	public String showError(ModelMap modelMap)
	{
		return"login/userError";
	}
	
	
	
	Set<String>category=new TreeSet<>(); 
	Set<String>location=new TreeSet<>(); 
	Set<String>experience=new TreeSet<>(); 
	
	
	
	
	@RequestMapping("/userModule") 
	public String showuserModule(ModelMap modelMap)
	{	System.out.println("oooooo "+count);
		if(count!=0) {
			List<Jobs> jobs=jobRepository.findAll();
			modelMap.put("jobs", jobs);
			 modelMap.put("category", category);
			 modelMap.put("location", location);
			 modelMap.put("experience", experience);
		return "login/userModule";
		}
		else
			return showLoginPage();
	}
	
	
	
	
	@RequestMapping("/showLogin") 
	public String showLoginPage()
	{
		System.out.println(" %%%%%%%%%%%%%%%%  showing login");
		return "login/login";
	}
	
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@RequestParam("email")String email,@ModelAttribute("user") User user, ModelMap modelMap)
	{
		
		System.out.println("lklklaklaklaka:   "+user.getEmail());
		
		userRepository.save(user);
		User u=userRepository.findByEmail(email);
		
		System.out.println("email is: "+u.getId());
		modelMap.addAttribute("userid",u.getId());
		System.out.println("role check"+u.getRole());
		if(user.getRole().equals("Job Seeker"))
		{
			System.out.println("heeeeeeeeeeeeeeeeeee");
			return "register/resume";
		}
		else
		{
			System.out.println("----------------------------------");
			return "login/login";
		}
	}
	
	
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	@RequestMapping("/login") 
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,ModelMap modelMap,HttpSession session)
	{
		System.out.println("in login module");
		
		User user=userRepository.findByEmail(email);
		
		List<Jobs> jobs=jobRepository.findAll();
		
		if(user==null) {
			modelMap.addAttribute("msg", "Invalid username or password.Please try again...");
			return"login/login";
		}
		else {
			
		System.out.println("user "+user);
		System.out.println("***********************************************    "+user.getPassword()+"    "+password);
		
		if(user.getPassword().equals(password))
		{
			if(user.getRole().equals("Job Seeker"))
			{	count++;
				
				System.out.println("listinggg "+user.getId());
				
				List<Resume> resume=resumeRepository.findAll();
				
				session.setAttribute("username", email);
				session.setAttribute("userid", user.getId());
				
				
				
				for(int i=0;i<jobs.size();i++)
				{
					category.add(jobs.get(i).getCategory());
					location.add(jobs.get(i).getLocation());
					experience.add(jobs.get(i).getExperience());
				}
				
	//	List<Set>list=new ArrayList<>();
		
//		list.add(category);
//		list.add(location);
//		list.add(experience);
//				
//				
			//list.get(0).stream().forEach(a -> System.out.println("YOYOYO  "+a));
				
				
				for(int i=0;i<resume.size();i++)
				{
					System.out.println("-------- "+user.getId()+" "+resume.get(i).getUser().getId());
					if(user.getId().equals(resume.get(i).getUser().getId()))
					{
						session.setAttribute("resume", resume.get(i).getId());
					}
					
					
				}
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$      "+resume.size()+" "+resume.get(0).getId());
				
				
				System.out.println("jobbbsss "+jobs.get(0).getCategory());
				
				 modelMap.put("jobs", jobs);
				 modelMap.put("category", category);
				 modelMap.put("location", location);
				 modelMap.put("experience", experience);
				//session.setAttribute("flag1", 0);
				return "login/userModule";
			}
			else {
				count++;
				System.out.println("*************** hr module ************** ");
				System.out.println("email "+email);
				System.out.println("id" +user.getId());
				session.setAttribute("username", email);
				session.setAttribute("userid", user.getId());
				
				 modelMap.put("jobs", jobs);
				 System.out.println("endingr3");
				 modelMap.put("category", category);
				 modelMap.put("location", location);
				 modelMap.put("experience", experience);
				 System.out.println("ending");
				return "login/hrModule";
			}
			
		}
		else {
			count=0;
			modelMap.addAttribute("msg", "Invalid username or password.Please try again...");
		
		}
		
		return"login/login";
	}
	
	}
	
	
	
}
