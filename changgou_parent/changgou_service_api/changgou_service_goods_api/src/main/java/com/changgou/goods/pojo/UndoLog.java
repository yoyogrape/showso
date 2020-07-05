package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:songjn1
 * @Description:UndoLog构建
 * @Date 2020/6/29 19:13
 *****/
@ApiModel(description = "UndoLog",value = "UndoLog")
@Table(name="undo_log")
public class UndoLog implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "branch_id")
	private Long branchId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "xid")
	private String xid;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "rollback_info")
	private String rollbackInfo;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_status")
	private Integer logStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_created")
	private Date logCreated;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_modified")
	private Date logModified;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "ext")
	private String ext;//


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public String getRollbackInfo() {
		return rollbackInfo;
	}

	public void setRollbackInfo(String rollbackInfo) {
		this.rollbackInfo = rollbackInfo;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public Date getLogCreated() {
		return logCreated;
	}

	public void setLogCreated(Date logCreated) {
		this.logCreated = logCreated;
	}

	public Date getLogModified() {
		return logModified;
	}

	public void setLogModified(Date logModified) {
		this.logModified = logModified;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
