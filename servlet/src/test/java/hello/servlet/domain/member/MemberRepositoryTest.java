package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/** Junit5부터는 public이 없어도 됨 (4까진 public이 필요했어) **/
class MemberRepositoryTest {
    MemberRepository memberRepository=MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception{
        //given
        Member member = new Member("Hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }
    @Test
    public void findAll() throws Exception{
        //given
        Member member1 = new Member("member1", 1);
        Member member2 = new Member("member2", 2);

        //when
        Member save1 = memberRepository.save(member1);
        Member save2 = memberRepository.save(member2);

        //then
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
