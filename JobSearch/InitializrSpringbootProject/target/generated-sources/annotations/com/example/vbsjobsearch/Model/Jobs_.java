package com.example.vbsjobsearch.Model;

import com.example.vbsjobsearch.Model.Location;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-24T11:11:14", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Jobs.class)
public class Jobs_ { 

    public static volatile SingularAttribute<Jobs, Location> locationId;
    public static volatile SingularAttribute<Jobs, String> jobTitle;
    public static volatile SingularAttribute<Jobs, Boolean> available;
    public static volatile SingularAttribute<Jobs, Integer> id;

}