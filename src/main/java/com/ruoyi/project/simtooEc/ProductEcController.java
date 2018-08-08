package com.ruoyi.project.simtooEc;

import com.ruoyi.project.module.simtooProduct.domain.SimtooProduct;
import com.ruoyi.project.module.simtooProduct.service.ISimtooProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 前端产品类
 */
@Controller
@RequestMapping("/ec")
public class ProductEcController {

    @Autowired
    private ISimtooProductService simtooProductService;

    private String prefix = "simtoo";

    /**
     * 根据id查询详情
     * @param productId
     * @param resultMap
     * @return
     */
    @RequestMapping("/dragonfly")
    public String dragonfly(String productId,Map<String,Object> resultMap){
        try {
            SimtooProduct simtooProduct = simtooProductService.selectSimtooProductById(Long.valueOf(productId));
            resultMap.put("simtooProduct",simtooProduct);
            return prefix + "/dragonfly";
        }catch (Exception e){
            return prefix + "/404";
        }
    }

    /**
     * 根据id查询详情
     * @param productId
     * @param resultMap
     * @return
     */
    @RequestMapping("/shop")
    public String dragonflyDetails(String productId,Map<String,Object> resultMap){
        try {
            SimtooProduct simtooProduct = simtooProductService.selectSimtooProductByIdImgs(Long.valueOf(productId));
            resultMap.put("simtooProduct",simtooProduct);
            return prefix + "/shop";
        }catch (Exception e){
            return prefix + "/404";
        }
    }

}
