<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <h2 class="fw-bold text-success text-center mb-4">
        <i class="fa-solid fa-seedling"></i> Our Plant Care Services
    </h2>

    <div class="row g-4">
        <c:forEach var="service" items="${services}">
            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <img src="<%=request.getContextPath()%>/assets/images/service-icons.png" 
                         class="card-img-top" alt="Service Image">

                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title text-success fw-bold">${service.name}</h5>
                        <p class="card-text small">${service.description}</p>
                        <p class="fw-bold">₹${service.price}</p>
                        <div class="mt-auto d-grid">
                            <a href="<%=request.getContextPath()%>/appointments/bookAppointment?serviceId=${service.serviceid}" class="btn btn-sm btn-success">
    							<i class="fa-solid fa-calendar-check"></i> Book Now
							</a>

                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>
