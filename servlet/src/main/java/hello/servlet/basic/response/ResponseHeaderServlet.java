package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        //status-line
        response.setStatus(HttpServletResponse.SC_OK);

        //response headers
//        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//캐시 무효화
        response.setHeader("Pragma", "no-cache");
        //custom header
        response.setHeader("my-header", "hello");

//        content(response);
//        cookie(response);
        redirect(response);
        PrintWriter writer = response.getWriter();
        writer.println("OK GOOD");



    }
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600; //600초동안 유효하다
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); //이렇게 세팅해줘도 됨
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie); //-> 여기에 넣어주면 됨
    }
    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); //생략시 자동 생성됨
    }

}
