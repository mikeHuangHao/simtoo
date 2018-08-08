package com.ruoyi.project.module.simtooProduct.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.module.cart.domain.Cart;
import com.ruoyi.project.module.cart.mapper.CartMapper;
import com.ruoyi.project.result.CodeMsg;
import com.ruoyi.project.result.Result;
import com.ruoyi.project.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.simtooProduct.mapper.SimtooProductMapper;
import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import com.ruoyi.common.support.Convert;

import javax.servlet.http.HttpServletResponse;

/**
 * 产品管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
@Service
public class SimtooProductServiceImpl implements ISimtooProductService 
{
	@Autowired
	private SimtooProductMapper simtooProductMapper;

	@Autowired
	private CartMapper cartMapper;

	/**
     * 查询产品管理信息
     * 
     * @param productId 产品管理ID
     * @return 产品管理信息
     */
    @Override
	public SimtooProduct selectSimtooProductById(Long productId)
	{
	    return simtooProductMapper.selectSimtooProductById(productId);
	}
	
	/**
     * 查询产品管理列表
     * 
     * @param simtooProduct 产品管理信息
     * @return 产品管理集合
     */
	@Override
	public List<SimtooProduct> selectSimtooProductList(SimtooProduct simtooProduct)
	{
	    return simtooProductMapper.selectSimtooProductList(simtooProduct);
	}
	
    /**
     * 新增产品管理
     * 
     * @param simtooProduct 产品管理信息
     * @return 结果
     */
	@Override
	public int insertSimtooProduct(SimtooProduct simtooProduct)
	{
	    return simtooProductMapper.insertSimtooProduct(simtooProduct);
	}
	
	/**
     * 修改产品管理
     * 
     * @param simtooProduct 产品管理信息
     * @return 结果
     */
	@Override
	public int updateSimtooProduct(SimtooProduct simtooProduct)
	{
	    return simtooProductMapper.updateSimtooProduct(simtooProduct);
	}

	/**
     * 删除产品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSimtooProductByIds(String ids)
	{
		return simtooProductMapper.deleteSimtooProductByIds(Convert.toStrArray(ids));
	}

	/**
	 * 商品详情 夹 图片
	 * @param aLong
	 * @return
	 */
	@Override
	public SimtooProduct selectSimtooProductByIdImgs(Long aLong) {
		return simtooProductMapper.selectSimtooProductByIdImgs(aLong);
	}

	/**
	 * 1根据商品id查询商品
	 * 2查询库存是否充足
	 * 3查询狗购物车是否有该商品
	 * 4有追加数量，无添加
	 * @param productId
	 * @return
	 */
	@Override
	public synchronized boolean selectCheckProductAddCart(Long productId,Integer count) {
		try {
			SimtooProduct sp = simtooProductMapper.selectSimtooProductById(productId);
			if(sp == null || sp.getIsFlg() == 2 || sp.getIsState() == 2){
				return false;
			}else{
				if(sp.getInventoryNumber() == 0){
					return false;
				}else{
					Map<String,Object> map = new HashMap<>();
					map.put("memberId",1);
					map.put("productId",productId);
					Cart cart = cartMapper.selectCartMemberIdAndproductId(map);
					Cart cartTemp = new Cart();
					cartTemp.setMemberId(Long.valueOf(1));
					cartTemp.setProductId(productId);
					if(cart == null){
						cartTemp.setCount(Integer.valueOf(count));
						cartMapper.insertCart(cartTemp);
					}else{
						cartTemp.setCartId(cart.getCartId());
						cartTemp.setCount(Integer.valueOf(count));
						cartMapper.updateCart(cartTemp);
					}
					return true;
				}
			}
		}catch (Exception e){
			return false;
		}
	}

}
