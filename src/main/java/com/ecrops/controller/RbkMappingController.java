//package com.ecrops.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.ecrops.entity.Employeename;
//import com.ecrops.service.RbkService;
//
//@Controller
//public class RbkMappingController {
//	
//	@Autowired
//	private RbkService rbkService;
//	
//
//    @PostMapping("/rbkSaveprofile")
//    public String saveEmployee(@ModelAttribute("rbk") Employeename employee, HttpSession httpSession, Model model) {
//   	 String district = (String) httpSession.getAttribute("dcode");
//   	 String mandal   = (String) httpSession.getAttribute("mcode");
//   	 String userId = (String) httpSession.getAttribute("userid");
//   		 List<Employeename[]> savedEmp = rbkService.getEmployeeDetails(Integer.parseInt(district),Integer.parseInt(mandal), userId);   	 
//   	 return "rbkSaveprofile";     
//    }   
//}
