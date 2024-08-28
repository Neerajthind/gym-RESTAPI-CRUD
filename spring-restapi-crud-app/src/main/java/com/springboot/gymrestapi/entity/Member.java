package com.springboot.gymrestapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//TODO --> created a Member entity that maps to our database

@Entity
@Table(name = "member")
public class Member {
    
    //TODO --> defining data fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName; 

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="membership_type")
    private String membershipType;

    @Column(name= "membership_status")
    private String membershipStatus;

    //TODO --> defining constructors 

    public Member(){

    }

    public Member(
        String firstName, String lastName, String email, 
        String phoneNumber, String membershipType, String membershipStatus
    ){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.membershipStatus = membershipStatus;

    }

    //TODO --> define setter/getter methods 

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getMembershipType(){
        return membershipType;
    }

    public void setMembershipType(String membershipType){
        this.membershipType = membershipType;
    }

    public String getMembershipStatus(){
        return membershipStatus;
    }

    public void setMembershipStatus(String memershipStatus){
        this.membershipStatus = memershipStatus;
    }

    //TODO --> To String method

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membershipType='" + membershipType + '\'' +
                ", membershipStatus='" + membershipStatus + '\'' +
                '}';
}


}
