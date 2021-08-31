package com.graduation.salesproject.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member_infos")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String joindate;

    @Column(length = 20, nullable = true)
    private String job;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = true)
    private Role role;

    @Column(length = 20, nullable = true)
    private String school;

    @Column(length = 20, nullable = true)
    private String department;

    @Column(length = 20, nullable = false)
    private String phonenum;

    @Column(length = 10, nullable = false)
    private String postcode;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String detail_address;

    @Column(nullable = true)
    private int certified;

    @Builder
    public MemberEntity(Long member_id,String email, String password, String nickname,String joindate, String job,Role role, String school, String department, String phonenum,String postcode,String address, String detail_address, int certified){
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



