<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <h3 class="mb-4"><i class="fa-solid fa-comments"></i> User Feedback</h3>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-success">
                <tr>
                    <th>#</th>
                    <th>User</th>
                    <th>Feedback</th>
                    <th>Rating</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="fb" items="${feedbackList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${fb.user.fullname}</td>
                        <td>${fb.comment}</td>
                        <td>${fb.rating}</td>
                        <td>${fb.date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
    <!-- Back Link -->
    <div class="text-center mt-3">
        <a href="<%=request.getContextPath()%>/admin/adminDashboard" class="btn btn-link">
            ← Back to Dashboard
        </a>
    </div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
