<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <div class="row">
        <!-- Dashboard Title -->
        <div class="col-12 text-center mb-4">
            <h2 class="fw-bold text-success">
                <i class="fa-solid fa-seedling"></i> Admin Dashboard
            </h2>
            <p class="text-muted">Manage users, services, appointments, feedback, and subscriptions</p>
        </div>
    </div>

    <!-- Stats Cards -->
    <div class="row g-4">
        <!-- Users -->
        <div class="col-md-3">
            <div class="card shadow border-0 text-center">
                <div class="card-body">
                    <i class="fa-solid fa-users fa-2x text-primary mb-2"></i>
                    <h5 class="card-title">Users</h5>
                    <h3 class="fw-bold">${totalUsers}</h3>
                    <a href="<%=request.getContextPath()%>/admin/users" class="btn btn-sm btn-outline-primary mt-2">Manage</a>
                </div>
            </div>
        </div>

        <!-- Services -->
        <div class="col-md-3">
            <div class="card shadow border-0 text-center">
                <div class="card-body">
                    <i class="fa-solid fa-leaf fa-2x text-success mb-2"></i>
                    <h5 class="card-title">Services</h5>
                    <h3 class="fw-bold">${totalServices}</h3>
                    <a href="<%=request.getContextPath()%>/service/list" class="btn btn-sm btn-outline-success mt-2">Manage</a>
                </div>
            </div>
        </div>

        <!-- Appointments -->
        <div class="col-md-3">
            <div class="card shadow border-0 text-center">
                <div class="card-body">
                    <i class="fa-solid fa-calendar-check fa-2x text-warning mb-2"></i>
                    <h5 class="card-title">Appointments</h5>
                    <h3 class="fw-bold">${totalAppointments}</h3>
                    <a href="<%=request.getContextPath()%>/admin/appointments" class="btn btn-sm btn-outline-warning mt-2">Manage</a>
                </div>
            </div>
        </div>

        <!-- Subscriptions -->
        <div class="col-md-3">
            <div class="card shadow border-0 text-center">
                <div class="card-body">
                    <i class="fa-solid fa-box-open fa-2x text-danger mb-2"></i>
                    <h5 class="card-title">Subscriptions</h5>
                    <h3 class="fw-bold">${totalSubscriptions}</h3>
                    <a href="<%=request.getContextPath()%>/admin/subscriptions" class="btn btn-sm btn-outline-danger mt-2">Manage</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Quick Links -->
    <div class="row mt-5">
        <div class="col-12 text-center">
            <h4 class="fw-bold mb-3">Quick Actions</h4>
            <a href="<%=request.getContextPath()%>/admin/addService" class="btn btn-success m-2">
                <i class="fa-solid fa-plus"></i> Add Service
            </a>
            <a href="<%=request.getContextPath()%>/admin/managePlans" class="btn btn-primary m-2">
                <i class="fa-solid fa-list"></i> Manage Subscription Plans
            </a>
            <a href="<%=request.getContextPath()%>/admin/viewFeedback" class="btn btn-warning m-2">
                <i class="fa-solid fa-comments"></i> View Feedback
            </a>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
