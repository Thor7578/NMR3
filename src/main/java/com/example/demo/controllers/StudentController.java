package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;

    public StudentController() {
        studentRepository = new StudentRepositoryImpl();
    }

    @GetMapping("/")
    public String homepage(Model model){
        indexRead(model);
        return "homepage";
    }

    @GetMapping("/studentList")
    public String index(Model model){
        indexRead(model);
        return "index";
    }

    @GetMapping("/student")
    //@ResponseBody
    public String getStudentByParameter(@RequestParam String cpr, Model model) {
        indexRead(model);
        Student stu = studentRepository.read(cpr);
        model.addAttribute("studentFirstName",stu.firstName);
        model.addAttribute("studentLastName",stu.lastName);
        model.addAttribute("studentCPR", stu.cpr);
        return "student/detail";
        //return "The name is: " + stu.getFirstName() + " and the cpr is " + stu.getCpr();
    }

    @GetMapping("/deleteStudent")
    public String deleteStudents(@RequestParam String cpr, Model model) {
        boolean stu = studentRepository.delete(cpr);
        indexRead(model);
        if (stu) {
            return "index";
        }
        else {
            return "index";
        }
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        Student stud = new Student();
        model.addAttribute("student",stud);
        return "create";
    }

    /*
    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model) {
        Student stud = new Student();
        model.addAttribute("student", stud);
        return "create";
    }
    */

    @PostMapping("/addStudentForm")
    public String addStudentSubmit(@ModelAttribute Student student, Model model) {
        indexRead(model);
        studentRepository.create(student);
        return "index";
    }



    public void indexRead(Model model) {
        model.addAttribute("students", studentRepository.readAll());
    }
}