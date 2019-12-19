package com.banboo.blog.web;

import com.banboo.blog.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        int i = 9/0;
//        String blog = null;
//        if(blog == null){
//            throw new NotFoundException("博客为空");
//        }
//        System.out.println("--------index--------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
}
