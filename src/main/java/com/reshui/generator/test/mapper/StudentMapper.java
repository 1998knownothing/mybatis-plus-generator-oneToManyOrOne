package com.reshui.generator.test.mapper;

import com.reshui.generator.test.VO.OneToMany;
import com.reshui.generator.test.VO.OneToOne;
import com.reshui.generator.test.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
public interface StudentMapper extends BaseMapper<Student> {
    public List<OneToMany> selectForOneToMany();
    public List<OneToOne> selectForOneToOne();

}
