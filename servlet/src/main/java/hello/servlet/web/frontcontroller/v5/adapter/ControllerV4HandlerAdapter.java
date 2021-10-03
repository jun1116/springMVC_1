package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        //handler가 ControllerV4인 경우에만 처리하는 어댑터
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //핸들러를 ControllerV4로 캐스팅
        ControllerV4 controller = (ControllerV4) handler;
        //파라미터, 모델 세팅하기
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        //컨트롤러V4의 실행의 결과인 viewName 받기 (V4에선 String반환)
        String viewName = controller.process(paramMap, model);
        //어댑터는 ModelView를 만들어서 반환해야해! -> ModelView를 생성해주기!
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);
        return modelView;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
                paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
