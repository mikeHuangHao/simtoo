package com.ruoyi.project.module.simtooProduct.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品管理表 s_simtoo_product
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
public class SimtooProduct extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long productId;
	/** 产品名称 */
	private String name;
	/** 产品标题 */
	private String title;
	/** 金额 */
	private BigDecimal money;
	/** 产品轮播图 */
	private String productLunImg;
	/** 产品描述 */
	private String productDescribe;
	/** 库存数量 */
	private Integer inventoryNumber;
	/** 产品简介 */
	private String introduction;
	/** 产品参数 */
	private String specs;
	/** 视频 */
	private String video;
	/** 文件 */
	private String productFile;
	/** 常见问题 */
	private String faq;
	/** 显示状态(1上架 2下架) */
	private Integer isState;
	/** 是否删除(1正常 2删除) */
	private Integer isFlg;
	/** 父级ID */
	private Long menuId;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public void setProductId(Long productId) 
	{
		this.productId = productId;
	}

	public Long getProductId() 
	{
		return productId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setMoney(BigDecimal money) 
	{
		this.money = money;
	}

	public BigDecimal getMoney() 
	{
		return money;
	}
	public void setProductLunImg(String productLunImg) 
	{
		this.productLunImg = productLunImg;
	}

	public String getProductLunImg() 
	{
		return productLunImg;
	}
	public void setProductDescribe(String productDescribe) 
	{
		this.productDescribe = productDescribe;
	}

	public String getProductDescribe() 
	{
		return productDescribe;
	}
	public void setInventoryNumber(Integer inventoryNumber) 
	{
		this.inventoryNumber = inventoryNumber;
	}

	public Integer getInventoryNumber() 
	{
		return inventoryNumber;
	}
	public void setIntroduction(String introduction) 
	{
		this.introduction = introduction;
	}

	public String getIntroduction() 
	{
		return introduction;
	}
	public void setSpecs(String specs) 
	{
		this.specs = specs;
	}

	public String getSpecs() 
	{
		return specs;
	}
	public void setVideo(String video) 
	{
		this.video = video;
	}

	public String getVideo() 
	{
		return video;
	}
	public void setProductFile(String productFile) 
	{
		this.productFile = productFile;
	}

	public String getProductFile() 
	{
		return productFile;
	}
	public void setFaq(String faq) 
	{
		this.faq = faq;
	}

	public String getFaq() 
	{
		return faq;
	}
	public void setIsState(Integer isState) 
	{
		this.isState = isState;
	}

	public Integer getIsState() 
	{
		return isState;
	}
	public void setIsFlg(Integer isFlg) 
	{
		this.isFlg = isFlg;
	}

	public Integer getIsFlg() 
	{
		return isFlg;
	}
	public void setMenuId(Long menuId) 
	{
		this.menuId = menuId;
	}

	public Long getMenuId() 
	{
		return menuId;
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
            .append("productId", getProductId())
            .append("name", getName())
            .append("title", getTitle())
            .append("money", getMoney())
            .append("productLunImg", getProductLunImg())
            .append("productDescribe", getProductDescribe())
            .append("inventoryNumber", getInventoryNumber())
            .append("introduction", getIntroduction())
            .append("specs", getSpecs())
            .append("video", getVideo())
            .append("productFile", getProductFile())
            .append("faq", getFaq())
            .append("isState", getIsState())
            .append("isFlg", getIsFlg())
            .append("menuId", getMenuId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
