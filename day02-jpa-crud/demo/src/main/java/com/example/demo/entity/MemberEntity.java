package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// DTO랑 달리 물리 테이블의 구조와 일치해야 작동함
// entity에서 setter 은 필요한 필드만 직접 구현하는게 맞으니 학습과정에선 편의상 @Data 사용
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 선언한 클래스의 빌더 패턴을 가지는 클래스를 생성
@Entity // bean 에 entity로 등록
@Table(name = "member") // 테이블의 이름을 지정. 선언을 안 한 경우 클래스 이름으로 설정됨. 이름은 물리테이블 명으로 설정
public class MemberEntity {

    @Id // 해당 변수를 PK로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 값이 없어도 자동으로 할당시킴
    private Long idx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
