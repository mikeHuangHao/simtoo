package com.ruoyi.project.module.productImg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产品图片表 s_product_img
 * 
 * @author huanghao
 * @date 2018-08-06
 */
public class ProductImg extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long productImgId;
	/** 产品ID */
	private Long productId;
	/** 图片地址 */
	private String imgUrl;

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductImgId(Long productImgId)
	{
		this.productImgId = productImgId;
	}

	public Long getProductImgId() 
	{
		return productImgId;
	}
	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getProductId() 
	{
		return productId;
	}
	public void setImgUrl(String imgUrl) 
	{
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() 
	{
		return imgUrl;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productImgId", getProductImgId())
            .append("productId", getProductId())
            .append("imgUrl", getImgUrl())
            .toString();
    }
}
