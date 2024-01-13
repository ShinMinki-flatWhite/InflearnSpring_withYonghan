package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /*
    * 테스트는 한글로 적어도 된다하네요.
    * */

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Arthur");

        //when
        long SaveId  = memberService.join(member);

        //then
        Member findMember = memberService.findOne(SaveId).get();//새로 가입한 계정의 Id 대입
        //Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        assertThat(member.getName()).isEqualTo(findMember.getName()); //Assertions 는 static으로 import해주자
    }


    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("Arthur");

        Member member2 = new Member();
        member2.setName("Arthur"); //똑같은 이름 등록해보자.

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //memberService.join(member2); //이미 존재하는 회원이라고 뜨며 테스트 실패!

/*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            //e.printStackTrace();
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }
*/

        //then
    }


    @Test
    void 멤버전체조회() {
    }

    @Test
    void 멤버찾기() {
    }
}