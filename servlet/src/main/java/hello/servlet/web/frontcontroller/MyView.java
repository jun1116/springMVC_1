package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request,response);
    }
    /** 기존에 뷰패쓰로 각 컨트롤러가 따로 작동하던것이 이제는 MyView로 공통화 **/
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** render가 오면 model에 있는걸 request의 setAttribute로 다 넣어줘
         *  그 다음, JSP로 포워드**/
        System.out.println("MyView.render");
        System.out.println("model = " + model);
        System.out.println("viewPath = " + viewPath);
        System.out.println("render에서의 requestURI = " + request.getRequestURI());
        modelToRequestAttribute(model, request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request,response);
        System.out.println("포워딩");
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        /** 모델에 있는 데이터를 requestAttribute로 넣어준다! **/
        model.forEach((key, value)-> request.setAttribute(key,value));
    }
}
