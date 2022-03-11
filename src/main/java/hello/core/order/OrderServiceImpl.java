package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();    // 정액 할인 제도
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();     // 정률 할인 제도
    private DiscountPolicy discountPolicy;  // 인터페이스에만 의존하도록 설계와 코드 변경
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인된 가격 받기

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 주문 정보 리턴
    }
}
