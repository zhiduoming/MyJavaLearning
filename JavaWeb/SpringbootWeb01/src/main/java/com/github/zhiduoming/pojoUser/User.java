package com.github.zhiduoming.pojoUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户信息的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String Username;
    private String Password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
