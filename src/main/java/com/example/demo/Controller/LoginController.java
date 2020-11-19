package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
public class LoginController{
    @RequestMapping({"/","/login.html"})
    public String index(){
        return "login";
    }
    @RequestMapping("**")
    public String judge(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        if(session==null){
            return "redirect:/login.html";
        }
        else
        {
            return "redirect:/directory.html";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpServletRequest request){
            if("admin".equals(username)&&"123456".equals(password)){
            //设置账号为：admin，密码为：123456
                HttpSession session=request.getSession();
                session.setAttribute("user",username);
                return "redirect:/directory.html";
            }
            else{
            //账号或者密码错误，返回主页面
                model.addAttribute("message","账号或者密码出错");
                return "login";
            }
        }

}

