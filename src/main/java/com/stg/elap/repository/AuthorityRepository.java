package com.stg.elap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.elap.model.AuthorityModel;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityModel,Long>{

	AuthorityModel findByName(String name);

}
