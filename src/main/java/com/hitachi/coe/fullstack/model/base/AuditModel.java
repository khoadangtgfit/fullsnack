package com.hitachi.coe.fullstack.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
@ToString
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
	@Override
	public ID getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getCreated() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCreatedBy(String user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCreated(Date createdDate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getUpdatedBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getUpdated() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdatedBy(String user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setUpdated(Date updatedDate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setId(ID id) {
		// TODO Auto-generated method stub
		
	}

}
