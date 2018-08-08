package com.ruoyi.project.module.menu.mapper;

import com.ruoyi.project.module.menu.domain.EcMenu;

import java.util.List;

/**
 * 一级菜单 数据层
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
public interface EcMenuMapper 
{
	/**
     * 查询一级菜单信息
     * 
     * @param menuId 一级菜单ID
     * @return 一级菜单信息
     */
	public EcMenu selectEcMenuById(Long menuId);
	
	/**
     * 查询一级菜单列表
     * 
     * @param ecMenu 一级菜单信息
     * @return 一级菜单集合
     */
	public List<EcMenu> selectEcMenuList(EcMenu ecMenu);
	
	/**
     * 新增一级菜单
     * 
     * @param ecMenu 一级菜单信息
     * @return 结果
     */
	public int insertEcMenu(EcMenu ecMenu);
	
	/**
     * 修改一级菜单
     * 
     * @param ecMenu 一级菜单信息
     * @return 结果
     */
	public int updateEcMenu(EcMenu ecMenu);
	
	/**
     * 删除一级菜单
     * 
     * @param menuId 一级菜单ID
     * @return 结果
     */
	public int deleteEcMenuById(Long menuId);
	
	/**
     * 批量删除一级菜单
     * 
     * @param menuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteEcMenuByIds(String[] menuIds);

	/**
	 * 前台查询接口
	 * @param ecMenu
	 * @return
	 */
	List<EcMenu> selectMenuEcList(EcMenu ecMenu);
}