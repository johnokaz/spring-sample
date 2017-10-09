package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Sale;
import com.example.repository.SaleRepository;
import com.example.service.CustomerService;
import com.example.service.SaleService;

@Controller
public class HomeController {
	
    @Autowired
    SaleService saleService;;
    
    @RequestMapping("home")
    String home(Model model) {
    	Sale sale = saleService.findBySalesYear("2017");
    	model.addAttribute("sale", sale);
    	
        return "home";
    }
}
