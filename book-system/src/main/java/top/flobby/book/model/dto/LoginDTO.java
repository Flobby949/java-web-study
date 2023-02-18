package top.flobby.book.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description : 登录dto
 * @create : 2023-02-18 11:40
 **/

@Data
public class LoginDTO {
    private String account;
    private String password;
}
