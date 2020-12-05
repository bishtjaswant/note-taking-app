<%@ page import="com.helper.MySessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Note" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@include file="includes/header.jsp"%>

<%@include file="partials/navbaar.jsp" %>


<div class="container">

       <h1 class="text-center">All notes</h1>
        <%

            if (request.getSession().getAttribute("msg") !=null){

        %>
        <div class="alert alert-danger" role="alert">
            <%= request.getSession().getAttribute("msg").toString() %>
        </div>
        <%
            }
            request.getSession().removeAttribute("msg");
        %>

    <div class="row">
        <div class="col-md-12">


                <%
                    Session s= MySessionFactory.getSessionFactory().openSession();
                    Query q=  s.createQuery("from Note ");
                    List<Note> notes=q.list();


                    if (notes.size()>0){
                    for (Note n: notes  ) {
                                  %>

            <div class="card mt-1 mb-1" >
<%--                <img src="..." class="card-img-top" alt="...">--%>
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <h5 class="card-title"> <%= n.getTitle() %> </h5>
                        <span>  <%= n.getNoteAdded().toLocaleString() %> </span>

                    </div>


                    <p class="card-text"> <%= n.getContent() %> </p>
                    <a href="DeleteNoteServlet?del_id=<%= n.getNoteId()  %>" class="btn btn-outline-danger">delete</a>
                </div>
            </div>
        <%
                    }
            }else {
                        %>
                 <div class="alert alert-info">
                     THERE ARE NO NOTES TO SHOW
                 </div>
            <%
                    }
                    s.close();
                %>

        </div>
    </div>

</div>



<%@include file="includes/footer.jsp"%>
