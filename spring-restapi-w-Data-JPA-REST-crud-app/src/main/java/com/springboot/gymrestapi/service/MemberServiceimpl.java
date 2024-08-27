package com.springboot.gymrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gymrestapi.dao.MemberRepository;
import com.springboot.gymrestapi.entity.Member;

@Service
public class MemberServiceimpl implements MemberService{

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceimpl(MemberRepository theMemberRepository){
        
        this.memberRepository = theMemberRepository;
    }


    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }


    @Override
    public Member findById(int theId) {
        Optional<Member> result = memberRepository.findById(theId);

        Member theMember = null;

        if(result.isPresent()){
            theMember = result.get();
        }
        else{
            throw new RuntimeException("Erorr. Did not find Member id: " + theId);
        }

        return theMember;
    }


    @Override
    public Member save(Member theMember) {
        return memberRepository.save(theMember);

    }


    @Override
    public void deleteById(int theId) {
        memberRepository.deleteById(theId);

    }
    
}
