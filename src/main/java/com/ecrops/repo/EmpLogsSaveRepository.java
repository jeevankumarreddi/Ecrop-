package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class EmpLogsSaveRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public int saveEmployeeLogDetails(Integer dcode,Integer emp_code, Integer mcode, 
			Integer rbkcode2, String rbkuserid, Integer wbdcode, Integer wbmcode) {
		String insertQry ="INSERT INTO ecrop2023.emp_rbk_map_logs(dcode, empcode, mcode, rbkcode, rbkuserid, wbdcode, wbmcode, ts) VALUES (?, ?, ?, ?, ?, ?, ?, now())";
		Query sql = entityManager.createNativeQuery(insertQry);
		sql.setParameter(1, dcode);
		sql.setParameter(2, emp_code);
		sql.setParameter(3, mcode);
		sql.setParameter(4, rbkcode2);
		sql.setParameter(5, rbkuserid);
		sql.setParameter(6, wbdcode);
		sql.setParameter(7, wbmcode);
		int executeUpdate = sql.executeUpdate();
		return executeUpdate;
		
	}

}
