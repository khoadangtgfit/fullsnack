package com.hitachi.coe.fullstack.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
@ToString
@Getter
@Setter
public class AuditModel<ID extends Serializable> implements BaseAuditModel<ID> { //NOSONAR
    
    /**
     * <p>Description of this field.</p>
     */
    private static final long serialVersionUID = 1L;
    
    ID id;
    Date created;
    String createdBy;
    Date updated;
    String updatedBy;

}
