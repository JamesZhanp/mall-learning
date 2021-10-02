package com.james.mall.service;

import com.james.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * pmsService Interface
 *
 * @author: JamesZhan
 * @create: 2021 - 02 - 11 13:16
 */

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createdBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
