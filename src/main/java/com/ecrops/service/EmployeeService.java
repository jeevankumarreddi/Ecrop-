package com.ecrops.service;

import java.util.List;
import java.util.Optional;

import com.ecrops.entity.Emplogsentity;
import com.ecrops.entity.Employeename;
import com.ecrops.entity.WbVillageEntity;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.WbVillageRepository;

public interface EmployeeService {
	public List<Employeename> getAllEmployees();
	
	public List<Employeename> addingEmployee(Integer district, Integer mandal, 
			Integer village, String aadharId, Integer empCode, String empName, String email, Long mobileNo);
	
	public List<Employeename> getAadharExists(String aadharId);
//    public List<Employeename>getMobileExists(Long mobile);
//	
	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, Integer empCode);
	
	public List<InchargeRbkProjection> getInchargeStatus(Integer rbkCode);
	
	public Optional<Emplogsentity> saveEmpLogDetails(Integer dcode,Integer emp_code,Integer mcode,Integer rbkcode2,String rbkuserid, Integer vcode,Integer wbdcode,Integer wbmcode);
	
	public List<InchargeRbkProjection> getRbkDetailsToSave(Integer rbkCode);
	
	public List<RbkDetailsProjection> updateInchargeStatus(String incStatus, Integer empCode, Integer rbkCode);

	public List<WbVillageRepository> getWebLandDetails(Integer district, Integer mandal);




}
