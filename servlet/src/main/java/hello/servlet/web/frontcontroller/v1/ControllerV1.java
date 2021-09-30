package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ;
}
/** 왜 인터페이스로 만드는가?
 * 이걸 갖고, 회원폼,저장,보여주는 컨트롤러를 다 구현할거야 **/
