package com.example.web;

import com.example.domain.JobRank;
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

import java.util.List;

@Controller
@RequestMapping("jobRanks")
public class JobRankController {
    @Autowired
    JobRankService jobRankService;

    @ModelAttribute
    JobRankForm setUpForm() {
        return new JobRankForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<JobRank> jobRanks = jobRankService.findAll();
        model.addAttribute("jobRanks", jobRanks);
        return "jobRanks/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated JobRankForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        JobRank jobRank = new JobRank();
        BeanUtils.copyProperties(form, jobRank);
        jobRankService.create(jobRank);
        return "redirect:/jobRanks";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, JobRankForm form) {
        JobRank jobrank = jobRankService.findOne(id);
        BeanUtils.copyProperties(jobrank, form);
        return "jobRanks/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated JobRankForm form, BindingResult result,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        JobRank jobRank = new JobRank();
        BeanUtils.copyProperties(form, jobRank);
        jobRank.setId(id);
        jobRankService.update(jobRank);
        return "redirect:/jobRanks";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/jobRanks";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        jobRankService.delete(id);
        return "redirect:/jobRanks";
    }
}
