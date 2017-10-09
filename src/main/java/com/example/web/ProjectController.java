package com.example.web;

import com.example.domain.Customer;
import com.example.domain.Project;
import com.example.service.ProjectService;
import com.example.service.CustomerService;
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
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    
    @Autowired
    CustomerService customerService;

    @ModelAttribute
    ProjectForm setUpForm() {
        return new ProjectForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        
        Map<String,String> customerItems = getCustomerItems();
        model.addAttribute("customerItems", customerItems);
        
        return "projects/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated ProjectForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        Project project = new Project();
        BeanUtils.copyProperties(form, project);
        projectService.create(project);
        return "redirect:/projects";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, ProjectForm form, Model model) {
        Project project = projectService.findOne(id);
        BeanUtils.copyProperties(project, form);
        
        Map<String,String> customerItems = getCustomerItems();
        model.addAttribute("customerItems", customerItems);
        
        return "projects/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated ProjectForm form, BindingResult result, Model model,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form, model);
        }
        Project project = new Project();
        BeanUtils.copyProperties(form, project);
        project.setId(id);
        projectService.update(project);
        return "redirect:/projects";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/projects";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        projectService.delete(id);
        return "redirect:/projects";
    }
    
    private Map<String,String> getCustomerItems(){
    	
    	List<Customer> customers = customerService.findAll();
    	
        Map<String, String> selectMap = new LinkedHashMap<String, String>();
        
        for(Customer customer: customers){
            selectMap.put(customer.getId().toString(), customer.getCustomerName());
        }
        return selectMap;
   }
}
