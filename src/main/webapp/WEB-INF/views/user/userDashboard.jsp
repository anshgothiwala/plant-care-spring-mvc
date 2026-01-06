<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="container-fluid mt-4">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-3 mb-4">
            <div class="list-group shadow">
                <a href="<%=request.getContextPath()%>/user/userDashboard" class="list-group-item list-group-item-action active">
                    <i class="fa-solid fa-gauge"></i> Dashboard
                </a>
                <a href="<%=request.getContextPath()%>/user/services" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-seedling"></i> Services
                </a>
                <a href="<%=request.getContextPath()%>/subscription/subscriptionPlans" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-box"></i> Subscription Plans
                </a>
                <a href="<%=request.getContextPath()%>/user/services" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-calendar-check"></i> Book Appointment
                </a>
                <a href="<%=request.getContextPath()%>/appointments/myAppointments" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-calendar-days"></i> My Appointments
                </a>
                <a href="<%=request.getContextPath()%>/subscription/mySubscriptions" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-calendar-days"></i> My Subscriptions
                </a>
                <a href="<%=request.getContextPath()%>/user/feedback" class="list-group-item list-group-item-action">
                    <i class="fa-solid fa-comment-dots"></i> Feedback
                </a>
                <a href="<%=request.getContextPath()%>/auth/logout" class="list-group-item list-group-item-action text-danger">
                    <i class="fa-solid fa-right-from-bracket"></i> Logout
                </a>
            </div>
        </div>

        <!-- Main Content -->
        <div class="col-md-9">
            <div class="card shadow border-0 mb-4">
                <div class="card-body">
                    <h4 class="mb-3"><i class="fa-solid fa-leaf text-success"></i> Welcome, <%= session.getAttribute("userName") != null ? session.getAttribute("userName") : "User" %>!</h4>
                    <p class="text-muted">Here’s a quick overview of your PlantCare Portal activities.</p>
                </div>
            </div>

            <!-- Quick Stats -->
            <div class="row">
                <div class="col-md-4 mb-3">
                    <div class="card shadow-sm border-0 text-center p-3">
                        <i class="fa-solid fa-calendar-days fa-2x text-success mb-2"></i>
                        <h6>Upcoming Appointments</h6>
                        <p class="fw-bold text-success">2</p>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card shadow-sm border-0 text-center p-3">
                        <i class="fa-solid fa-box fa-2x text-primary mb-2"></i>
                        <h6>Active Subscription</h6>
                        <p class="fw-bold text-primary">Premium Plan</p>
                    </div>
                </div>
                <div class="col-md-4 mb-3">
                    <div class="card shadow-sm border-0 text-center p-3">
                        <i class="fa-solid fa-comment-dots fa-2x text-warning mb-2"></i>
                        <h6>Feedback Given</h6>
                        <p class="fw-bold text-warning">5</p>
                    </div>
                </div>
            </div>

            <!-- Quick Actions -->
            <div class="card shadow border-0 mt-3">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0"><i class="fa-solid fa-bolt"></i> Quick Actions</h5>
                </div>
                <div class="card-body d-flex flex-wrap gap-3">
                    <a href="<%=request.getContextPath()%>/user/services" class="btn btn-outline-success">
    					<i class="fa-solid fa-calendar-plus"></i> Book New Appointment
					</a>

                    <a href="<%=request.getContextPath()%>/user/services" class="btn btn-outline-primary">
                        <i class="fa-solid fa-seedling"></i> Explore Services
                    </a>
                    <a href="<%=request.getContextPath()%>/subscription/mySubscriptions" class="btn btn-outline-warning">
                        <i class="fa-solid fa-box"></i> Manage Subscription
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
