package com.springboot.gymrestapi.rest;

import com.springboot.gymrestapi.entity.Member;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gymrestapi.dao.MemberDAO;

//TODO --> define a REST controller 

@RestController
@RequestMapping("/api")
public class MemberRestController {
    
    private MemberDAO memberDAO;

    public MemberRestController(MemberDAO theMemberDAO){
        this.memberDAO = theMemberDAO;
    }

    // lets create an endpoint that returns the list of employees
    @GetMapping("/members")
    public List<Member> findAll(){
        return memberDAO.findAll();
    }


}
