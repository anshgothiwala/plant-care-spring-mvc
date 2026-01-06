<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Plant Care</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<!-- 🌱 Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success shadow">
    <div class="container">
        <a class="navbar-brand fw-bold" href="index.jsp">
            <i class="fa-solid fa-leaf"></i> PlantCare Portal
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/auth/login">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/auth/register">Register</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- 🌱 Hero Section -->
<section class="text-center text-light bg-dark p-5">
    <div class="container">
        <h1 class="display-4 fw-bold">Your Plants, Our Care</h1>
        <p class="lead">Book plant care services, manage subscriptions, and keep your garden healthy!</p>
        <a href="<%=request.getContextPath()%>/user/services" class="btn btn-success btn-lg mt-3">
            Explore Services <i class="fa-solid fa-arrow-right"></i>
        </a>
    </div>
</section>

<!-- 🌱 Features -->
<section class="container text-center my-5">
    <div class="row g-4">
        <div class="col-md-4">
            <div class="card shadow p-4 border-0">
                <i class="fa-solid fa-calendar-check fa-3x text-success mb-3"></i>
                <h5 class="fw-bold">Book Appointments</h5>
                <p>Schedule plant care visits easily with our experts.</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card shadow p-4 border-0">
                <i class="fa-solid fa-box-open fa-3x text-success mb-3"></i>
                <h5 class="fw-bold">Subscriptions</h5>
                <p>Choose flexible plans to keep your plants thriving all year round.</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card shadow p-4 border-0">
                <i class="fa-solid fa-seedling fa-3x text-success mb-3"></i>
                <h5 class="fw-bold">Expert Services</h5>
                <p>Professional plant care, pest control, and garden setup services.</p>
            </div>
        </div>
    </div>
</section>

<!-- 🌱 Footer -->
<footer class="bg-success text-white text-center p-3 mt-5">
    <p class="mb-0">&copy; 2025 PlantCare Portal | Designed with <i class="fa-solid fa-heart"></i></p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/script.js"></script>
</body>
</html>

