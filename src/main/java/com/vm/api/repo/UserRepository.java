package com.vm.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vm.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM user WHERE user_mail = ?1", nativeQuery = true)
	List<User> checkUserMail(String user_mail);

	@Query(value = "select * from user where user_mail =?1 and user_passwd=?2", nativeQuery = true)
	List<User> checkUserPassword(String user_mail, String user_passwd);
	
}
