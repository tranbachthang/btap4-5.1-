package murach.business.email;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Map servlet trực tiếp bằng annotation
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    // Xử lý GET: hiển thị "TestServlet Get"
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("TestServlet Get");
        }
    }

    // Xử lý POST: hiển thị "TestServlet Post"
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain; charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("TestServlet Post");
        }
    }
}
