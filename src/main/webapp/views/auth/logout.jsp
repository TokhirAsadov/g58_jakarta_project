<%--
  Created by IntelliJ IDEA.
  User: guval
  Date: 11/27/2025
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">


    <!-- Custom CSS -->
    <style>
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .logout-container {
            max-width: 500px;
            width: 100%;
            margin: 20px;
        }

        .logout-card {
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            border: none;
            overflow: hidden;
            transition: transform 0.3s;
        }

        .logout-card:hover {
            transform: translateY(-5px);
        }

        .card-header {
            background: linear-gradient(135deg, #ff6b6b 0%, #ee5a52 100%);
            color: white;
            border-bottom: none;
            padding: 25px;
        }

        .user-info {
            background-color: #f8f9fa;
            border-radius: 10px;
            padding: 15px;
            margin: 20px 0;
        }

        .btn-custom {
            padding: 12px 25px;
            border-radius: 8px;
            font-weight: 600;
            transition: all 0.3s;
        }

        .btn-confirm {
            background: linear-gradient(135deg, #ff6b6b 0%, #ee5a52 100%);
            border: none;
            color: white;
        }

        .btn-confirm:hover {
            background: linear-gradient(135deg, #ff5252 0%, #d32f2f 100%);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 107, 107, 0.4);
        }

        .btn-cancel {
            background: #6c757d;
            border: none;
            color: white;
        }

        .btn-cancel:hover {
            background: #5a6268;
            transform: translateY(-2px);
        }

        .logout-icon {
            font-size: 4rem;
            color: #ff6b6b;
            margin-bottom: 20px;
        }

        .warning-note {
            background-color: #fff3cd;
            border-left: 4px solid #ffc107;
            padding: 15px;
            margin: 20px 0;
            border-radius: 5px;
        }

        .feature-list {
            list-style: none;
            padding-left: 0;
        }

        .feature-list li {
            padding: 5px 0;
        }

        .feature-list li i {
            color: #28a745;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="logout-container">
    <div class="card logout-card">
        <div class="card-header text-center">
            <div class="logout-icon">
                <i class="fas fa-sign-out-alt"></i>
            </div>
            <h3 class="mb-0">Tizimdan Chiqishni Tasdiqlash</h3>
        </div>

        <div class="card-body p-4">


            <!-- Tugmalar -->
            <div class="row mt-4">
                <div class="col-md-6 mb-2">
                    <form action="/auth/logout" method="post" id="logoutForm">
                        <button type="submit" class="btn btn-confirm btn-custom w-100">
                            <i class="fas fa-check-circle me-2"></i>
                            Ha, Tizimdan Chiqish
                        </button>
                    </form>
                </div>

                <div class="col-md-6 mb-2">
                    <a href="/book/list" class="btn btn-cancel btn-custom w-100">
                        <i class="fas fa-times-circle me-2"></i>
                        Back to home
                    </a>
                </div>
            </div>

        </div>

    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
