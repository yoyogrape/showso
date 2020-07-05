package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:songjn1
 * @Description:Template构建
 * @Date 2020/6/29 19:13
 *****/
@ApiModel(description = "Template",value = "Template")
@Table(name="tb_template")
public class Template implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

	@ApiModelProperty(value = "模板名称",required = false)
    @Column(name = "name")
	private String name;//模板名称

	@ApiModelProperty(value = "规格数量",required = false)
    @Column(name = "spec_num")
	private Integer specNum;//规格数量

	@ApiModelProperty(value = "参数数量",required = false)
    @Column(name = "para_num")
	private Integer paraNum;//参数数量


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSpecNum() {
		return specNum;
	}

	public void setSpecNum(Integer specNum) {
		this.specNum = specNum;
	}

	public Integer getParaNum() {
		return paraNum;
	}

	public void setParaNum(Integer paraNum) {
		this.paraNum = paraNum;
	}

}
