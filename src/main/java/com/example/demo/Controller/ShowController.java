package com.example.demo.Controller;

import com.example.demo.Directory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowController {
    @GetMapping("/directory.html")
    public String show(Model model)
    {
        List<Directory> list = new ArrayList<Directory>(AddController.map.values());
        model.addAttribute("List" ,list);
        return "directory";
    }
}
