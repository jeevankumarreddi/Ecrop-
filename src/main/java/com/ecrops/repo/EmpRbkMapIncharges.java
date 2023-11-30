package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class EmpRbkMapIncharges {

	public EmpRbkMapIncharges() {
		
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int saveEmpRbkMapIncharges(Integer district, Integer mandal, Integer rbkCode, Integer emp,  
			 String userId ,Integer wbdcode2, Integer wbmcode2, String incharge, String status) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_incharges(dcode, mcode, rbkcode, empcode, rbkuserid, wbdcode, wbmcode,inchargests,status, ts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, district);
		sql.setParameter(2, mandal);
		sql.setParameter(3, rbkCode);
		sql.setParameter(4, emp);
		sql.setParameter(5, userId);
		sql.setParameter(6, wbdcode2);
		sql.setParameter(7, wbmcode2);
		sql.setParameter(8, incharge);
		sql.setParameter(9, status);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
	}


}
