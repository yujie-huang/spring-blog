package com.huangyujie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huangyujie.demo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
