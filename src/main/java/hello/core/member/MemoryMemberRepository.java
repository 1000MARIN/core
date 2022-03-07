package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    // Memory 버전의 MemberRepository

    private static Map<Long, Member> store = new HashMap<>();   // HachMap을 쓰면 동시성 이슈가 발생 할 수 있다.


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
