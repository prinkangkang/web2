package com.example.demo.Controller;

import com.example.demo.Directory;
import com.example.demo.dService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowController {
    @Autowired
    private dService service;
    @GetMapping("/directory.html")
    public String show(Model model)
    {
        List<Directory> list= service.getALL();
        model.addAttribute("List",list);
        return "directory";
    }
}
