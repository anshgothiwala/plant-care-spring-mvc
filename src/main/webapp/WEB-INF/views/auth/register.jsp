<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<!-- Full height flexbox container -->
<div class="d-flex align-items-center justify-content-center mt-4" style="min-height: 90vh;">
    <div class="col-md-8 col-lg-6">
        <div class="card shadow border-0">
            <div class="card-header bg-success text-white text-center">
                <h4><i class="fa-solid fa-user-plus"></i> Create Account</h4>
            </div>
            <div class="card-body p-4">
                <form action="<%=request.getContextPath()%>/auth/register" method="post">

                    <!-- Full Name -->
                    <div class="mb-3">
                        <label for="fullname" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="fullname" name="fullname"
                               placeholder="Enter your name" required>
                    </div>

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
                               placeholder="Enter a password" required>
                    </div>

                    <!-- Confirm Password -->
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                               placeholder="Re-enter your password" required>
                    </div>

                    <!-- Phone -->
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="phone" name="phone"
                               placeholder="Enter your phone number" required>
                    </div>

                    <!-- Address -->
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <textarea class="form-control" id="address" name="address"
                                  placeholder="Enter your address" rows="2" required></textarea>
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid">
                        <button type="submit" class="btn btn-success">
                            <i class="fa-solid fa-user-plus"></i> Register
                        </button>
                    </div>
                </form>
            </div>

            <!-- Login link -->
            <div class="card-footer text-center">
                <p class="mb-0">Already have an account?
                    <a href="<%=request.getContextPath()%>/login" class="text-success fw-bold">Login here</a>
                </p>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
