package com.ecrops.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Emplogsentity;
import com.ecrops.entity.Employeename;
import com.ecrops.entity.WbVillageEntity;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.WbVillageRepository;
import com.ecrops.repo.EmpLogsRepo;
import com.ecrops.repo.EmpRepo;
import com.ecrops.repo.InchargeRbkRepo;
import com.ecrops.repo.RbkRepo;
import com.ecrops.repo.WbvillageRepository;
import com.ecrops.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmpRepo repo;
	
	@Autowired
	private RbkRepo repo2;
	
	@Autowired
	private InchargeRbkRepo inchargeRbkRepo;
	
	@Autowired
	private EmpLogsRepo empLogsRepo;
	
	@Autowired
	private WbvillageRepository wbvillageRepository;
	
	@Override
	public List<Employeename> addingEmployee(Integer district, Integer mandal, Integer village, 
			String aadharId, Integer empCode, String empName, String email, Long mobileNo) {
		return repo.saveEmployeeRegistration(district, mandal, village, aadharId, empCode, empName, email, mobileNo);
	}

	@Override
	public List<Employeename> getAllEmployees() {
		return null;
	}

	@Override
	public List<Employeename> getAadharExists(String aadharId) {
		return repo.getAadharExits(aadharId);
	}
	
	@Override
	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, Integer empCode) {
		return repo2.getEmployeeDetails(district, mandal, empCode);
	}

	@Override
	public List<InchargeRbkProjection> getInchargeStatus(Integer rbkCode) {
		return inchargeRbkRepo.getInchargeStatus(rbkCode);
	}

	@Override
	public Optional<Emplogsentity> saveEmpLogDetails(Integer dcode, Integer emp_code,Integer mcode,Integer rbkcode2,String rbkuserid, Integer vcode,Integer wbdcode,Integer wbmcode) {
		return empLogsRepo.saveEmplogs(dcode, emp_code, mcode, rbkcode2, rbkuserid, vcode, wbdcode, wbmcode);
	}

	@Override
	public List<InchargeRbkProjection> getRbkDetailsToSave(Integer rbkCode) {
		return inchargeRbkRepo.getRbkDetailsToSave(rbkCode);
	}

	@Override
	public List<RbkDetailsProjection> updateInchargeStatus(String incStatus, Integer empCode, Integer rbkCode) {
		return inchargeRbkRepo.updateInchargeStatus(incStatus,empCode,rbkCode);
	}
	
	@Override
	public List<WbVillageRepository> getWebLandDetails(Integer dcode,Integer mcode) {
		return wbvillageRepository.getWebLandDetails(dcode, mcode);
	}

//	@Override
//	public List<Employeename> getMobileExists(Long mobile) {
//		// TODO Auto-generated method stub
//		return repo.getMobileExists(mobile);
//	}

		
}