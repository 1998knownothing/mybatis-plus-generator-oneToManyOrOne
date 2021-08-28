package com.reshui.generator.test.VO;

import com.reshui.generator.test.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OneToOne implements Serializable {

    private Integer id;


    private String name;


    private Integer age;


    private User user;
}
