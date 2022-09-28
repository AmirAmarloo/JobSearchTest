package com.example.vbsjobsearch.Service;

import com.example.vbsjobsearch.Exceptions.statusInvalidException;
import com.example.vbsjobsearch.Model.Job;
import com.example.vbsjobsearch.Repository.JobRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    public final JobRepository repo;
    public boolean isValidUuid;

    @PersistenceContext
    public EntityManager em;
    
    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public Job addJobs(Job job){
        return this.repo.save(job);
    }
    
    public List<Job> getAllJobs(){
        return this.repo.findAll();
    }
   
    public void deleteJob(Integer id){
        this.repo.deleteById(id);
    }
    
    public Job updateJob(Job job){
        return this.repo.save(job);
    }
        
    public Job getById(Integer id){
        Optional<Job> obj = this.repo.findById(id);
        if (obj.isEmpty()){
            return new Job();
        }
        else{
            return obj.get();
        }
    }

    public boolean checkUUID(String uuid) throws statusInvalidException{
        StoredProcedureQuery spq = em.createStoredProcedureQuery("validAPI");
        
        spq.registerStoredProcedureParameter("uuidIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("sumOUT", String.class, ParameterMode.OUT);
        spq.setParameter("uuidIN", uuid);
        spq.execute();
        this.isValidUuid = false;
        if (Integer.parseInt(spq.getOutputParameterValue("sumOUT").toString()) != 0){
            this.isValidUuid = (Integer.parseInt(spq.getOutputParameterValue("sumOUT").toString()) != 0);
        }
        else
        {
            throw new statusInvalidException("invalid uuid!!!");
        }
        return this.isValidUuid;   
    }
    
   
    public List<Job> searchJob(String title) throws statusInvalidException{
        if (!this.isValidUuid){
            throw new statusInvalidException("invalid uuid!!!");
        }
        StoredProcedureQuery spq = em.createStoredProcedureQuery("searchtJOB");
        spq.registerStoredProcedureParameter("titleIN", String.class, ParameterMode.IN);
        spq.setParameter("titleIN", title);
        spq.execute();
        return  spq.getResultList();
        
    }
    
    public List<Job> searchLocation(String location) throws statusInvalidException{
        if (!this.isValidUuid){
            throw new statusInvalidException("invalid uuid!!!");
        }
        StoredProcedureQuery spq = em.createStoredProcedureQuery("searchLocation");
        spq.registerStoredProcedureParameter("locationIN", String.class, ParameterMode.IN);
        spq.setParameter("locationIN", location);
        spq.execute();
        return  spq.getResultList();
        
    }
    
    /*public Job findByTitle(String title){
        return this.repo.findByJobTitle(title);
    }*/
}
