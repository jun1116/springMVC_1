package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    /** V2에선 (HttpServletRequest request, HttpServletResponse response)
     *  다 들어갔는데 이젠 그런게 없어 -> 서블릿에 종속적이지 않아 **/
    ModelView process(Map<String, String> paramMap);
}
