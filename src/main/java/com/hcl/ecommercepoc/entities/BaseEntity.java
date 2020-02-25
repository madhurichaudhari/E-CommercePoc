package com.hcl.ecommercepoc.entities;


import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.Date;


public abstract class BaseEntity  {

    @Id
    private String id;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private Date updatedDate;

    @Version
    private Long version;

    private Boolean delete = Boolean.FALSE;

}
