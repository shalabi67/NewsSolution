package com.news.models;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>  {
	//active users are active or logged in.
	@Query("select u from User u inner join u.categoryList c where (u.status=1 or u.status=2) and c.id = :categoryId")
	public Set<User> getActiveUsers(@Param("categoryId") Integer categoryId);
	
	@Query("select u from User u where (u.status=1)")
	public Set<User> getActiveUsers();
}
