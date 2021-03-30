package cn.sk.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/30 14:03
 */
@AllArgsConstructor
@Data
public class User {
    private String userName;
    private Integer age;

}
