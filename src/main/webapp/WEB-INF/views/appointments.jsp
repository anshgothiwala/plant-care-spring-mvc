<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

<div class="container my-5">
    <h3 class="mb-4 text-center text-success">
        <i class="fa-solid fa-calendar-days"></i> My Appointments
    </h3>

    <c:if test="${empty appointments}">
        <div class="alert alert-info text-center">
            <i class="fa-solid fa-circle-info"></i> You haven’t booked any appointments yet.
        </div>
    </c:if>

    <c:if test="${not empty appointments}">
        <div class="table-responsive">
            <table class="table table-hover table-bordered align-middle">
                <thead class="table-success">
                    <tr>
                        <th>#</th>
                        <th>Service</th>
                        <th>Date</th>
                        <th>Time</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="appt" items="${appointments}" varStatus="i">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${appt.service.name}</td>
                        <!-- Extract date and time from LocalDateTime -->
                        <td>${appt.dateTime.toLocalDate()}</td>
                        <td>${appt.dateTime.toLocalTime()}</td>
                        <td>
                            
                                <form action="<%=request.getContextPath()%>/appointments/cancel" 
                                      method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="${appt.appointmentid}" />
                                    <button type="submit" class="btn btn-sm btn-outline-danger"
                                            onclick="return confirm('Cancel this appointment?');">
                                        <i class="fa-solid fa-xmark"></i> Cancel
                                    </button>
                                </form>
                            
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <!-- Back to Dashboard -->
    <div class="text-center mt-3">
        <a href="<%=request.getContextPath()%>/user/userDashboard" class="btn btn-outline-secondary">
            ← Back to Dashboard
        </a>
    </div>
</div>

<%@ include file="footer.jsp" %>
