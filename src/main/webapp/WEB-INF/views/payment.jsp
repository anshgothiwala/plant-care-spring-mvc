<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow border-0">
                <div class="card-header bg-success text-white text-center">
                    <h4><i class="fa-solid fa-credit-card"></i> Payment</h4>
                </div>
                <div class="card-body p-4">
                    <form action="<%=request.getContextPath()%>/payment/process" method="post">

                        <!-- Hidden fields for backend -->
                        <input type="hidden" name="type" value="${type}" />
                        <input type="hidden" name="id" value="${id}" />
                        <input type="hidden" name="amount" value="${amount}" />

                        <!-- Amount -->
                        <div class="mb-3">
                            <label class="form-label">Amount (₹)</label>
                            <input type="text" class="form-control" value="${amount}" readonly />
                        </div>

                        <!-- Payment Method -->
                        <div class="mb-3">
                            <label for="paymentMethod" class="form-label">Payment Method</label>
                            <select class="form-select" id="paymentMethod" name="paymentMethod" required>
                                <option value="" selected disabled>Select Payment Method</option>
                                <option value="CARD">Credit / Debit Card</option>
                                <option value="UPI">UPI</option>
                                <option value="WALLET">Wallet</option>
                                <option value="CASH">Cash on Service</option>
                            </select>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">
                                <i class="fa-solid fa-check"></i> Pay Now
                            </button>
                        </div>
                    </form>
                </div>

                <!-- Back link -->
                <div class="card-footer text-center">
                    <a href="<%=request.getContextPath()%>/${type == 'APPOINTMENT' ? 'appointments' : 'subscriptionPlans'}" 
                       class="btn btn-link">← Back</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
