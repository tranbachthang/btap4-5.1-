package murach.business.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;   // <-- THÊM DÒNG NÀY

import murach.business.User;

@WebServlet("/emailList")                      // <-- ÁNH XẠ BẰNG ANNOTATION
public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        // NÊN dùng index.jsp (vì bạn đang xài JSP)
        String url = "/index.jsp";            // <-- đổi từ /index.html -> /index.jsp

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        if (action.equals("join")) {
            url = "/index.jsp";               // <-- giữ đồng nhất với file thật bạn có
        }
        else if (action.equals("add")) {                
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User(firstName, lastName, email);

            request.setAttribute("user", user);

            // nếu thanks.jsp nằm trực tiếp dưới /web:
            url = "/thanks.jsp";
            // nếu bạn để ở /web/WEB-INF/views/thanks.jsp thì dùng:
            // url = "/WEB-INF/views/thanks.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
