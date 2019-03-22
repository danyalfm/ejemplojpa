package com.example.ejemplojpa.controllers;

import com.example.ejemplojpa.constant.ViewConstant;
import com.example.ejemplojpa.model.UserModel;
import com.example.ejemplojpa.services.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    private static final Log log = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/user/showUser";
    }

    @GetMapping("/userForm")
    public String redirectUserForm(Model model,
                                   @RequestParam(name = "username", required = false) String username) {
        UserModel userModel = new UserModel();
        if (username != null) {
            userModel = userService.findUserByUsernameModel(username);
        }
        model.addAttribute("userModel", userModel);
        return ViewConstant.USER_FORM;
    }

    @PostMapping("/adduser")
    //El ModelAttribute corresponde con el th:object que utilizamos en la vista de contactform
    public String addUser(@ModelAttribute(name = "userModel") UserModel userModel,
                          Model model) {
        log.info("Method: addUser() -- Params: " + userModel.toString());
        if (userService.addUser(userModel) != null) {
            model.addAttribute("result", 1);//esto es para que se muestre un mensaje de que se agregó éxitosamente
        } else {
            model.addAttribute("result", 0);
        }
        return "redirect:/user/showUser";
    }

    @GetMapping("/showUser")
    public ModelAndView showUser() {
        ModelAndView mav = new ModelAndView(ViewConstant.USER);
        mav.addObject("user", userService.listAllUsers());
        return mav;
    }

    @GetMapping("/removeUser")
    public ModelAndView removeUser(@RequestParam(name = "username", required = true) String username) {
        userService.removeUser(username);
        return showUser();
    }

}
