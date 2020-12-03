package Servlet;

import DaoImpl.UserDaoImpl;
import doamin.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    UserDaoImpl userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        long id = userDao.getAllCount() + 1;

        long count = userDao.getCountWithName(username);

        if(count > 0){
            request.setAttribute("message","The name of "+ username+ "has been used");
            request.getRequestDispatcher("Welcome").forward(request,response);
        }else{
            User user = new User(id,username,email,password);
            userDao.save(user);
            Cookie cookie = new Cookie("USERID",username);
            System.out.println("success");
            response.addCookie(cookie);
            response.sendRedirect("Welcome");
        }
        return;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
