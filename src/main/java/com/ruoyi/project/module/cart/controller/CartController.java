package com.ruoyi.project.module.cart.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.project.module.cart.domain.Cart;
import com.ruoyi.project.module.cart.service.ICartService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import java.util.ArrayList;

/**
 * 购物车 信息操作处理
 * 
 * @author huanghao
 * @date 2018-08-08
 */
@Controller
@RequestMapping("/module/cart")
public class CartController extends BaseController
{
    private String prefix = "module/cart";
	
	@Autowired
	private ICartService cartService;
	
	@RequiresPermissions("module:cart:view")
	@GetMapping()
	public String cart()
	{
	    return prefix + "/cart";
	}
	
	/**
	 * 查询购物车列表
	 */
	@RequiresPermissions("module:cart:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Cart cart)
	{
        List<Cart> list = new ArrayList<Cart>();
	    try{
			startPage();
			list = cartService.selectCartList(cart);
			return getDataTable(list);
        }catch (Exception e){
            return getDataTable(list);
        }
	}
	
	/**
	 * 新增购物车
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存购物车
	 */
	@RequiresPermissions("module:cart:add")
	@Log(title = "购物车", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Cart cart)
	{
	    try{
			return toAjax(cartService.insertCart(cart));
        }catch (Exception e){
            return toAjax(0);
        }
	}

	/**
	 * 修改购物车
	 */
	@GetMapping("/edit/{cartId}")
	public String edit(@PathVariable("cartId") Long cartId, ModelMap mmap)
	{
		Cart cart = cartService.selectCartById(cartId);
		mmap.put("cart", cart);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存购物车
	 */
	@RequiresPermissions("module:cart:edit")
	@Log(title = "购物车", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Cart cart)
	{
        try{
			return toAjax(cartService.updateCart(cart));
        }catch (Exception e){
            return toAjax(0);
        }
	}
	
	/**
	 * 删除购物车
	 */
	@RequiresPermissions("module:cart:remove")
	@Log(title = "购物车", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
	    try{
            return toAjax(cartService.deleteCartByIds(ids));
        }catch (Exception e){
            return toAjax(0);
        }
	}
	
}
