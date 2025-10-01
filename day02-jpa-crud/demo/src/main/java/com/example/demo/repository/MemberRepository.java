package com.example.demo.repository;

import com.example.demo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// 상속받는 타입의 제네릭은 <Entity 클래스명, PK 자료형>
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
