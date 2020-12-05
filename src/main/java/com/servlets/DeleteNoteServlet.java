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

@WebServlet(name = "DeleteNoteServlet", urlPatterns = "/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
          int del_id =   Integer.parseInt(request.getParameter("del_id"));

          Session session = MySessionFactory.getSessionFactory().openSession();

           Transaction trans= session.beginTransaction();;
           Note note =  (Note) session.get(Note.class,del_id);
           session.delete(note);
           trans.commit();
           HttpSession httpSession= request.getSession();;
           httpSession.setAttribute("msg","note deleted".toUpperCase() );
           response.sendRedirect("show_notes.jsp");

       }catch (Exception e ){
           e.printStackTrace();
       }
    }
}
