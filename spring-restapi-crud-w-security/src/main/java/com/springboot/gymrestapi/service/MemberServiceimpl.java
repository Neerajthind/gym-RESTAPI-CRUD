package com.springboot.gymrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gymrestapi.dao.MemberDAO;
import com.springboot.gymrestapi.entity.Member;

import jakarta.transaction.Transactional;

@Service
public class MemberServiceimpl implements MemberService{

    private MemberDAO memberDAO;

    @Autowired
    public MemberServiceimpl(MemberDAO theMemberDAO){
        
        this.memberDAO = theMemberDAO;
    }


    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }


    @Override
    public Member findById(int theId) {
        return memberDAO.findById(theId);
    }


    @Override
    @Transactional
    public Member save(Member theMember) {
        return memberDAO.save(theMember);

    }


    @Override
    @Transactional
    public void deleteById(int theId) {
        memberDAO.deleteById(theId);

    }
    
}
