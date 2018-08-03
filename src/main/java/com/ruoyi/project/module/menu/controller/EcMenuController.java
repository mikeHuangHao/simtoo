package com.ruoyi.project.module.menu.controller;

import java.util.List;

import com.ruoyi.project.common.UploadController;
import com.ruoyi.project.module.menu.domain.EcMenu;
import com.ruoyi.project.module.menu.service.IEcMenuService;
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
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 一级菜单 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
@Controller
@RequestMapping("/module/ecMenu")
public class EcMenuController extends BaseController
{
    private String prefix = "module/ecMenu";

    @Autowired
	UploadController uploadController;

	@Autowired
	private IEcMenuService ecMenuService;

	@RequiresPermissions("module:ecMenu:view")
	@GetMapping()
	public String ecMenu()
	{
	    return prefix + "/ecMenu";
	}

	/**
	 * 查询一级菜单列表
	 */
	@RequiresPermissions("module:ecMenu:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(EcMenu ecMenu)
	{
		startPage();
        List<EcMenu> list = ecMenuService.selectEcMenuList(ecMenu);
		return getDataTable(list);
	}
	
	/**
	 * 新增一级菜单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存一级菜单
	 */
	@RequiresPermissions("module:ecMenu:add")
	@Log(title = "一级菜单", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(EcMenu ecMenu)
	{		
		return toAjax(ecMenuService.insertEcMenu(ecMenu));
	}

	/**
	 * 修改一级菜单
	 */
	@GetMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		EcMenu ecMenu = ecMenuService.selectEcMenuById(menuId);
		mmap.put("ecMenu", ecMenu);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存一级菜单
	 */
	@RequiresPermissions("module:ecMenu:edit")
	@Log(title = "一级菜单", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(EcMenu ecMenu)
	{		
		return toAjax(ecMenuService.updateEcMenu(ecMenu));
	}
	
	/**
	 * 删除一级菜单
	 */
	@RequiresPermissions("module:ecMenu:remove")
	@Log(title = "一级菜单", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(ecMenuService.deleteEcMenuByIds(ids));
	}
	
}
