<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow border-0">
                <div class="card-header bg-success text-white text-center">
                    <h4><i class="fa-solid fa-comment-dots"></i> Submit Feedback</h4>
                </div>
                <div class="card-body p-4">
                    <form action="<%=request.getContextPath()%>/user/feedback/submit" method="post">

                        <!-- Hidden field for appointment/service ID -->
                        <input type="hidden" name="appointmentId" value="${appointmentId}" />

                        <!-- Feedback -->
                        <div class="mb-3">
                            <label for="feedback" class="form-label">Your Feedback</label>
                            <textarea class="form-control" id="feedback" name="feedback" rows="4"
                                      placeholder="Write your feedback here..." required></textarea>
                        </div>

                        <!-- Rating -->
                        <div class="mb-3">
                            <label for="rating" class="form-label">Rating</label>
                            <select class="form-select" id="rating" name="rating" required>
                                <option value="" selected disabled>Select Rating</option>
                                <option value="1">1 - Poor</option>
                                <option value="2">2 - Fair</option>
                                <option value="3">3 - Good</option>
                                <option value="4">4 - Very Good</option>
                                <option value="5">5 - Excellent</option>
                            </select>
                        </div>

                        <!-- Submit -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-success">
                                <i class="fa-solid fa-paper-plane"></i> Submit Feedback
                            </button>
                        </div>
                    </form>
                </div>

                <!-- Back link -->
                <div class="card-footer text-center">
                    <a href="<%=request.getContextPath()%>/user/userDashboard" class="btn btn-link">
                        ← Back to Dashboard
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
