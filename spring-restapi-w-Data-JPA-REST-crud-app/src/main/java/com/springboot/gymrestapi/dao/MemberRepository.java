package com.springboot.gymrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.gymrestapi.entity.Member;

//TODO --> Using JPA Data to create a DAO for me and all of the CRUD operations

@RepositoryRestResource(path="changed")
public interface MemberRepository extends JpaRepository<Member, Integer>{
    


}
