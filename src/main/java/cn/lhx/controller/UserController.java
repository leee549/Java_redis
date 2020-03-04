package cn.lhx.controller;

/**
 * @author lee549
 * @date 2020/2/26 21:53
 */

import cn.lhx.entity.User;
import cn.lhx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String queryAllUsers(Model model) {
        List<User> users = userService.selectAllUser();
        model.addAttribute("users", users);
        System.out.println(users);
        return "forward:/WEB-INF/users.jsp";
    }

    @RequestMapping("/register")
    public String saveUser(User user) {
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//      String str = simpleDateFormat.format(user.getDate());
//        System.out.println(str);


        userService.insertUser(user);
        return "redirect:/users";
    }
    @RequestMapping("/update")
    public String update(User user){
        user.setId(14L);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/toregister")
    public String registerPage() {
        return "forward:/WEB-INF/register.jsp";
    }

    @GetMapping("/login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(user.getName(),
                        user.getPassword(),
                        false);
        subject.login(token);
        return "redirect:/users";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "forward:/index.jsp";
    }
}
