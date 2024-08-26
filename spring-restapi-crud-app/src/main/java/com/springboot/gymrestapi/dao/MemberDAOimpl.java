package com.springboot.gymrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.gymrestapi.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

//TODO --> created DAO implementation

@Repository
public class MemberDAOimpl implements MemberDAO{

    // defining entitymanager 
    private EntityManager entityManager;


    // constructor injection
    // optional for Autowired notation since we only have one constructor injection
    @Autowired 
    public MemberDAOimpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Member> findAll() {


        // first lets create a query
        TypedQuery<Member> theQuery = entityManager.createQuery("from Member", Member.class);

        // get our resluts from the query
        List<Member> members = theQuery.getResultList();

        return members;



    }
    
}
