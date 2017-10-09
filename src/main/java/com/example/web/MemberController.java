package com.example.web;

import com.example.domain.JobRank;
import com.example.domain.Member;
import com.example.service.MemberService;
import com.example.service.JobRankService;
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
@RequestMapping("members")
public class MemberController {
    @Autowired
    MemberService memberService;
    
    @Autowired
    JobRankService jobRankService;

    @ModelAttribute
    MemberForm setUpForm() {
        return new MemberForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        
        Map<String,String> jobRankItems = getJobRankItems();
        model.addAttribute("jobRankItems", jobRankItems);
        
        Map<String,String> memberKbnItems = getMemberKbnItems();
        model.addAttribute("memberKbnItems", memberKbnItems);

        return "members/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated MemberForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        Member member = new Member();
        BeanUtils.copyProperties(form, member);
        memberService.create(member);
        return "redirect:/members";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, MemberForm form, Model model) {
        Member member = memberService.findOne(id);
        BeanUtils.copyProperties(member, form);
        
        Map<String,String> jobRankItems = getJobRankItems();
        model.addAttribute("jobRankItems", jobRankItems);
        
        Map<String,String> memberKbnItems = getMemberKbnItems();
        model.addAttribute("memberKbnItems", memberKbnItems);
        
        return "members/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated MemberForm form, BindingResult result, Model model,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form, model);
        }
        Member member = new Member();
        BeanUtils.copyProperties(form, member);
        member.setId(id);
        memberService.update(member);
        return "redirect:/members";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/members";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        memberService.delete(id);
        return "redirect:/members";
    }
    
    private Map<String,String> getJobRankItems(){
    	
    	List<JobRank> jobRanks = jobRankService.findAll();
    	
        Map<String, String> selectMap = new LinkedHashMap<String, String>();
        
        for(JobRank jobRank: jobRanks){
            selectMap.put(jobRank.getId().toString(), jobRank.getJobRankCd());
        }
        return selectMap;
   }
    
    private Map<String,String> getMemberKbnItems(){
    	
    	Map<String, String> selectMap = new LinkedHashMap<String, String>();
    	
    	selectMap.put("1", "直営");
    	selectMap.put("2", "協力会社");
    	
    	return selectMap;
    }
}
