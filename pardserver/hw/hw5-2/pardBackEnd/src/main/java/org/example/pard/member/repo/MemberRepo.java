package org.example.pard.member.repo;

import org.example.pard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// DB 와 소통할때 사용되는 부분. JPA 가 자동으로 처리해줌.
public interface MemberRepo extends JpaRepository<Member, Long> {
   List<Member> findByPart(String part);
}
