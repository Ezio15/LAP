package com.stg.elap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.elap.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long> {

	RoleModel findByName(String name);

}
