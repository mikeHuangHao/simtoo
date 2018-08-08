package com.ruoyi.project.module.productImg.service;

import com.ruoyi.project.module.productImg.domain.ProductImg;
import java.util.List;

/**
 * 产品图片 服务层
 * 
 * @author huanghao
 * @date 2018-08-06
 */
public interface IProductImgService 
{
	/**
     * 查询产品图片信息
     * 
     * @param productImgId 产品图片ID
     * @return 产品图片信息
     */
	public ProductImg selectProductImgById(Long productImgId);
	
	/**
     * 查询产品图片列表
     * 
     * @param productImg 产品图片信息
     * @return 产品图片集合
     */
	public List<ProductImg> selectProductImgList(ProductImg productImg);
	
	/**
     * 新增产品图片
     * 
     * @param productImg 产品图片信息
     * @return 结果
     */
	public int insertProductImg(ProductImg productImg);

	/**
     * 新增产品图片集合
     *
     * @param productImg 产品图片信息
     * @return 结果
     */
	public int insertProductImgList(List<ProductImg> productImg);

	/**
     * 修改产品图片
     * 
     * @param productImg 产品图片信息
     * @return 结果
     */
	public int updateProductImg(ProductImg productImg);
		
	/**
     * 删除产品图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductImgByIds(String ids);
	
}
