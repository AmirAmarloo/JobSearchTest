package com.example.vbsjobsearch.Model;

import com.example.vbsjobsearch.Model.Jobs;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-24T11:11:14", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> locationDesc;
    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile CollectionAttribute<Location, Jobs> jobsCollection;

}