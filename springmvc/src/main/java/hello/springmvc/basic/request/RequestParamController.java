package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("Method : {}",request.getMethod());
        log.info("username= {} , age= {} ", username, age);
        response.getWriter().write("OK, name : "+username+"  age : "+age);
    }

    @ResponseBody //뷰리졸버 안찾고 return String 그대로 반환
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("MemberName= {} , MemberAge= {} ", memberName,memberAge);
        return "OK";
        // Controller 이면서 Return String 하면? -> 뷰리졸버를 찾는다
        // -> @ResponseBody를 붙여라
    }
    @ResponseBody //뷰리졸버 안찾고 return String 그대로 반환
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("MemberName= {} , MemberAge= {} ", username,age);
        return "OK";
    }
    @ResponseBody //뷰리졸버 안찾고 return String 그대로 반환
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("MemberName= {} , MemberAge= {} ", username,age);
        return "OK";
    }
}
