package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
        //ControllerV3로 구현된것은 참 반환 , 아니면 거짓
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //위에서 supports로 한번 걸렀기에 캐스팅해도됨
        ControllerV3 controllerV3 = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controllerV3.process(paramMap);
        //V3는 ModelView를 반환했었음 , V4는 String을 반환할 것이기에 그때 또 달라질것임
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
                paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
