<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow border-0">
                <div class="card-header bg-success text-white text-center">
                    <h4><i class="fa-solid fa-calendar-check"></i> Book Appointment</h4>
                </div>
                <div class="card-body p-4">
                    <form action="<%=request.getContextPath()%>/appointments/saveAppointment" method="post">
                        
                        <!-- Hidden Service ID -->
                        <input type="hidden" name="serviceId" value="${param.serviceId}" />

                        <!-- Service Name -->
                        <div class="mb-3">
                            <label class="form-label">Service</label>
                            <input type="text" class="form-control" value="${selectedService.name}" readonly />
                        </div>

                        <!-- Appointment Date -->
                        <div class="mb-3">
                            <label for="date" class="form-label">Choose Date</label>
                            <input type="date" id="date" name="date" class="form-control" required />
                        </div>

                        <!-- Appointment Time -->
                        <div class="mb-3">
                            <label for="time" class="form-label">Choose Time</label>
                            <input type="time" id="time" name="time" class="form-control" required />
                        </div>

                        <!-- Submit Button -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">
                                <i class="fa-solid fa-check"></i> Confirm Booking
                            </button>
                        </div>
                    </form>
                </div>

                <!-- Back link -->
                <div class="card-footer text-center">
                    <a href="<%=request.getContextPath()%>/services" class="btn btn-link">
                        ← Back to Services
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
