<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <h2 class="fw-bold text-success text-center mb-4">
        <i class="fa-solid fa-leaf"></i> Subscription Plans
    </h2>

    <div class="row g-4">
        <c:forEach var="plan" items="${plans}">
            <div class="col-md-4">
                <div class="card shadow border-0 h-100">
                    <div class="card-header bg-success text-white text-center">
                        <h5 class="mb-0">${plan.name}</h5>
                    </div>
                    <div class="card-body d-flex flex-column">
                        <h3 class="text-success text-center">₹${plan.price}</h3>
                        <p class="text-center">${plan.durationInDays} months</p>
                        <p class="small">${plan.description}</p>
                        <div class="mt-auto d-grid">
                            <form action="<%=request.getContextPath()%>/subscription/subscribe" method="post">
                                <input type="hidden" name="planId" value="${plan.planid}">
                                <button type="submit" class="btn btn-success">
                                    <i class="fa-solid fa-cart-plus"></i> Subscribe
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
