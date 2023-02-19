package top.flobby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 18:43
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private String code;
    private String name;
}
