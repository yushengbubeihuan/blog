package com.banboo.blog.web.admin;

import com.banboo.blog.po.Type;
import com.banboo.blog.serviceinterface.admin.TypeServiceIntreface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * 分类控制器
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    private TypeServiceIntreface typeServiceIntreface;

    @Autowired
    public void setTypeServiceIntreface(TypeServiceIntreface typeServiceIntreface) {
        this.typeServiceIntreface = typeServiceIntreface;
    }

    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){
        model.addAttribute("page", typeServiceIntreface.listType(pageable));
        return "admin/type";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeServiceIntreface.getType(id));
        return "admin/type-input";
    }

    @PostMapping("/types/newly")
    public String insertType(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeServiceIntreface.getTypeByName(type.getName());
        if (type1 != null){
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/type-input";
        }
        Type type2 = typeServiceIntreface.saveType(type);
        if (type2 == null){
            attributes.addFlashAttribute("message", "新增失败");
        }else{
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String updateType(@Valid Type type,@PathVariable Long id, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeServiceIntreface.getTypeByName(type.getName());
        if (type1 != null){
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/type-input";
        }
        Type type2 = typeServiceIntreface.updateType(id, type);
        if(type2 == null){
            attributes.addFlashAttribute("message", "更新失败");
        }else{
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    @DeleteMapping("types/{id}")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes){
        typeServiceIntreface.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}

























