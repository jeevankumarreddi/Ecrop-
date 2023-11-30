package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.RbkEntity;
import com.ecrops.projection.InchargeRbkProjection;
import com.ecrops.projection.RbkDetailsProjection;

public interface InchargeRbkRepo extends JpaRepository<RbkEntity, String> {
	
	@Query(value = "Select incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getInchargeStatus(@Param("rbkCode") Integer rbkCode);
	

	@Query(value = "Select dcode, mcode, vcode, rbkcode, empcode, ts, rbkuserid, ipaddress, wbdcode, wbmcode, incharge_sts from ecrop2023.emp_rbk_map where rbkcode=:rbkCode", nativeQuery = true)
	public List<InchargeRbkProjection> getRbkDetailsToSave(@Param("rbkCode") Integer rbkCode);
	
	@Query(value = "update  ecrop2023.emp_rbk_map set incharge_sts=:incStatus, empcode=:empCode where rbkcode=:rbkCode", nativeQuery = true)
	public List<RbkDetailsProjection> updateInchargeStatus(@Param("incStatus") String incStatus, @Param("empCode") Integer empCode,@Param("rbkCode") Integer rbkCode);
	

}
