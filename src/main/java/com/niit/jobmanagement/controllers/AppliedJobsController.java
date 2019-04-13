package com.niit.jobmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.jobmanagement.entities.AppliedJobs;
import com.niit.jobmanagement.entities.Jobs;
import com.niit.jobmanagement.entities.Resume;
import com.niit.jobmanagement.entities.User;
import com.niit.jobmanagement.repos.AppliedJobsRepository;

@Controller
@RequestMapping("/appliedjobs")
public class AppliedJobsController {


	@Autowired
	AppliedJobsRepository ajobrepo;
	


	@RequestMapping(value="/apply",method=RequestMethod.POST)
	public String register(@RequestParam("userid")String uid,@RequestParam("resumeid")String resid,@RequestParam("jobid")String jid,@ModelAttribute("apply") AppliedJobs ajobs, ModelMap modelMap,HttpServletRequest request,HttpServletResponse response)
	{
		int flag=0;
		Long ui=Long.parseLong(uid.replaceAll("\\/",""));
		Long ri=Long.parseLong(resid.replaceAll("\\/",""));
		Long ji=Long.parseLong(jid.replaceAll("\\/",""));
		
		/*
		ajobs.getUser().setId(ui);
		ajobs.getResume().setId(ri);
		ajobs.getJobs().setId(ji);//myString.replaceAll("\\/","");
		*/
		User user = new User();
		Jobs jobs=new Jobs();
		Resume resume=new Resume();
		user.setId(ui);
		jobs.setId(ji);
		resume.setId(ri);
		ajobs.setUser(user);
		ajobs.setJobs(jobs);
		ajobs.setResume(resume);
		
List<AppliedJobs>apjobs=ajobrepo.findAll();



System.out.println("************************************************************************");
for(int i=0;i<apjobs.size();i++)
{
	System.out.println(apjobs.toString());
}




if(apjobs.size()>0)
{
	for(int i=0;i<apjobs.size();i++)
	{
		System.out.println("aplyingggggggggggggggggg");
		if((apjobs.get(i).getUser().getId().equals(ui) )&& (apjobs.get(i).getResume().getId().equals(ri) )&& (apjobs.get(i).getJobs().getId().equals(ji)))
		{
			System.out.println("errror aa gya");
			modelMap.addAttribute("err", "alredy applied");
			
			request.setAttribute("err", "alredy applied");
			return"redirect:/userError";
		}
	}
}


		
		System.out.println("lalalaa "+ajobs.getUser().getId());
		
		System.out.println("!!!!!     "+ajobs+"  "+uid.replaceAll("\\/","")+"  "+resid.replaceAll("\\/","")+" "+jid.replaceAll("\\/",""));
		if(ajobrepo.save(ajobs)!=null) {
			flag++;
		System.out.println("Successfully applied");
		
		
		
		}
		System.out.println("fklagging "+flag);
		modelMap.addAttribute("flag", flag);
		return"redirect:/userModule";
	
	}
	









}
