package hello.servlet.web.servletmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/** v3
 *  Model 도입
 *  @RequestParam 사용
 *  @RequestMapping -> @GetMapping , @PostMapping **/

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
//GET인 경우에만 호출되도록!
    @GetMapping(value = "/new-form")
    public String newForm(){
        return "new-form";
    }
//POST인 경우에만 호출되도록!
    @PostMapping(value = "/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);
        System.out.println("member = " + member);
        model.addAttribute("member", member);
        return "save-result";
    }

    //springmvc/v2/members 로 가면 여기가 호출됨!
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }
}
