package com.springboot.gymrestapi.service;

import java.util.List;

import com.springboot.gymrestapi.entity.Member;

//TODO --> Lets create/implement the Service Layer

//TODO --> Quick recap on what a Service Layer is 

public interface MemberService {
    
    List<Member> findAll();

    Member findById(int theId);

    Member save(Member theMember);

    public void deleteById(int theId);
}
