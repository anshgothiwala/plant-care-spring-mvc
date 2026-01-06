<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <h2 class="fw-bold text-success mb-4">
        <i class="fa-solid fa-layer-group"></i> Manage Subscription Plans
    </h2>

    <!-- Add Plan Form -->
    <div class="card shadow-sm mb-4">
        <div class="card-header bg-success text-white">
            <h5><i class="fa-solid fa-plus-circle"></i> Add New Plan</h5>
        </div>
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/admin/plans/add" method="post">
                <div class="row g-3">
                    <div class="col-md-4">
                        <label class="form-label">Plan Name</label>
                        <input type="text" class="form-control" name="name" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Price (₹)</label>
                        <input type="number" class="form-control" name="price" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Duration (Months)</label>
                        <input type="number" class="form-control" name="durationInDays" required>
                    </div>
                </div>
                <div class="mt-3">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="description" rows="2"></textarea>
                </div>
                <div class="mt-3">
                    <button class="btn btn-success">
                        <i class="fa-solid fa-plus"></i> Add Plan
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- Existing Plans -->
    <h4 class="mb-3">Existing Plans</h4>
    <table class="table table-striped shadow-sm">
        <thead class="table-success">
            <tr>
                <th>Plan</th>
                <th>Price</th>
                <th>Duration</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="plan" items="${plans}">
            <tr>
                <td>${plan.name}</td>
                <td>₹${plan.price}</td>
                <td>${plan.durationInDays} months</td>
                <td>${plan.description}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/admin/plans/edit/${plan.planid}" 
                       class="btn btn-sm btn-primary">
                        <i class="fa-solid fa-pen"></i>
                    </a>
                    <a href="<%=request.getContextPath()%>/admin/plans/delete/${plan.planid}" 
                       class="btn btn-sm btn-danger">
                        <i class="fa-solid fa-trash"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Back Link -->
    <div class="text-center mt-3">
        <a href="<%=request.getContextPath()%>/admin/adminDashboard" class="btn btn-link">
            ← Back to Dashboard
        </a>
    </div>
</div>

<%@ include file="../footer.jsp" %>
