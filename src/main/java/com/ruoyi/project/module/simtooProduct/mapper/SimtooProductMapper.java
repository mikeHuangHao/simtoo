package com.ruoyi.project.module.simtooProduct.mapper;

import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import java.util.List;	

/**
 * 产品管理 数据层
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
public interface SimtooProductMapper 
{
	/**
     * 查询产品管理信息
     * 
     * @param productId 产品管理ID
     * @return 产品管理信息
     */
	public SimtooProduct selectSimtooProductById(Long productId);
	
	/**
     * 查询产品管理列表
     * 
     * @param simtooProduct 产品管理信息
     * @return 产品管理集合
     */
	public List<SimtooProduct> selectSimtooProductList(SimtooProduct simtooProduct);
	
	/**
     * 新增产品管理
     * 
     * @param simtooProduct 产品管理信息
     * @return 结果
     */
	public int insertSimtooProduct(SimtooProduct simtooProduct);
	
	/**
     * 修改产品管理
     * 
     * @param simtooProduct 产品管理信息
     * @return 结果
     */
	public int updateSimtooProduct(SimtooProduct simtooProduct);
	
	/**
     * 删除产品管理
     * 
     * @param productId 产品管理ID
     * @return 结果
     */
	public int deleteSimtooProductById(Long productId);
	
	/**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSimtooProductByIds(String[] productIds);
	
}