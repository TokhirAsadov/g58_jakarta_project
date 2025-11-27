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
    <title>Register Page</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .register-container {
            width: 100%;
            max-width: 500px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            overflow: hidden;
        }

        .register-header {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .register-header h1 {
            font-size: 2rem;
            margin-bottom: 10px;
        }

        .register-header p {
            opacity: 0.9;
        }

        .register-form {
            padding: 30px;
        }

        .name-group {
            display: flex;
            gap: 15px;
        }

        .name-group .input-group {
            flex: 1;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #555;
        }

        .input-group input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 1rem;
            transition: border 0.3s ease;
        }

        .input-group input:focus {
            border-color: #f5576c;
            outline: none;
            box-shadow: 0 0 0 3px rgba(245, 87, 108, 0.1);
        }

        .submit-btn {
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1.1rem;
            font-weight: 600;
            cursor: pointer;
            transition: transform 0.3s ease;
            margin-top: 10px;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
        }

        .form-footer {
            text-align: center;
            margin-top: 25px;
            color: #777;
        }

        .form-footer a {
            color: #f5576c;
            text-decoration: none;
            font-weight: 500;
        }

        .form-footer a:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .register-container {
                border-radius: 10px;
            }

            .register-header {
                padding: 25px 20px;
            }

            .register-form {
                padding: 25px 20px;
            }

            .name-group {
                flex-direction: column;
                gap: 0;
            }
        }
    </style>
</head>
<body>
<div class="register-container">
    <div class="register-header">
        <h1>Yangi account yarating</h1>
        <p>Platformamizga qo'shiling va barcha imkoniyatlardan foydalaning</p>
    </div>

    <form class="register-form" id="registerForm" action="/register" method="post">
        <div class="name-group">
            <div class="input-group">
                <label for="firstname">Ismingiz</label>
                <input type="text" id="firstname" name="firstname" placeholder="Ismingiz" required>
            </div>

            <div class="input-group">
                <label for="lastname">Familiyangiz</label>
                <input type="text" id="lastname" name="lastname" placeholder="Familiyangiz" required>
            </div>
        </div>

        <div class="input-group">
            <label for="email">Email manzilingiz</label>
            <input type="email" name="email" id="email" placeholder="email@example.com" required>
        </div>

        <div class="input-group">
            <label for="password">Parol yarating</label>
            <input type="password" name="password" id="password" placeholder="Kamida 8 ta belgidan iborat" required minlength="8">
        </div>

        <div class="input-group">
            <label for="confirm-password">Parolni tasdiqlang</label>
            <input type="password" id="confirm-password" placeholder="Parolingizni qayta kiriting" required>
        </div>

        <button type="submit" class="submit-btn">Ro'yxatdan o'tish</button>

        <div class="form-footer">
            <p>Allaqachon accountingiz bormi? <a href="login.jsp">Kirish</a></p>
        </div>
    </form>
</div>

<script>
    /*document.getElementById('registerForm').addEventListener('submit', function(e) {
        e.preventDefault();

        const firstname = document.getElementById('firstname').value;
        const lastname = document.getElementById('lastname').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirm-password').value;

        // Parollarni solishtirish
        if(password !== confirmPassword) {
            alert('Parollar mos kelmadi! Iltimos, qayta tekshiring.');
            return;
        }

        // Barcha maydonlarni tekshirish
        if(firstname && lastname && email && password) {
            console.log(firstname)
            console.log(lastname)
            console.log(email)
            console.log(password)
            fetch('http://localhost:8080/register',
                {
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    method: "POST",
                    body: JSON.stringify({firstname,lastname, email,password})
                }
            )
                .then(response => response.json())
                .then(json => {
                    alert('Ro\'yxatdan o\'tish muvaffaqiyatli! Kirish sahifasiga o\'tilyapti...');
                    console.log(json)
                })
                .catch(err => {
                    console.log(err, "error--->")
                })
            // window.location.href = "login.jsp"; // Kirish sahifasiga o'tkazish
        } else {
            alert('Iltimos, barcha maydonlarni to\'ldiring!');
        }
    });*/
</script>
</body>
</html>
