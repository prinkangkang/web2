package com.example.demo.Controller;

import com.example.demo.Directory;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class AddController {

    public static HashMap<Integer,Directory> map=new HashMap<>();
    int i=0;
    @PostMapping("/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("tel") String tel,
                      @RequestParam("email") String email,
                      @RequestParam("address") String address,
                      @RequestParam("QQ") String QQ
                      )
    {
        if(name!=null&&tel!=null&&email!=null&&address!=null&&QQ!=null)
        {
            map.put(i,new Directory(i,name,tel,email,address,QQ));
            i++;
        }
        return "redirect:/directory.html";
    }
    @PostMapping("/addpage")
    public String page()
    {
        return "add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        map.remove(id);
        return "redirect:/directory.html";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("list",map.get(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit_add(@RequestParam("name") String name,
                           @RequestParam("tel") String tel,
                           @RequestParam("email") String email,
                           @RequestParam("address") String address,
                           @RequestParam("QQ") String QQ,
                           @RequestParam("id")  int id
    )
    {
        map.put(id,new Directory(id,name,tel,email,address,QQ));
        return "redirect:/directory.html";
    }

}
