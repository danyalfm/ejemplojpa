package com.example.ejemplojpa.controllers;

import com.example.ejemplojpa.constant.ViewConstant;
import com.example.ejemplojpa.model.UserRoleModel;
import com.example.ejemplojpa.services.UserRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    @Qualifier("userRoleServiceImpl")
    private UserRoleService userRoleService;


    private static final Log log = LogFactory.getLog(ContactController.class);

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/userRole/showUserRole";
    }

    @GetMapping("/userRoleForm")
    public String redirectUserRoleForm(Model model,
                                       @RequestParam(name = "userRoleId", required = false) int userRoleId){
        UserRoleModel userRoleModel = new UserRoleModel();
        if(userRoleId != 0){
            userRoleModel = userRoleService.findUserRoleByUserRoleIdModel(userRoleId);
        }
        model.addAttribute("userRoleModel", userRoleModel);
        return ViewConstant.USER_ROLE_FORM;
    }

    @PostMapping("/adduserRole")
    //El ModelAttribute corresponde con el th:object que utilizamos en la vista de contactform
    public String addUserRole(@ModelAttribute(name = "userRoleModel")UserRoleModel userRoleModel,
                          Model model){
        log.info("Method: addUserRole() -- Params: "+userRoleModel.toString());
        if(userRoleService.addUserRole(userRoleModel) != null){
            model.addAttribute("result", 1);//esto es para que se muestre un mensaje de que se agregó éxitosamente
        }else{
            model.addAttribute("result", 0);
        }
        return "redirect:/userRole/showUserRole";
    }

    @GetMapping("/showUserRole")
    public ModelAndView showUserRole(){
        ModelAndView mav = new ModelAndView(ViewConstant.USER_ROLE);
        mav.addObject("userRole", userRoleService.listAllUserRoles());
        return mav;
    }

    @GetMapping("/removeUserRole")
    public ModelAndView removeUser(@RequestParam(name = "userRoleId", required = true) int userRoleId){
        userRoleService.removeUserRole(userRoleId);
        return showUserRole();
    }

}
