package com.huangyujie.demo.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(String userId);
	User findUserByUserName(String userName);

	

}
