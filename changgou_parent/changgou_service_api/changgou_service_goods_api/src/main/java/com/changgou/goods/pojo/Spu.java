package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:songjn1
 * @Description:Spu构建
 * @Date 2020/6/29 19:13
 *****/
@ApiModel(description = "Spu",value = "Spu")
@Table(name="tb_spu")
public class Spu implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键

	@ApiModelProperty(value = "货号",required = false)
    @Column(name = "sn")
	private String sn;//货号

	@ApiModelProperty(value = "SPU名",required = false)
    @Column(name = "name")
	private String name;//SPU名

	@ApiModelProperty(value = "副标题",required = false)
    @Column(name = "caption")
	private String caption;//副标题

	@ApiModelProperty(value = "品牌ID",required = false)
    @Column(name = "brand_id")
	private Integer brandId;//品牌ID

	@ApiModelProperty(value = "一级分类",required = false)
    @Column(name = "category1_id")
	private Integer category1Id;//一级分类

	@ApiModelProperty(value = "二级分类",required = false)
    @Column(name = "category2_id")
	private Integer category2Id;//二级分类

	@ApiModelProperty(value = "三级分类",required = false)
    @Column(name = "category3_id")
	private Integer category3Id;//三级分类

	@ApiModelProperty(value = "模板ID",required = false)
    @Column(name = "template_id")
	private Integer templateId;//模板ID

	@ApiModelProperty(value = "运费模板id",required = false)
    @Column(name = "freight_id")
	private Integer freightId;//运费模板id

	@ApiModelProperty(value = "图片",required = false)
    @Column(name = "image")
	private String image;//图片

	@ApiModelProperty(value = "图片列表",required = false)
    @Column(name = "images")
	private String images;//图片列表

	@ApiModelProperty(value = "售后服务",required = false)
    @Column(name = "sale_service")
	private String saleService;//售后服务

	@ApiModelProperty(value = "介绍",required = false)
    @Column(name = "introduction")
	private String introduction;//介绍

	@ApiModelProperty(value = "规格列表",required = false)
    @Column(name = "spec_items")
	private String specItems;//规格列表

	@ApiModelProperty(value = "参数列表",required = false)
    @Column(name = "para_items")
	private String paraItems;//参数列表

	@ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
	private Integer saleNum;//销量

	@ApiModelProperty(value = "评论数",required = false)
    @Column(name = "comment_num")
	private Integer commentNum;//评论数

	@ApiModelProperty(value = "是否上架",required = false)
    @Column(name = "is_marketable")
	private String isMarketable;//是否上架

	@ApiModelProperty(value = "是否启用规格",required = false)
    @Column(name = "is_enable_spec")
	private String isEnableSpec;//是否启用规格

	@ApiModelProperty(value = "是否删除",required = false)
    @Column(name = "is_delete")
	private String isDelete;//是否删除

	@ApiModelProperty(value = "审核状态",required = false)
    @Column(name = "status")
	private String status;//审核状态


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Integer getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Integer category1Id) {
		this.category1Id = category1Id;
	}

	public Integer getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Integer category2Id) {
		this.category2Id = category2Id;
	}

	public Integer getCategory3Id() {
		return category3Id;
	}

	public void setCategory3Id(Integer category3Id) {
		this.category3Id = category3Id;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Integer getFreightId() {
		return freightId;
	}

	public void setFreightId(Integer freightId) {
		this.freightId = freightId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getSaleService() {
		return saleService;
	}

	public void setSaleService(String saleService) {
		this.saleService = saleService;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSpecItems() {
		return specItems;
	}

	public void setSpecItems(String specItems) {
		this.specItems = specItems;
	}

	public String getParaItems() {
		return paraItems;
	}

	public void setParaItems(String paraItems) {
		this.paraItems = paraItems;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public String getIsMarketable() {
		return isMarketable;
	}

	public void setIsMarketable(String isMarketable) {
		this.isMarketable = isMarketable;
	}

	public String getIsEnableSpec() {
		return isEnableSpec;
	}

	public void setIsEnableSpec(String isEnableSpec) {
		this.isEnableSpec = isEnableSpec;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
