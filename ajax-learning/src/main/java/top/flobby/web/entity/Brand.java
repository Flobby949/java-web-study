package top.flobby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 品牌实体
 * @create : 2023-02-25 11:36
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private Integer id;
    private String companyName;
    private String brandName;
    private String description;
    private Integer ordered;
    private Integer status;
}
