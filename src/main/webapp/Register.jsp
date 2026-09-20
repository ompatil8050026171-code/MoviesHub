<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MoviesHub - Register</title>

    <link rel="stylesheet" href="CSS/Register.css">
</head>

<body>

    <div class="register-container">

        <h1>MoviesHub</h1>

        <h2>Create Account</h2>

        <form id="registerForm">

            <input type="text"
                   id="name"
                   placeholder="Enter Name"
                   required>

            <input type="email"
                   id="email"
                   placeholder="Enter Email"
                   required>

            <input type="password"
                   id="password"
                   placeholder="Enter Password"
                   required>

            <input type="number"
                   id="phone"
                   placeholder="Enter Phone Number"
                   required>

            <select id="role" required>

                <option value="">Select Role</option>

                <option value="Customer">
                    Customer
                </option>

                <option value="Admin">
                    Admin
                </option>

                <option value="Theatre Admin">
                    Theatre Admin
                </option>

            </select>

            <button type="submit">
                Register
            </button>

        </form>

        <p id="message"></p>

        <div class="login-link">
            Already have an account?
            <a href="login.jsp">Login</a>
        </div>

    </div>

    <script src="Scripts/Register.js"></script>

</body>
</html>