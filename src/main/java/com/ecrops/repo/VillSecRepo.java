package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecrops.entity.Village;
import com.ecrops.projection.ActiveSeasonProjection;

public interface VillSecRepo extends JpaRepository<Village, Integer> {
	

	@Query(value = "select distinct vcode,vname from ecrop2023.vill_sec_det where vcode in (select rbkcode from ecrop2023.emp_rbk_map where mcode=5066) order by vname", nativeQuery = true)
	public List<ActiveSeasonProjection> getRbk();

}
