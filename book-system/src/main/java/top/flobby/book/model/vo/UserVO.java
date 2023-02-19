package top.flobby.book.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-19 10:31
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Integer id;
    private String account;
    private String nickname;
    private String avatar;
    private String address;
    private String createTime;
}
