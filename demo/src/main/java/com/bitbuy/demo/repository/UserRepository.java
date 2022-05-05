package com.bitbuy.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitbuy.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "SELECT u FROM User u where userId = :userId")
	User findUserByUserId(@Param("userId") long userId);

	@Query(value = "SELECT password FROM User u where username = :username")
	String findPasswordByUserName(@Param("username") String username);
	
	@Modifying
	@Query(value = "update User u set u.email=?2, u.phone=?3, u.username=?4 where u.userId =?1")
	int updateUserByUserId(long userId, String email, String phone , String username);
	
}
