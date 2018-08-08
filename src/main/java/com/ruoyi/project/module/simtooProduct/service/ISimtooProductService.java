package com.ruoyi.project.module.simtooProduct.service;

import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品管理 服务层
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
public interface ISimtooProductService 
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
     * 删除产品管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSimtooProductByIds(String ids);

    SimtooProduct selectSimtooProductByIdImgs(Long aLong);

	/**
	 * 查询商品是否存在并且检查库存是否充足,并且添加到购物车
	 * @param aLong
	 * @return
	 */
	boolean selectCheckProductAddCart(Long aLong,Integer count);
}
