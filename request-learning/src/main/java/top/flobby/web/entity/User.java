package top.flobby.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-25 12:50
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
