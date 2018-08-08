package com.ruoyi.project.module.cart.service;

import com.ruoyi.project.module.cart.domain.Cart;
import java.util.List;
import java.util.Map;

/**
 * 购物车 服务层
 * 
 * @author huanghao
 * @date 2018-08-08
 */
public interface ICartService 
{
	/**
     * 查询购物车信息
     * 
     * @param cartId 购物车ID
     * @return 购物车信息
     */
	public Cart selectCartById(Long cartId);
	
	/**
     * 查询购物车列表
     * 
     * @param cart 购物车信息
     * @return 购物车集合
     */
	public List<Cart> selectCartList(Cart cart);
	
	/**
     * 新增购物车
     * 
     * @param cart 购物车信息
     * @return 结果
     */
	public int insertCart(Cart cart);
	
	/**
     * 修改购物车
     * 
     * @param cart 购物车信息
     * @return 结果
     */
	public int updateCart(Cart cart);
		
	/**
     * 删除购物车信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCartByIds(String ids);

	/**
	 * 一对多查询购物车信息
	 * @param map
	 * @return
	 */
	List<Cart> selectCartListMeneber(Map<String,Object> map);
	
}
