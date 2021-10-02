package com.james.mall.controller;

import com.james.mall.common.api.CommonPage;
import com.james.mall.common.api.CommonResult;
import com.james.mall.mbg.model.PmsBrand;
import com.james.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: JamesZhan
 * @create: 2021 - 02 - 15 15:40
 */
@Api(tags="PmsBandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("获取所有的商品列表")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand(), "All Brand");
    }

    @ApiOperation("添加商品品牌")
    @PostMapping(value = "/create")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count  = pmsBrandService.createdBrand(pmsBrand);
        if (count == 1){
            log.debug("createdBrand Success: {}", pmsBrand);
            return CommonResult.success(pmsBrand, "create success");
        }else{
            log.debug("created failed :{}", pmsBrand);
            return CommonResult.failed("created failed");
        }
    }

    @ApiOperation("更新指定id的商品品牌")
    @PutMapping("/brand/{id}")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand){
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if (count == 1){
            log.debug("Updated Success {}", pmsBrand);
            return CommonResult.success(pmsBrand, "update succeed");
        }else{
            log.debug("Update failed");
            return CommonResult.failed("update failed");
        }
    }

    @ApiOperation("删除指定id的商品品牌")
    @DeleteMapping("/brand/{id}")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1){
            log.debug("delete id: {} brand succeed", id);
            return CommonResult.success(null, "delete succeed");
        }else{
            log.debug("delete id {}, failed", id);
            return CommonResult.failed("delete failed");
        }
    }

    @ApiOperation("分页查询的商品列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList), "Page " + String.valueOf(pageNum) + " data");
    }

    @ApiOperation("获取指定id的品牌详情")
    @GetMapping(value = "/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
