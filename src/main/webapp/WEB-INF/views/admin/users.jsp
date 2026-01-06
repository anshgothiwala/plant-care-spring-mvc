<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <!-- Title -->
    <div class="row">
        <div class="col-12 text-center mb-4">
            <h2 class="fw-bold text-primary">
                <i class="fa-solid fa-users"></i> Manage Users
            </h2>
        </div>
    </div>

    <!-- Users Table -->
    <div class="card shadow border-0">
        <div class="card-body p-4">
            <div class="table-responsive">
                <table class="table table-bordered align-middle text-center">
                    <thead class="table-primary">
                        <tr>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Role</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.fullname}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td>${user.role}</td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/admin/user/view/${user.id}" 
                                       class="btn btn-sm btn-outline-info">
                                        <i class="fa-solid fa-eye"></i> View
                                    </a>
                                    <a href="<%=request.getContextPath()%>/admin/user/edit/${user.id}" 
                                       class="btn btn-sm btn-outline-warning">
                                        <i class="fa-solid fa-pen"></i> Edit
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Back Link -->
    <div class="text-center mt-3">
        <a href="<%=request.getContextPath()%>/admin/adminDashboard" class="btn btn-link">
            ← Back to Dashboard
        </a>
    </div>
</div>

<%@ include file="../footer.jsp" %>
