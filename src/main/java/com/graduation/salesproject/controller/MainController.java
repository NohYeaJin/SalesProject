package com.graduation.salesproject.controller;

import com.graduation.salesproject.domain.MemberDTO;
import com.graduation.salesproject.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class MainController {

    private final MemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/customlogin", method = RequestMethod.GET)
    public String tologin() {
        return "custom-login";
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public String toMyAccount() { return "my-account"; }

    @PostMapping("/newUser")
    public String signup(MemberDTO memberDTO) {
        memberService.joinUser(memberDTO);
        return "redirect:/";
    }
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String tosignup() {
        return "custom-signup";
    }

    @RequestMapping("/denied")
    public String denied(Model model, Authentication auth, HttpServletRequest req) {
        AccessDeniedException ade = (AccessDeniedException) req.getAttribute(WebAttributes.ACCESS_DENIED_403);
        model.addAttribute("auth", auth);
        model.addAttribute("errMsg", ade);
        return "/denied";
    }




}
