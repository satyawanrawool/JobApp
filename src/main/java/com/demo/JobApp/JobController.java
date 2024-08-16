package com.demo.JobApp;

import com.demo.JobApp.model.JobPost;
import com.demo.JobApp.repo.JobRepo;
import com.demo.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    public JobService service;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(JobPost jobPost){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

}
