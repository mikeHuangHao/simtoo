package com.ruoyi.project.module.cart.domain;

import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 购物车表 s_cart
 * 
 * @author huanghao
 * @date 2018-08-08
 */
public class Cart extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long cartId;
	/** 产品ID */
	private Long productId;
	/** 用户ID */
	private Long memberId;
	/** 数量 */
	private Integer count;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	private SimtooProduct simtooProduct;

	public SimtooProduct getSimtooProduct() {
		return simtooProduct;
	}

	public void setSimtooProduct(SimtooProduct simtooProduct) {
		this.simtooProduct = simtooProduct;
	}

	public void setCartId(Long cartId)
	{
		this.cartId = cartId;
	}

	public Long getCartId() 
	{
		return cartId;
	}
	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getProductId() 
	{
		return productId;
	}
	public void setMemberId(Long memberId) 
	{
		this.memberId = memberId;
	}

	public Long getMemberId() 
	{
		return memberId;
	}
	public void setCount(Integer count) 
	{
		this.count = count;
	}

	public Integer getCount() 
	{
		return count;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cartId", getCartId())
            .append("productId", getProductId())
            .append("memberId", getMemberId())
            .append("count", getCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
