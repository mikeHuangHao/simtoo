package com.ruoyi.project.module.cart.mapper;

import com.ruoyi.project.module.cart.domain.Cart;
import java.util.List;
import java.util.Map;

/**
 * 购物车 数据层
 * 
 * @author huanghao
 * @date 2018-08-08
 */
public interface CartMapper 
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
     * 删除购物车
     * 
     * @param cartId 购物车ID
     * @return 结果
     */
	public int deleteCartById(Long cartId);
	
	/**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCartByIds(String[] cartIds);

	/**
	 * 根据用户id和商品id查询购物车是否有该商品
	 * @param map
	 * @return
	 */
	Cart selectCartMemberIdAndproductId(Map<String,Object> map);

	/**
	 * 一对多查询购物车信息
	 * @param map
	 * @return
	 */
	List<Cart> selectCartListMeneber(Map<String,Object> map);
	
}