package com.reshui.generator.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
//@ApiModel(value="User对象", description="")
public class User implements Serializable {


    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;


}
