package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//캐시 무효화
        response.setHeader("Pragma", "no-cache");
        //custom header
        response.setHeader("my-header", "hello");

        PrintWriter writer = response.getWriter();
        writer.write("OK GOOD");


    }
}
