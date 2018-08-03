package com.ruoyi.project.module.simtooProduct.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.module.simtooProduct.mapper.SimtooProductMapper;
import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import com.ruoyi.common.support.Convert;

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
	
}
