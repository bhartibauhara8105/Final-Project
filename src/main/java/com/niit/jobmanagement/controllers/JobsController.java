package com.niit.jobmanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.jobmanagement.entities.Jobs;
import com.niit.jobmanagement.entities.User;
import com.niit.jobmanagement.repos.JobsRepository;

@Controller
@RequestMapping("/jobs")
public class JobsController {


	@Autowired
	JobsRepository jobRepository;
	
	
	
	
	
	@RequestMapping(value="/postJobs",method=RequestMethod.POST)
	public String postJobs(@ModelAttribute("jobs") Jobs jobs)
	{
		
		jobRepository.save(jobs);
		
		return "login/hrModule";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/searchJobs",method=RequestMethod.POST)
	public String searchJobs(@ModelAttribute("category") String cat,@RequestParam("location")String loc,@ModelAttribute("experience") String exp, ModelMap modelMap)
	{
		System.out.println("jobbi");
		List<Jobs> jobs=jobRepository.findAll();
		List<Jobs> searchedJobs=new ArrayList<>();
		for(int i=0;i<jobs.size();i++)
		{
			if((jobs.get(i).getCategory().equals(cat))||jobs.get(i).getLocation().equals(loc) || jobs.get(i).getExperience().equals(exp))
			{
				searchedJobs.add(jobs.get(i));
			}
		}
		
		
		
		for(Jobs j:searchedJobs)
		{
			System.out.println("seched Job: "+j.getCategory()+" "+j.getDescription()+" "+j.getExperience()+" "+j.getLocation());
		}
		
		modelMap.put("searchedList", searchedJobs);
		modelMap.addAttribute("searchedList", searchedJobs);
		return"searchedJobs/searchJobs";
	
		
		//return "redirect:jobmanagement/login/userModule";
	}
	
	
	
	
	
	
}
