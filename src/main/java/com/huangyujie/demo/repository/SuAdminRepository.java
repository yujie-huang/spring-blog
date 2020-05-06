package com.huangyujie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.SuAdmin;
@Repository
public interface SuAdminRepository extends JpaRepository<SuAdmin,Integer> {

	SuAdmin findBySuadminName(String u);

}
