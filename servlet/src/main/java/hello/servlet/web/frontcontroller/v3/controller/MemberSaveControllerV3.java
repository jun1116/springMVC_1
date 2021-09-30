package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> parammap) {
        /** HttpServletRequest.get~~을 프론트 컨트롤러에서 요청 다 처리해서, 파람맵에 담아서 넘겨줄거야 **/
        String username = parammap.get("username");
        int age = Integer.parseInt(parammap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
        return mv;
    }
}
