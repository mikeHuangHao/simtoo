package com.ruoyi.project.module.simtooProduct.controller;

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
import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import com.ruoyi.project.module.simtooProduct.service.ISimtooProductService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 产品管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
@Controller
@RequestMapping("/module/simtooProduct")
public class SimtooProductController extends BaseController
{
    private String prefix = "module/simtooProduct";
	
	@Autowired
	private ISimtooProductService simtooProductService;
	
	@RequiresPermissions("module:simtooProduct:view")
	@GetMapping()
	public String simtooProduct()
	{
	    return prefix + "/simtooProduct";
	}
	
	/**
	 * 查询产品管理列表
	 */
	@RequiresPermissions("module:simtooProduct:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SimtooProduct simtooProduct)
	{
		startPage();
        List<SimtooProduct> list = simtooProductService.selectSimtooProductList(simtooProduct);
		return getDataTable(list);
	}
	
	/**
	 * 新增产品管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存产品管理
	 */
	@RequiresPermissions("module:simtooProduct:add")
	@Log(title = "产品管理", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SimtooProduct simtooProduct)
	{
		try {
			simtooProduct.setIsFlg(1);
			return toAjax(simtooProductService.insertSimtooProduct(simtooProduct));
		}catch (Exception e){
			e.printStackTrace();
			return toAjax(0);
		}
	}

	/**
	 * 修改产品管理
	 */
	@GetMapping("/edit/{productId}")
	public String edit(@PathVariable("productId") Long productId, ModelMap mmap)
	{
		SimtooProduct simtooProduct = simtooProductService.selectSimtooProductById(productId);
		mmap.put("simtooProduct", simtooProduct);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存产品管理
	 */
	@RequiresPermissions("module:simtooProduct:edit")
	@Log(title = "产品管理", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SimtooProduct simtooProduct , HttpServletRequest request)
	{
		String productDescribe = request.getParameter("productDescribe");
		String introduction = request.getParameter("introduction");
		String specs = request.getParameter("specs");
		String faq = request.getParameter("faq");
		simtooProduct.setProductDescribe(productDescribe);
		simtooProduct.setIntroduction(introduction);
		simtooProduct.setSpecs(specs);
		simtooProduct.setFaq(faq);
		return toAjax(simtooProductService.updateSimtooProduct(simtooProduct));
	}
	
	/**
	 * 删除产品管理
	 */
	@RequiresPermissions("module:simtooProduct:remove")
	@Log(title = "产品管理", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		SimtooProduct simtooProduct = new SimtooProduct();
		simtooProduct.setProductId(Long.valueOf(ids));
		simtooProduct.setIsFlg(2);
		return toAjax(simtooProductService.updateSimtooProduct(simtooProduct));
	}
	
}
