package com.example.web;

import com.example.domain.Member;
import com.example.domain.ProjectSale;
import com.example.service.ProjectSaleService;
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("projectSales")
public class ProjectSaleController {
    @Autowired
    ProjectSaleService projectSaleService;
    
    @Autowired
    MemberService memberService;

    @ModelAttribute
    ProjectSaleForm setUpForm() {
        return new ProjectSaleForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<ProjectSale> projectSales = projectSaleService.findAll();
        model.addAttribute("projectSales", projectSales);
        
        Map<String,String> memberItems = getMemberItems();
        model.addAttribute("memberItems", memberItems);
        
        return "projectSales/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated ProjectSaleForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        ProjectSale projectSale = new ProjectSale();
        BeanUtils.copyProperties(form, projectSale);
        projectSaleService.create(projectSale);
        return "redirect:/projectSales";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, ProjectSaleForm form, Model model) {
        ProjectSale projectSale = projectSaleService.findOne(id);
        BeanUtils.copyProperties(projectSale, form);
        
        Map<String,String> memberItems = getMemberItems();
        model.addAttribute("memberItems", memberItems);
        
        return "projectSales/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated ProjectSaleForm form, BindingResult result, Model model,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form, model);
        }
        ProjectSale projectSale = new ProjectSale();
        BeanUtils.copyProperties(form, projectSale);
        projectSale.setId(id);
        projectSaleService.update(projectSale);
        return "redirect:/projectSales";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/projectSales";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        projectSaleService.delete(id);
        return "redirect:/projectSales";
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
