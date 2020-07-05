package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:songjn1
 * @Description:Pref构建
 * @Date 2020/6/29 19:13
 *****/
@ApiModel(description = "Pref",value = "Pref")
@Table(name="tb_pref")
public class Pref implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

	@ApiModelProperty(value = "分类ID",required = false)
    @Column(name = "cate_id")
	private Integer cateId;//分类ID

	@ApiModelProperty(value = "消费金额",required = false)
    @Column(name = "buy_money")
	private Integer buyMoney;//消费金额

	@ApiModelProperty(value = "优惠金额",required = false)
    @Column(name = "pre_money")
	private Integer preMoney;//优惠金额

	@ApiModelProperty(value = "活动开始日期",required = false)
    @Column(name = "start_time")
	private Date startTime;//活动开始日期

	@ApiModelProperty(value = "活动截至日期",required = false)
    @Column(name = "end_time")
	private Date endTime;//活动截至日期

	@ApiModelProperty(value = "类型",required = false)
    @Column(name = "type")
	private String type;//类型

	@ApiModelProperty(value = "状态",required = false)
    @Column(name = "state")
	private String state;//状态


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public Integer getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(Integer buyMoney) {
		this.buyMoney = buyMoney;
	}

	public Integer getPreMoney() {
		return preMoney;
	}

	public void setPreMoney(Integer preMoney) {
		this.preMoney = preMoney;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
