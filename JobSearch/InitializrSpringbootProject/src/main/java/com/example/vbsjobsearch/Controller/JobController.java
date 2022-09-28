package com.example.vbsjobsearch.Controller;

import com.example.vbsjobsearch.Exceptions.statusInvalidException;
import com.example.vbsjobsearch.Model.Job;
import com.example.vbsjobsearch.Service.JobService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JobController {
    public JobService service;
    public boolean isValidUuid;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping (value = "/addjob")
    public Job addJob(@RequestBody Job a){
        return this.service.addJobs(a);
    }
    
    @GetMapping (value = "/alljob")
    public List<Job> getAllJob(){
        return this.service.getAllJobs();
    }
    
    @PostMapping (value = "/updatejob")
    public Job updateApplication(Job job){
        return this.service.updateJob(job);
    }
    
    @GetMapping (value = "/deletejob")
    public void deleteJob(@RequestParam Integer id){
        this.service.deleteJob(id);
    }
    
    @GetMapping (value = "/jobbyid")
    public Job getById(@RequestParam Integer id){
        return this.service.getById(id);
    }
    
    @GetMapping (value = "/chechuuid")
    public String checkUuidValidation(@RequestParam String uuid) throws statusInvalidException{
        try{
            this.isValidUuid = this.service.checkUUID(uuid);
            return "Valid UUID...";
        }catch(Exception ex){
            return ex.getMessage();
        }
    }
    
    @GetMapping (value = "/searchjob")
    public String searchJob(@RequestParam String title) throws statusInvalidException{
            try{
                List<Job> searcResult = new ArrayList<Job>();
                searcResult = this.service.searchJob(title);
                if (!searcResult.isEmpty()){
                    String json = new Gson().toJson(searcResult);
                    return json;
                }
                else
                {
                    String json = new Gson().toJson("No results found");
                    return json;
                }
            }
            catch(Exception ex){
                return ex.getMessage();
            }
        
    }
    
    @GetMapping (value = "/searchlocation")
    public String searchLocation(@RequestParam String location) throws statusInvalidException{
            try{
                List<Job> searcResult = new ArrayList<Job>();
                searcResult = this.service.searchLocation(location);
                if (!searcResult.isEmpty()){
                    String json = new Gson().toJson(searcResult);
                    return json;
                }
                else
                {
                    String json = new Gson().toJson("No results found");
                    return json;
                }
            }
            catch(Exception ex){
                return ex.getMessage();
            }
        
    }
    
}
