package com.demo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springdemo.dao.CustomerDao;
import com.demo.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao customerdao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List <Customer> theCustomers=customerdao.getCustomers();
		
		theModel.addAttribute("customers",theCustomers);
		
		//System.out.println(theCustomers);

		return "list-customers";
	}
	
	
}
