package com.example.springbootunittests.controller;

import com.example.springbootunittests.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/demo
//https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
//add dependency to pom file

//Logging: https://logging.apache.org/log4j/2.0/manual/architecture.html
//RELOAD Intellij setting:  https://www.mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/
//Demo logging: https://github.com/udacity/JDND/tree/master/demos/c1/spring-boot-logging


@Controller
public class UserController {

    @RequestMapping("demo")
    public String demo(Model model) {
        model.addAttribute("message", "Hello");
        double grade = 90.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));
        // return to templates/demo.html page.
        return "demo";
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @RequestMapping("demo2")
    public String demo2(Model model) {
        List<User> lst = new ArrayList<>();
        lst.add(new User(1, "Tom", 32));
        lst.add(new User(2, "Jerry", 29));
        lst.add(new User(3, "Nancy", 27));
        model.addAttribute("list", lst);
        return "demo2";
    }

    @RequestMapping("demo3")
    public String demo3(HttpServletRequest request, Model model) {
        // Request
        request.setAttribute("request", "request data");
        // Session
        request.getSession().setAttribute("session", "session data");
        // Application
        request.getSession().getServletContext().setAttribute("application", "application data");
        return "demo2";
    }
}
