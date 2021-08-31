package com.graduation.salesproject.service;

import com.graduation.salesproject.domain.MemberDTO;
import com.graduation.salesproject.domain.MemberEntity;
import com.graduation.salesproject.domain.Role;
import com.graduation.salesproject.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDTO memberDto) {

        //가입 날짜, 시간
        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Calendar time = Calendar.getInstance();

        //member값 초기화
        MemberDTO newMember = new MemberDTO(null,null,null,null,null,null,null,null,null,null,null,null,null,0);

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newMember.setNickname(memberDto.getNickname());
        newMember.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        newMember.setPhonenum(memberDto.getPhonenum());
        newMember.setPostcode(memberDto.getPostcode());
        newMember.setJoindate(format1.format(time.getTime()));
        newMember.setEmail(memberDto.getEmail());
        newMember.setRole(Role.MEMBER);
        newMember.setAddress(memberDto.getAddress());
        newMember.setDetail_address(memberDto.getDetail_address());
        newMember.setCertified(0);
        newMember.setPostcode("00000");
        return memberRepository.save(newMember.toEntity()).getMember_id();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(userEmail);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

    public MemberEntity loadMyInfo(String userEmail){
        Optional<MemberEntity> memberInfoEntity = memberRepository.findByEmail(userEmail);
        MemberEntity userEntity = memberInfoEntity.get();
        return userEntity;
    }


}

