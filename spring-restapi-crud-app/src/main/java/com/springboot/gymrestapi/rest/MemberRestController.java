package com.springboot.gymrestapi.rest;

import com.springboot.gymrestapi.entity.Member;
import com.springboot.gymrestapi.service.MemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO --> define a REST controller 

@RestController
@RequestMapping("/api")
public class MemberRestController {
    
    private MemberService memberService;

    @Autowired
    public MemberRestController(MemberService theMemberService){
        this.memberService = theMemberService;
    }

    // lets create an endpoint that returns the list of employees
    @GetMapping("/members")
    public List<Member> findAll(){
        return memberService.findAll();
    }


}
