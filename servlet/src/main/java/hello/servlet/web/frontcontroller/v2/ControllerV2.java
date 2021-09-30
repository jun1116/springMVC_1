package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    /** 기존엔 void로 리턴이 없었는데, 이젠 MyView를 리턴해야함 **/
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
