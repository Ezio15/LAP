package com.stg.elap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.elap.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

	

	List<UserModel> findByemail(String email);
	

}
