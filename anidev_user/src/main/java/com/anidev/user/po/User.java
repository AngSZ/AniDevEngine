package com.anidev.user.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sza
 */
@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String email;

    private String password;

    private String phone;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime registrationDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastLoginDate;

    private String avatar;

    private String status;

    private String role;

    private String bio;

    private String country;

    private String city;

    private String occupation;

    private String interests;


}
