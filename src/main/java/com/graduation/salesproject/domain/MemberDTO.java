package com.graduation.salesproject.domain;

import lombok.*;


@Getter
@Setter
@ToString
public class MemberDTO {

    private Long member_id;
    private String email;
    private String password;
    private String nickname;
    private String joindate;
    private String job;
    private Role role;
    private String school;
    private String department;
    private String phonenum;
    private String postcode;
    private String address;
    private String detail_address;
    private int certified;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .member_id(member_id)
                .email(email)
                .password(password)
                .nickname(nickname)
                .joindate(joindate)
                .job(job)
                .role(role)
                .school(school)
                .department(department)
                .phonenum(phonenum)
                .postcode(postcode)
                .address(address)
                .detail_address(detail_address)
                .certified(certified)
                .build();
    }

    @Builder
    public MemberDTO(Long member_id,String email, String password, String nickname,String joindate, String job, Role role,String school, String department, String phonenum,String postcode,String address, String detail_address, int certified){
        this.member_id = member_id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.joindate = joindate;
        this.job = job;
        this.role = role;
        this.school = school;
        this.department = department;
        this.phonenum = phonenum;
        this.postcode = postcode;
        this.address = address;
        this.detail_address = detail_address;
        this.certified = certified;
    }



}
