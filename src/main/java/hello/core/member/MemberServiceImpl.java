package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // MemberService에 대한 구현체

    private final MemberRepository memberRepository;

    // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
