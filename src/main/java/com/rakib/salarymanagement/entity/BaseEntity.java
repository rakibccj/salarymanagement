package com.rakib.salarymanagement.entity;

import com.rakib.salarymanagement.enums.ActiveStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String createdBy;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private Integer activeStatus;

    @PrePersist
    public void setPreInsertData() {
        this.createdAt = new Date();
        this.activeStatus = ActiveStatus.ACTIVE.getValue();
    }

    @PreUpdate
    public void setPreUpdateData() {
        this.updateAt = new Date();
        if (this.activeStatus == null) {
            this.activeStatus = ActiveStatus.ACTIVE.getValue();
        }
        if (this.activeStatus != ActiveStatus.DELETE.getValue()) {
            this.activeStatus = ActiveStatus.ACTIVE.getValue();
        }

    }
}
