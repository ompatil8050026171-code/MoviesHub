<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>MoviesHub - Login</title>

    <link rel="stylesheet" href="CSS/login.css">

</head>

<body>

    <div class="login-container">

        <h1>
            MoviesHub
        </h1>

        <h2>
            Login
        </h2>


        <form id="loginForm">

            <input
                type="email"
                id="email"
                placeholder="Enter Email"
                required
            >


            <input
                type="password"
                id="password"
                placeholder="Enter Password"
                required
            >


            <button type="submit">
                Login
            </button>

        </form>


        <p id="message">
        </p>


        <div class="register-link">

            Don't have an account?

            <a href="Register.jsp">
                Register
            </a>

        </div>

    </div>


    <script src="Scripts/login.js"></script>

</body>

</html>