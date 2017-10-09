package com.example.web;

import com.example.domain.Member;
import com.example.domain.ManHour;
import com.example.service.ManHourService;
import com.example.service.MemberService;
import com.example.service.LoginUserDetails;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manHours")
public class ManHourController {
    @Autowired
    ManHourService manHourService;
    
    @Autowired
    MemberService memberService;

    @ModelAttribute
    ManHourForm setUpForm() {
        return new ManHourForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<ManHour> manHours = manHourService.findAll();
        model.addAttribute("manHours", manHours);
        
        Map<String,String> memberItems = getMemberItems();
        model.addAttribute("memberItems", memberItems);
        
        HashMap<String, HashMap<String, HashMap<String, Double>>> manHourList = manHourService.findAllManHourList(); 
        model.addAttribute("manHourList", manHourList);
        
        
        
        return "manHours/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated ManHourForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        ManHour manHour = new ManHour();
        BeanUtils.copyProperties(form, manHour);
        manHourService.create(manHour);
        return "redirect:/manHours";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, ManHourForm form, Model model) {
        ManHour manHour = manHourService.findOne(id);
        BeanUtils.copyProperties(manHour, form);
        
        Map<String,String> memberItems = getMemberItems();
        model.addAttribute("memberItems", memberItems);
        
        return "manHours/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated ManHourForm form, BindingResult result, Model model,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form, model);
        }
        ManHour manHour = new ManHour();
        BeanUtils.copyProperties(form, manHour);
        manHour.setId(id);
        manHourService.update(manHour);
        return "redirect:/manHours";
    }

    @RequestMapping(value = "edit", params = "goToTop", method = RequestMethod.POST)
    String goToTop() {
        return "redirect:/manHours";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        manHourService.delete(id);
        return "redirect:/manHours";
    }
    
    private Map<String,String> getMemberItems(){
    	
    	List<Member> members = memberService.findAll();
    	
        Map<String, String> selectMap = new LinkedHashMap<String, String>();
        
        for(Member member: members){
            selectMap.put(member.getId().toString(), member.getLastname() + " " + member.getFirstname());
        }
        return selectMap;
   }
}
