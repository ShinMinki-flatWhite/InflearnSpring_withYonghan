package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    public static Map<Long, Member> store = new HashMap<>();
    public static Long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence); //멤버저장할 때 시퀀스 값 1 올려줄거야, sequence값을 Id로 할거야.
        store.put(member.getId(), member); //Map에 저장할겨.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable( store.get(id) ); //Null 값이 나올 수 있으므로 Optional 클래스를 사용하자.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //저장된 값들(member)을 ArrayList로 만들어서 출력해줘.
    }
}
