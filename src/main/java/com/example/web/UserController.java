package com.example.web;

import com.example.domain.User;
import com.example.service.LoginUserDetails;
import com.example.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute
    UserForm setUpForm() {
        return new UserForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated UserForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        user.setEncodedPassword(passwordEncoder.encode(form.getPassword()));
        userService.create(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam String username, UserForm form) {
        User user = userService.findOne(username);
        BeanUtils.copyProperties(user, form);
        return "users/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam String username, @Validated UserForm form, BindingResult result,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(username, form);
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        user.setUsername(username);
        user.setEncodedPassword(passwordEncoder.encode(form.getPassword()));
        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/users";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam String username) {
        userService.delete(username);
        return "redirect:/users";
    }
}
