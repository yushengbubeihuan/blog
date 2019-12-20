package com.banboo.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客控制器
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blog")
    public String blog(){
        return "admin/blog";
    }
}
