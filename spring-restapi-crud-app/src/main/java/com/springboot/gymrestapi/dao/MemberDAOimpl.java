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

    @Override
    public Member findById(int theId) {

        // first we have to get the member
        Member theMember = entityManager.find(Member.class, theId);

        return theMember;

    }

    @Override
    public Member save(Member theMember) {

        // lets save our member
        Member dbMember = entityManager.merge(theMember);

        return dbMember;
    }

    @Override
    public void deleteById(int theId) {

        // find the member by their ID
        Member theMemebr = entityManager.find(Member.class, theId);

        entityManager.remove(theMemebr);

    }
    
}
