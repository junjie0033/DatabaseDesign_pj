package Servlet;

import DaoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);

        long count = userDao.getCountWithName(username);
        if(count == 1){
            String Password = userDao.getPasswordFromUsername(username);

            if(Password.equals(password)){
                Cookie cookie = new Cookie("USERID",username);
                response.addCookie(cookie);
                response.sendRedirect("Welcome");
            }else {
                request.setAttribute("loginError","用户名或密码错误");
                request.getRequestDispatcher("Welcome").forward(request,response);
            }

        }else{
            request.setAttribute("loginError","用户名或密码错误");
            request.getRequestDispatcher("Welcome").forward(request,response);
        }
//        request.getRequestDispatcher("Welcome").forward(request,response);

    }

}
