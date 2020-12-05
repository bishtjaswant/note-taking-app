
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<%@include file="partials/navbaar.jsp" %>





<div class="container">

    <form class="mt-4" method="post" action="NoteSaveServlet">
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

        <h3 class="display-3">Add Note</h3>
        <div class="mb-3">
            <label for="Title" class="form-label">Title</label>
            <input type="text" name="title" class="form-control" id="Title" placeholder="Title...">
        </div>
        <div class="mb-3 ">
            <label class="form-label" for="content">Content</label>
            <textarea style="height: 100px;" name="content" placeholder="Write note's content......" class="form-control" id="content"></textarea>
        </div>
        <button type="submit" class="btn btn-outline-primary">Add note</button>
    </form>

</div>



<%@include file="includes/footer.jsp"%>
