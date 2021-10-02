package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        /** HttpServletRequest.get~~을 프론트 컨트롤러에서 요청 다 처리해서, 파람맵에 담아서 넘겨줄거야 **/
        String username = paramMap.get("username");//파라미터정보 조회
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);//뷰에서 필요한 member객체를 담아서 반환
        return mv;
    }
}
