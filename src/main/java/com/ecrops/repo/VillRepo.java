package com.ecrops.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecrops.entity.Village;
import com.ecrops.projection.VillageName;

public interface VillRepo extends JpaRepository<Village, Long>
{
	@Query(value="select vcode, vname from ecrop2023.vill_sec_det where mcode=:mandal",nativeQuery=true)
	public List<VillageName> findVillName(@Param("mandal") Integer mandal);

}
