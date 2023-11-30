package com.ecrops.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.projection.EmployeeName;
import com.ecrops.projection.WbVillageRepository;
import com.ecrops.repo.EmpRepo;
import com.ecrops.repo.WbvillageRepository;
import com.ecrops.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	

	@Autowired
	private EmployeeService employeeService;
	

	@Autowired
	private WbvillageRepository wbVillageRepository;
	
	@Autowired
	private EmpRepo empRepo;

	@GetMapping("/getRevenueVillage")
	public List<WbVillageRepository> getRevenueVillage(@RequestParam("rbkCode") Integer rbkCode) {
		System.out.println("rbkcode--->"+rbkCode);
		List<WbVillageRepository> entities = new ArrayList<>();
		try {
			entities = wbVillageRepository.getWebLandDet(rbkCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;

	
	}
	
	
	@GetMapping("/getEmployeeByRevenue")
	public List<EmployeeName> getEmployeeByRevenue(HttpSession httpSession, @RequestParam("rbkCode") Integer rbkCode) {
        String district = (String) httpSession.getAttribute("dcode");
		String mandal = (String) httpSession.getAttribute("mcode");
		List<WbVillageRepository> webLandDetails = employeeService.getWebLandDetails(Integer.parseInt(district),
				Integer.parseInt(mandal));
		String wbdcode2 = webLandDetails.get(0).getWbdcode();
		String wbmcode2 = webLandDetails.get(0).getWbmcode();
		List<EmployeeName> entities = new ArrayList<>();
		try {
			entities = empRepo.getEmpByRevenue(rbkCode, Integer.parseInt(wbdcode2), Integer.parseInt(wbmcode2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;

	
	}
}
