package com.example.vbsjobsearch.Service;

import com.example.vbsjobsearch.Model.Application;
import com.example.vbsjobsearch.Repository.ApplicationRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    public final ApplicationRepository repo;

    @PersistenceContext
    public EntityManager em;
    
    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }
    
    public Application addApplication(Application application){
        
        return this.repo.save(application);
    }
    
    
    public List<Application> getAllApplication(){
        return this.repo.findAll();
    }
   
    public void deleteApplication(Integer id){
        this.repo.deleteById(id);
    }
    
    public Application updateApplication(Application application){
        return this.repo.save(application);
    }
        
    public Application getById(Integer id){
        Optional<Application> obj = this.repo.findById(id);
        if (obj.isEmpty()){
            return new Application();
        }
        else{
            return obj.get();
        }
    }
    
}
