<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <!-- Title -->
    <div class="row">
        <div class="col-12 text-center mb-4">
            <h2 class="fw-bold text-success">
                <i class="fa-solid fa-calendar-check"></i> Manage Appointments
            </h2>
        </div>
    </div>

    <!-- Appointments Table -->
    <div class="card shadow border-0">
        <div class="card-body p-4">
            <div class="table-responsive">
                <table class="table table-bordered align-middle text-center">
                    <thead class="table-success">
                        <tr>
                            <th>Appointment ID</th>
                            <th>User</th>
                            <th>Service</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="appointment" items="${appointments}">
                            <tr>
                                <td>${appointment.appointmentid}</td>
								<td>${appointment.user.fullname}</td>
								<td>${appointment.service.name}</td>
								<td>${appointment.dateTime}</td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/admin/appointment/view/${appointment.appointmentid}" 
                                       class="btn btn-sm btn-outline-info">
                                        <i class="fa-solid fa-eye"></i> View
                                    </a>
                                    <a href="<%=request.getContextPath()%>/admin/appointment/edit/${appointment.appointmentid}" 
                                       class="btn btn-sm btn-outline-warning">
                                        <i class="fa-solid fa-pen"></i> Edit
                                    </a>
                                    <a href="<%=request.getContextPath()%>/admin/appointment/delete/${appointment.appointmentid}" 
                                       class="btn btn-sm btn-outline-danger" 
                                       onclick="return confirm('Are you sure you want to delete this appointment?');">
                                        <i class="fa-solid fa-trash"></i> Delete
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
