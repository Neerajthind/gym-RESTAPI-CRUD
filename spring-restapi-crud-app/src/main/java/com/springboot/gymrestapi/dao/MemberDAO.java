package com.springboot.gymrestapi.dao;

import java.util.List;

import com.springboot.gymrestapi.entity.Member;

//TODO --> Created a DAO interface

public interface MemberDAO{

    List<Member> findAll();
}
