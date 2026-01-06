<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow border-0 text-center">
                <div class="card-header bg-success text-white">
                    <h4><i class="fa-solid fa-check-circle"></i> Payment Successful</h4>
                </div>
                <div class="card-body p-4">
                    <p class="fs-5 mb-3">Your payment has been successfully processed.</p>

                    <!-- Amount -->
                    <div class="mb-3">
                        <strong>Amount Paid:</strong> ₹ ${amount}
                    </div>

                    <!-- Payment Method -->
                    <div class="mb-3">
                        <strong>Payment Method:</strong> ${paymentMethod}
                    </div>

                    <c:choose>
                        <c:when test="${type == 'APPOINTMENT'}">
                            <p>Your appointment has been booked successfully!</p>
                            <a href="<%=request.getContextPath()%>/appointments" class="btn btn-success mt-3">
                                View Appointments
                            </a>
                        </c:when>
                        <c:when test="${type == 'SUBSCRIPTION'}">
                            <p>Your subscription has been activated successfully!</p>
                            <a href="<%=request.getContextPath()%>/mySubscriptions" class="btn btn-success mt-3">
                                View My Subscriptions
                            </a>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
