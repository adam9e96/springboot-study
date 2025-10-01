package com.example.demo.controller;

import com.example.demo.dto.JoinDTO;
import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Controller
public class MainController {
    @Autowired
    private MemberRepository memberRepository; // 필드 주입(전통적인 방식)

    @GetMapping({"/", "", "index"})
    public String home() {
        System.out.println(">>> home 메서드 호출됨");

        // jpa 테스트
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId("zeta30");
        memberEntity.setUserName("홍길동");
        memberEntity.setUserPw("123456");
        memberEntity.setRegDate(LocalDateTime.now());

        memberRepository.save(memberEntity);

        return "home.html";
    }

    @GetMapping("/member/join")
    public String join() {
        System.out.println(">>> join 메서드 호출됨");
        return "member/join.html";
    }

    @PostMapping("/member/join_proc")
    public String joinProc(
            @ModelAttribute JoinDTO dto, Model model,
            @RequestParam("age") int age,
            HttpServletRequest request) {
        {
            System.out.println(">>> joinProc 메서드 호출됨");


            System.out.println("dto : " + dto.toString());
            System.out.println("age : " + age);
            for (String item : dto.getHobby()) {
                System.out.println(item);
            }

            System.out.println("raw param is_machine = " + request.getParameter("machine"));
            System.out.println("업로드 : " + dto.getUp_file());
            MultipartFile file = dto.getUp_file();
            if (file != null & !file.isEmpty()) {
                System.out.println("원본 파일명: " + file.getOriginalFilename());
                System.out.println("파일 크기: " + file.getSize());
                System.out.println("ContentType: " + file.getContentType());
            }


            model.addAttribute("dto", dto); // dto를 넘김
            model.addAttribute("age", age); // age 변수를 넘김
            return "member/result.html";

        }
    }
}
