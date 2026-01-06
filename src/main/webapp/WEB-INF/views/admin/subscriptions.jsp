<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <h2 class="fw-bold text-success mb-4">
        <i class="fa-solid fa-clipboard-list"></i> User Subscriptions
    </h2>

    <table class="table table-hover shadow-sm">
        <thead class="table-success">
            <tr>
                <th>User</th>
                <th>Plan</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="sub" items="${subscriptions}">
            <tr>
                <td>${sub.user.fullname}</td>
                <td>${sub.plan.name}</td>
                <td>${sub.startDate}</td>
                <td>${sub.endDate}</td>
                <td>
    					<c:choose>
							<c:when test="${sub.endDate >= now}">
								<span class="badge bg-success">Active</span>
							</c:when>
							<c:otherwise>
								<span class="badge bg-danger">Expired</span>
							</c:otherwise>
						</c:choose>
					</td>

                <td>
                    <a href="<%=request.getContextPath()%>/admin/subscriptions/delete/${sub.subscriptionid}" 
                       class="btn btn-sm btn-danger">
                        <i class="fa-solid fa-trash"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Back Link -->
    <div class="text-center mt-3">
        <a href="<%=request.getContextPath()%>/admin/adminDashboard" class="btn btn-link">
            ← Back to Dashboard
        </a>
    </div>
</div>

<%@ include file="../footer.jsp" %>
