package com.springboot.gymrestapi.rest;


import com.springboot.gymrestapi.entity.Member;
import com.springboot.gymrestapi.service.MemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // lets create an endpoint that returns the list of Members (GET)
    @GetMapping("/members")
    public List<Member> findAll(){
        return memberService.findAll();
    }


    // lets create an endpoint that reads a single Member (GET)
    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable int memberId){

        Member theMember = memberService.findById(memberId);

        if(theMember == null){
            throw new RuntimeException("Error. Employee id not found: "  + memberId);
        }

        return theMember;

    }

    // now lets create an enpoint that adds a new member (POST)
    @PostMapping("/members")
    public Member addMember(@RequestBody Member theMember){

        // lets set the id to 0 so its up updated but rather its created 

        theMember.setId(0);

        Member savedMember = memberService.save(theMember);

        return savedMember;

    }


    // now lets create an enpoint that updates an existing member (PUT)
    @PutMapping("/members")
    public Member updateMember(@RequestBody Member member){

        Member updatedMember = memberService.save(member);

        return updatedMember;

    }


    // lets create an endpoint that deletes an existing member (DELETE)

    @DeleteMapping("/members/{memberId}")
    public String deletMember(@PathVariable int memberId){

        Member deletedMember = memberService.findById(memberId);

        if (deletedMember == null){
            throw new RuntimeException("Error. Member id not found " + memberId);
        }

        memberService.deleteById(memberId);

        return ("Member has been deleted : " + memberId);
    }



}
