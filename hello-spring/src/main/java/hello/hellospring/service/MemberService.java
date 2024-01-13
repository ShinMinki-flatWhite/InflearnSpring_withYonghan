package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public long join(Member member){
        //같은 이름 회원가입 방지 1
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        //같은 이름 회원가입 방지 2
        validateDuplicateMember(member); //외부 메서드로 뽑아주기 (control + t, 9)
        memberRepository.save(member);
        return member.getId(); //임의로 Id만 리턴해보자.
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다."); //람다식 사용
        });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * Id넘겨서 Id찾기 검증?
     */
    public Optional<Member> findOne(long memberId) {
        return memberRepository.findById(memberId);
    }

}
