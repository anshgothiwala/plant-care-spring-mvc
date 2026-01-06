<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-lg-10">
            <div class="card shadow border-0">
                <div class="card-header bg-success text-white text-center">
                    <h4><i class="fa-solid fa-leaf"></i> My Subscriptions</h4>
                </div>
                <div class="card-body p-4">

                    <!-- If user has no subscriptions -->
                    <c:if test="${empty subscriptions}">
                        <div class="alert alert-info text-center">
                            <i class="fa-solid fa-circle-info"></i> You don’t have any active subscriptions yet.  
                            <a href="<%=request.getContextPath()%>/subscription/plans" class="fw-bold text-success">Browse Plans</a>
                        </div>
                    </c:if>

                    <!-- Subscriptions Table -->
                    <c:if test="${not empty subscriptions}">
                        <div class="table-responsive">
                            <table class="table table-bordered align-middle text-center">
                                <thead class="table-success">
                                    <tr>
                                        <th>Plan Name</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Status</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="sub" items="${subscriptions}">
                                        <tr>
                                            <td>${sub.plan.name}</td>
                                            <td>${sub.startDate}</td>
                                            <td>${sub.endDate}</td>
                                            <td>
											    <c:choose>
											        <c:when test="${sub.status eq 'ACTIVE'}">
											            <span class="badge bg-success">Active</span>
											        </c:when>
											        <c:otherwise>
											            <span class="badge bg-secondary">${sub.status}</span>
											        </c:otherwise>
											    </c:choose>
											</td>

                                            <td>
                                                <c:if test="${sub.status ne 'ACTIVE'}">

                                                    <a href="<%=request.getContextPath()%>/subscription/renew/${sub.subscriptionid}" class="btn btn-sm btn-outline-success">
                                                        <i class="fa-solid fa-rotate-right"></i> Renew
                                                    </a>
                                                </c:if>
                                                <a href="<%=request.getContextPath()%>/subscription/renew/${sub.subscriptionid}" class="btn btn-sm btn-outline-primary">
                                                    <i class="fa-solid fa-eye"></i> View
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
                <div class="card-footer text-center">
                    <a href="<%=request.getContextPath()%>/user/userDashboard" class="btn btn-link">← Back to Dashboard</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>