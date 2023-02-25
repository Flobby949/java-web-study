package top.flobby.web.service;

import top.flobby.web.entity.Brand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-25 11:43
 **/

public class BrandService {
    private static List<Brand> brandList = new ArrayList<>();

    public List<Brand> selectAll() {
        if (brandList.isEmpty()) {
            brandList.add(Brand.builder()
                    .id(1)
                    .companyName("Apple")
                    .brandName("Iphone 14")
                    .description("苹果公司产品")
                    .ordered(1)
                    .status(1)
                    .build());
            brandList.add(Brand.builder()
                    .id(2)
                    .companyName("HUAWEI")
                    .brandName("HUAWEI MATE 50")
                    .description("华为公司产品")
                    .ordered(2)
                    .status(1)
                    .build());
            brandList.add(Brand.builder()
                    .id(3)
                    .companyName("Benz")
                    .brandName("梅赛德斯-AMG")
                    .description("奔驰公司产品")
                    .ordered(3)
                    .status(1)
                    .build());
        }
        return brandList;
    }

    public void add(Brand brand) {
        brand.setId(brandList.size() + 1);
        brandList.add(brand);
    }
}
