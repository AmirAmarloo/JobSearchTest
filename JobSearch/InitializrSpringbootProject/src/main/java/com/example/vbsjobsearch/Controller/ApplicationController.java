package com.example.vbsjobsearch.Controller;

import com.example.vbsjobsearch.Model.Application;
import com.example.vbsjobsearch.Service.ApplicationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;  

@RestController
public class ApplicationController {
    public ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @PostMapping (value = "/add")
    public String addApplication(@RequestBody Application a){
        UUID uuid = UUID.randomUUID(); 
        String uuidAsString = uuid.toString();
        a.setUid(uuidAsString);
        this.service.addApplication(a);
        return "The UUID is: " + uuidAsString;
    }
    
    @GetMapping (value = "/all")
    public List<Application> getAllApplication(){
        return this.service.getAllApplication();
    }
    
    @PostMapping (value = "/update")
    public Application updateApplication(Application application){
        return this.service.updateApplication(application);
    }
    
    @GetMapping (value = "/delete")
    public void deleteApplication(@RequestParam Integer id){
        this.service.deleteApplication(id);
    }
    
    @GetMapping (value = "/")
    public Application getById(@RequestParam Integer id){
        return this.service.getById(id);
    }

    
    
    
    
        
}
    
    

