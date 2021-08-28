package com.reshui.generator.test.controller;


import com.reshui.generator.test.mapper.StudentMapper;
import com.reshui.generator.test.service.IStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService iStudentService;

    @Resource
    private StudentMapper studentMapper;

    @GetMapping("page")
    public  Object getAll(){

        return iStudentService.list();
    }

    @GetMapping("many")
    public  Object many(){

        return studentMapper.selectForOneToMany();
    }
    @GetMapping("one")
    public  Object one(){

        return studentMapper.selectForOneToOne();
    }
}

