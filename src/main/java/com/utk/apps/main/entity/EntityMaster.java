package com.utk.apps.main.entity;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityMaster {

    @Id
    private Long id;

    @Embedded
    private EntityMetaData metaData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EntityMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(EntityMetaData metaData) {
        this.metaData = metaData;
    }
}
