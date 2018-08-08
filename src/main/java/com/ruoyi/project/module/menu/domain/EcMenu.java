package com.ruoyi.project.module.menu.domain;

import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 一级菜单表 s_ec_menu
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
public class EcMenu extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long menuId;
	/** 名称 */
	private String name;
	/** 是否显示（1 正常 2 不显示） */
	private Integer state;
	/** 顺序（1,2,3,4,5....） */
	private Integer sort;
	/** 删除状态（1 正常 2 删除 ） */
	private Integer isFlg;

	private List<SimtooProduct> product;


	public List<SimtooProduct> getProduct() {
		return product;
	}

	public void setProduct(List<SimtooProduct> product) {
		this.product = product;
	}

	public void setMenuId(Long menuId)
	{
		this.menuId = menuId;
	}

	public Long getMenuId() 
	{
		return menuId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setState(Integer state) 
	{
		this.state = state;
	}

	public Integer getState() 
	{
		return state;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setIsFlg(Integer isFlg) 
	{
		this.isFlg = isFlg;
	}

	public Integer getIsFlg() 
	{
		return isFlg;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menuId", getMenuId())
            .append("name", getName())
            .append("state", getState())
            .append("sort", getSort())
            .append("isFlg", getIsFlg())
            .toString();
    }
}
