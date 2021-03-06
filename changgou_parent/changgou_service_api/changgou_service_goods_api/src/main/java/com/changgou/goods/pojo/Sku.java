package com.changgou.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:songjn1
 * @Description:Sku构建
 * @Date 2020/6/29 19:13
 *****/
@ApiModel(description = "Sku",value = "Sku")
@Table(name="tb_sku")
public class Sku implements Serializable{

	@ApiModelProperty(value = "商品id",required = false)
	@Id
    @Column(name = "id")
	private String id;//商品id

	@ApiModelProperty(value = "商品条码",required = false)
    @Column(name = "sn")
	private String sn;//商品条码

	@ApiModelProperty(value = "SKU名称",required = false)
    @Column(name = "name")
	private String name;//SKU名称

	@ApiModelProperty(value = "价格（分）",required = false)
    @Column(name = "price")
	private Integer price;//价格（分）

	@ApiModelProperty(value = "库存数量",required = false)
    @Column(name = "num")
	private Integer num;//库存数量

	@ApiModelProperty(value = "库存预警数量",required = false)
    @Column(name = "alert_num")
	private Integer alertNum;//库存预警数量

	@ApiModelProperty(value = "商品图片",required = false)
    @Column(name = "image")
	private String image;//商品图片

	@ApiModelProperty(value = "商品图片列表",required = false)
    @Column(name = "images")
	private String images;//商品图片列表

	@ApiModelProperty(value = "重量（克）",required = false)
    @Column(name = "weight")
	private Integer weight;//重量（克）

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "SPUID",required = false)
    @Column(name = "spu_id")
	private String spuId;//SPUID

	@ApiModelProperty(value = "类目ID",required = false)
    @Column(name = "category_id")
	private Integer categoryId;//类目ID

	@ApiModelProperty(value = "类目名称",required = false)
    @Column(name = "category_name")
	private String categoryName;//类目名称

	@ApiModelProperty(value = "品牌名称",required = false)
    @Column(name = "brand_name")
	private String brandName;//品牌名称

	@ApiModelProperty(value = "规格",required = false)
    @Column(name = "spec")
	private String spec;//规格

	@ApiModelProperty(value = "销量",required = false)
    @Column(name = "sale_num")
	private Integer saleNum;//销量

	@ApiModelProperty(value = "评论数",required = false)
    @Column(name = "comment_num")
	private Integer commentNum;//评论数

	@ApiModelProperty(value = "商品状态 1-正常，2-下架，3-删除",required = false)
    @Column(name = "status")
	private String status;//商品状态 1-正常，2-下架，3-删除

	@ApiModelProperty(value = "",required = false)
    @Column(name = "version")
	private Integer version;//


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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getAlertNum() {
		return alertNum;
	}

	public void setAlertNum(Integer alertNum) {
		this.alertNum = alertNum;
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSpuId() {
		return spuId;
	}

	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
