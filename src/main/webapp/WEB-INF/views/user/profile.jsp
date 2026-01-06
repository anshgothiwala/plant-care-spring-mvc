<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ include file="/WEB-INF/views/header.jsp" %> --%>
<%@ include file="../header.jsp" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow border-0">
                <div class="card-header bg-primary text-white text-center">
                    <h4><i class="fa-solid fa-user"></i> My Profile</h4>
                </div>
                <div class="card-body p-4">
                    <form action="<%=request.getContextPath()%>/user/updateProfile" method="post">
                        <!-- Full Name -->
                        <div class="mb-3">
                            <label for="fullName" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="fullName" name="fullName"
                                   value="${user.fullName}" required>
                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   value="${user.email}" readonly>
                        </div>

                        <!-- Phone -->
                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone"
                                   value="${user.phone}" required>
                        </div>

                        <!-- Address -->
                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            <textarea class="form-control" id="address" name="address" rows="2" required>${user.address}</textarea>
                        </div>

                        <!-- Update Button -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                <i class="fa-solid fa-save"></i> Update Profile
                            </button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-center">
                    <a href="<%=request.getContextPath()%>/userDashboard" class="btn btn-link">← Back to Dashboard</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
<%-- <%@ include file="/WEB-INF/views/footer.jsp" %> --%>
