package com.servlets;

import com.entity.Note;
import com.helper.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "NoteSaveServlet",urlPatterns = "/NoteSaveServlet")
public class NoteSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             try {
                 PrintWriter out= response.getWriter();

                String title=  request.getParameter("title");
                String content=  request.getParameter("content");

                 Note note= new Note(title, content, new Date());
//                 System.out.println(note.getNoteId()+":"+note.getTitle());

                Session s= MySessionFactory.getSessionFactory().openSession();
                 Transaction trns= s.beginTransaction();

                 s.save(note);

                 trns.commit();

                 HttpSession servletSession=   request.getSession();
                 servletSession.setAttribute("msg","Note Added");
                 response.sendRedirect("add_note.jsp");
                 return;

             }  catch (Exception e){
                 e.printStackTrace();
             }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
