package com.stg.elap;

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.stg.elap.model.AuthorityModel;
import com.stg.elap.model.RoleModel;
import com.stg.elap.model.UserModel;
import com.stg.elap.repository.AuthorityRepository;
import com.stg.elap.repository.RoleRepository;
import com.stg.elap.repository.UserRepository;

@Component
public class InitialUserSetup {

	@Autowired
	AuthorityRepository authRepo;

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;

	@EventListener
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent are) {
		System.out.println("----------------------App event started..");
		AuthorityModel readAuthority = createAuthority("READ_AUTHORITY");
		AuthorityModel writeAuthority = createAuthority("WRITE_AUTHORITY");
		AuthorityModel deleteAuthority = createAuthority("DELETE_AUTHORITY");
		
		RoleModel roleUser = createRole("ROLE_USER", Arrays.asList(readAuthority,writeAuthority));
		RoleModel roleAdmin = createRole("ROLE_ADMIN", Arrays.asList(readAuthority,writeAuthority,deleteAuthority));
		
		if(roleAdmin==null) return;
		
		UserModel user = new UserModel();
		user.setEmail("admin@gmail.com");
		user.setName("admin");
		user.setPassword(bcrypt.encode("admin"));
		user.setRoles(Arrays.asList(roleAdmin));
		userRepo.save(user);
	}

	@Transactional
	private AuthorityModel createAuthority(String name) {

		AuthorityModel authority = authRepo.findByName(name);
		if (authority == null) {
			authority = new AuthorityModel(name);
			authRepo.save(authority);
		}

		return authority;

	}

	@Transactional
	private RoleModel createRole(String name, Collection<AuthorityModel> authorities) {

		RoleModel role = roleRepo.findByName(name);
		if (role == null) {
			role = new RoleModel(name);
			role.setAuthorities(authorities);
			roleRepo.save(role);
		}

		return role;

	}
}
