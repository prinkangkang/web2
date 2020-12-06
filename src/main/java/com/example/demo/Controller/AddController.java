package com.example.demo.Controller;

import com.example.demo.Directory;
import com.example.demo.dService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Controller
public class AddController {
    @Autowired
    private dService service;

    public static HashMap<Integer,Directory> map=new HashMap<>();
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
            Directory d=new Directory(name,tel,email,address,QQ);
            service.save(d);

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
        service.delete(id);
        map.remove(id);
        return "redirect:/directory.html";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("list",service.get(id));
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
        service.delete(id);
        if(name!=null&&tel!=null&&email!=null&&address!=null&&QQ!=null)
        {
            Directory d=new Directory(name,tel,email,address,QQ);
            service.save(d);

        }
        return "redirect:/directory.html";
    }
    @PostMapping("/tel_judge")
    public void tel_judge(String tel, HttpServletResponse response)
    {
        List<Directory> list= service.getALL();
        for(Directory d:list)
        {
            if(tel.equals(d.tel)) {
                try {
                    response.getWriter().print("false");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }

        }
        try {
            response.getWriter().print("true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
