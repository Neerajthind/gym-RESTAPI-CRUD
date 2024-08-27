package com.springboot.gymrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gymrestapi.entity.Member;

//TODO --> Using JPA Data to create a DAO for me and all of the CRUD operations

public interface MemberRepository extends JpaRepository<Member, Integer>{
    


}
