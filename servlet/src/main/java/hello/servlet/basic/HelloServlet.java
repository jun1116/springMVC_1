package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //서비스 메소드가 호출
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, response);
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + response);
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
