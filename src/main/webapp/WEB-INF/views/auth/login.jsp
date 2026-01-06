<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<!-- Full height flexbox container -->
<div class="d-flex align-items-center justify-content-center" style="min-height: 80vh;">
    <div class="col-md-6 col-lg-4">
        <div class="card shadow border-0">
            <div class="card-header bg-success text-white text-center">
                <h4><i class="fa-solid fa-right-to-bracket"></i> Login</h4>
            </div>
            <div class="card-body p-4">
                <form action="<%=request.getContextPath()%>/auth/login" method="post">

                    <!-- Email -->
                    <div class="mb-3">
                        <label for="email" class="form-label">Email Address</label>
                        <input type="email" class="form-control" id="email" name="email"
                               placeholder="Enter your email" required>
                    </div>

                    <!-- Password -->
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Enter your password" required>
                    </div>

                    <!-- Remember + Forgot -->
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <div>
                            <input type="checkbox" id="rememberMe" name="rememberMe">
                            <label for="rememberMe">Remember me</label>
                        </div>
                        <a href="<%=request.getContextPath()%>/forgotPassword" class="text-success">Forgot Password?</a>
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid">
                        <button type="submit" class="btn btn-success">
                            <i class="fa-solid fa-right-to-bracket"></i> Login
                        </button>
                    </div>
                </form>
            </div>

            <!-- Register link -->
            <div class="card-footer text-center">
                <p class="mb-0">Don't have an account?
                    <a href="<%=request.getContextPath()%>/register" class="text-success fw-bold">Register here</a>
                </p>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
