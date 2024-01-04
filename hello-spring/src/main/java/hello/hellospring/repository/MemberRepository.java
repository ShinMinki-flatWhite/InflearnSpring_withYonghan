package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository{

    Member save (Member member); //멤버 저장하기
    Optional<Member> findById(Long id); //아이디로 회원 찾기, Optional은 NullPointException 방지 클래스.
    Optional<Member> findByName(String name); //이름으로 회원 찾기
    List<Member> findAll(); //모든 회원 리스트 반환



}
