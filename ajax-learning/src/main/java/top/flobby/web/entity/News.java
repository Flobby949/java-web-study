package top.flobby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 18:25
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer id;
    private String title;
    private String date;
    private String source;
    private String content;
}
