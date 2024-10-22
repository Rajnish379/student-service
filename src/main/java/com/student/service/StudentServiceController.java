package com.student.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentServiceController {
    private static Map<String, List<Student>> schoolDB;
    static {
        schoolDB = new HashMap<String,List<Student>>();
        List<Student> studList = new ArrayList<>();
        Student stud = new Student("Raj","Class XII");
        studList.add(stud);
        stud = new Student("Ramu","Class XI");
        studList.add(stud);
        schoolDB.put("abcschool",studList);
        studList = new ArrayList<>();
        stud = new Student("Rutwik","Class X");
        studList.add(stud);
        stud = new Student("Ramya","Class VII");
        studList.add(stud);
        schoolDB.put("xyzschool",studList);
    }

    @RequestMapping("/getStudentDetailsForSchool/{schoolname}")
    public List<Student> getStudents(@PathVariable String schoolname)
    {
        List<Student> studList = schoolDB.get(schoolname);
        return studList;
    }
}
