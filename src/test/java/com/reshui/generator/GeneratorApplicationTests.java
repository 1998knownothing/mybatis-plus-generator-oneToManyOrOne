package com.reshui.generator;

import com.reshui.generator.test.entity.Student;
import com.reshui.generator.test.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class GeneratorApplicationTests {

    @Resource
    private IStudentService iStudentService;

    @Test
    void contextLoads() {
        List<Student> list = iStudentService.list();
        for (Student s:list){
            System.out.println(s.toString());
        }
    }

}
