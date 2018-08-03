package com.ruoyi.project.module.menu.service;

import java.util.List;

import com.ruoyi.project.module.menu.domain.EcMenu;
import com.ruoyi.project.module.menu.mapper.EcMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;

/**
 * 一级菜单 服务层实现
 * 
 * @author ruoyi
 * @date 2018-08-02
 */
@Service
public class EcMenuServiceImpl implements IEcMenuService 
{
	@Autowired
	private EcMenuMapper ecMenuMapper;

	/**
     * 查询一级菜单信息
     * 
     * @param menuId 一级菜单ID
     * @return 一级菜单信息
     */
    @Override
	public EcMenu selectEcMenuById(Long menuId)
	{
	    return ecMenuMapper.selectEcMenuById(menuId);
	}
	
	/**
     * 查询一级菜单列表
     * 
     * @param ecMenu 一级菜单信息
     * @return 一级菜单集合
     */
	@Override
	public List<EcMenu> selectEcMenuList(EcMenu ecMenu)
	{
	    return ecMenuMapper.selectEcMenuList(ecMenu);
	}
	
    /**
     * 新增一级菜单
     * 
     * @param ecMenu 一级菜单信息
     * @return 结果
     */
	@Override
	public int insertEcMenu(EcMenu ecMenu)
	{
	    return ecMenuMapper.insertEcMenu(ecMenu);
	}
	
	/**
     * 修改一级菜单
     * 
     * @param ecMenu 一级菜单信息
     * @return 结果
     */
	@Override
	public int updateEcMenu(EcMenu ecMenu)
	{
	    return ecMenuMapper.updateEcMenu(ecMenu);
	}

	/**
     * 删除一级菜单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEcMenuByIds(String ids)
	{
		return ecMenuMapper.deleteEcMenuByIds(Convert.toStrArray(ids));
	}
	
}
