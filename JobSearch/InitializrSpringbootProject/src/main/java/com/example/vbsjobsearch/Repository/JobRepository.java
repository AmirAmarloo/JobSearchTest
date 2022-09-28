package com.example.vbsjobsearch.Repository;

import com.example.vbsjobsearch.Model.Job;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
   
  /*  @Query("SELECT j FROM Job j WHERE j.title LIKE '%:title%'")
    Job findByJobTitle(@Param("name)String title);
    */ 
    

}
