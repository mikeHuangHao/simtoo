package com.ruoyi.project.module.cart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.cart.mapper.CartMapper;
import com.ruoyi.project.module.cart.domain.Cart;
import com.ruoyi.project.module.cart.service.ICartService;
import com.ruoyi.common.support.Convert;

/**
 * 购物车 服务层实现
 * 
 * @author huanghao
 * @date 2018-08-08
 */
@Service
public class CartServiceImpl implements ICartService 
{
	@Autowired
	private CartMapper cartMapper;

	/**
     * 查询购物车信息
     * 
     * @param cartId 购物车ID
     * @return 购物车信息
     */
    @Override
	public Cart selectCartById(Long cartId)
	{
	    return cartMapper.selectCartById(cartId);
	}
	
	/**
     * 查询购物车列表
     * 
     * @param cart 购物车信息
     * @return 购物车集合
     */
	@Override
	public List<Cart> selectCartList(Cart cart)
	{
	    return cartMapper.selectCartList(cart);
	}
	
    /**
     * 新增购物车
     * 
     * @param cart 购物车信息
     * @return 结果
     */
	@Override
	public int insertCart(Cart cart)
	{
	    return cartMapper.insertCart(cart);
	}
	
	/**
     * 修改购物车
     * 
     * @param cart 购物车信息
     * @return 结果
     */
	@Override
	public int updateCart(Cart cart)
	{
	    return cartMapper.updateCart(cart);
	}

	/**
     * 删除购物车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCartByIds(String ids)
	{
		return cartMapper.deleteCartByIds(Convert.toStrArray(ids));
	}

	/**
	 * 一对多查询购物车信息
	 * @param map
	 * @return
	 */
	@Override
	public List<Cart> selectCartListMeneber(Map<String,Object> map){
		return cartMapper.selectCartListMeneber(map);
	}
	
}
