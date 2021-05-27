package com.example.SpringBootDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//All of the resources of the api
@RestController
@RequestMapping(path="api/v1/student")//localhost:8080/api/v1/student
public class StudentController {

    private final StudentService studentService; //Reference to the studentService

    @Autowired //DI解决方案，帮助创建对象
    public StudentController(StudentService studentService) {
//        this.studentService = new StudentService(); 应该避免创建新对象,尽可能的使用DI
        this.studentService = studentService;
    }

    @GetMapping //RestAPI
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping //RestAPI
    public void registerNewStudent(@RequestBody Student student){ //take the request body and map into sutdent data structure
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){//RestAPI
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name, // RequestParam 用户是选填的
            @RequestParam(required = false) String email){ //RequestParam 用户是选填的
        studentService.updateStudent(studentId, name, email);
    }

}
