package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static hello.hellospring.repository.MemoryMemberRepository.store;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository  = new MemoryMemberRepository();

    @AfterEach //아래 각 메서드 하나 끝날 때마다 실행되는 메서드. 콜백함수
    public void afterEach() {
        repository.clearStore(); //store 를 비워준다, 하나의 테스트가 끝날 때마다..
        
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Raphael");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        System.out.println("result = " + (result == member)); //이거는 아마추어 방식. 아래가 전문가방식
        Assertions.assertEquals(member, result); //참이면 테스트 오류 없음
        //Assertions.assertEquals(member, null); //거짓이면 테스트 오류 발생
        assertThat(member).isEqualTo(result); // 위에 보다 더 편한방식, option + Enter 옵션에서 import  해주면 assertThat만 입력해도 사용 가능

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Arthur");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("popo");
        repository.save(member2);

        Optional<Member> resultOptional = repository.findByName("Arthur");

        Member result = repository.findByName("popo").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("popo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ArthurShin");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
