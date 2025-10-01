package com.example.demo;

import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void contextLoads() {
    }

    // CREATE(생성) 기능 테스트
    // 실제 물리 테이블에 bread1234가 저장
    @Test
    void saveMemberTest() {
        System.out.println("member 저장 테스트");
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId("bread1234");
        memberEntity.setUserName("장발장");
        memberEntity.setUserPw("303356");
        memberEntity.setRegDate(LocalDateTime.now());

        // member 저장
        memberRepository.save(memberEntity);
    }


    // READ(조회) 기능 테스트
    // SELECT * FROM member
    // 저장된 모든 회원을 콘솔에 출력
    @Test
    void findAllTest() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        for (MemberEntity member : memberEntityList) {
            System.out.println(member);
            System.out.println("-----");
        }
    }

    // DELETE(삭제) 기능 테스트
    // DELETE FROM member WHERE idx = 1
    // DB에서 id가 1인 회원을 삭제
    @Test
    void deleteMemberTest() {
        memberRepository.deleteById(1L);
    }

    
    
    // UPDATE(수정) 기능 테스트
    // findById(2L) → 회원 2번을 조회
    // 엔티티 값을 변경 (setUser_name, setUser_pw)
    // save() 호출 시 → UPDATE SQL 실행
    @Test
    void updateMemberTest() {
        MemberEntity member = null;
        Optional<MemberEntity> optionalMember = memberRepository.findById(2L);
        if (optionalMember.isPresent()) {
            member = optionalMember.get();
        }
        member.setUserName("타코튜스데이");
        member.setUserPw("joo96");
        memberRepository.save(member);
    }

}
