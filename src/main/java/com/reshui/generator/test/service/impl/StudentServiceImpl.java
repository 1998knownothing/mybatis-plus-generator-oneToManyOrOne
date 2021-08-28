package com.reshui.generator.test.service.impl;

import com.reshui.generator.test.entity.Student;
import com.reshui.generator.test.mapper.StudentMapper;
import com.reshui.generator.test.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
