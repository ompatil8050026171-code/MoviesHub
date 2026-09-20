<%@ page import="com.Movie.utility.Model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Profile - MoviesHub</title>

    <link rel="stylesheet" href="CSS/Profile.css">

</head>


<body>

    <!-- ================= NAVBAR ================= -->

    <div class="navbar">

        <div class="logo">
            MoviesHub
        </div>


        <div class="nav-links">

            <a href="home.jsp">
                Home
            </a>

            <a href="bookingHistory.jsp">
                Booking History
            </a>

            <a href="Profile.jsp">
                Profile
            </a>

            <a href="logout">
                Logout
            </a>

        </div>

    </div>


    <!-- ================= PROFILE ================= -->

    <div class="profile-container">

        <div class="profile-title">
            My Profile
        </div>


        <!-- ================= NAME ================= -->

        <div class="profile-row">

            <div class="profile-label">
                Name
            </div>


            <div class="profile-content">

                <div
                    class="profile-value"
                    id="nameValue">

                    <%= user.getName() %>

                </div>


                <div
                    class="button-container"
                    id="nameButtons">

                    <button
                        class="edit-btn"
                        onclick="editName()">

                        Edit

                    </button>

                </div>

            </div>

        </div>


        <!-- ================= EMAIL ================= -->

        <div class="profile-row">

            <div class="profile-label">
                Email
            </div>


            <div class="profile-content">

                <div
                    class="profile-value"
                    id="emailValue">

                    <%= user.getEmail() %>

                </div>


                <div
                    class="button-container"
                    id="emailButtons">

                    <button
                        class="edit-btn"
                        onclick="editEmail()">

                        Edit

                    </button>

                </div>

            </div>

        </div>


        <!-- ================= PHONE ================= -->

        <div class="profile-row">

            <div class="profile-label">
                Phone
            </div>


            <div class="profile-content">

                <div
                    class="profile-value"
                    id="phoneValue">

                    <%= user.getPhone() %>

                </div>


                <div
                    class="button-container"
                    id="phoneButtons">

                    <button
                        class="edit-btn"
                        onclick="editPhone()">

                        Edit

                    </button>

                </div>

            </div>

        </div>


        <!-- ================= ROLE ================= -->

        <div class="profile-row">

            <div class="profile-label">
                Role
            </div>


            <div class="profile-content">

                <div class="role-text">

                    <%= user.getRole() %>

                </div>


                <div>

                    <span class="not-editable">
                        Not editable
                    </span>

                </div>

            </div>

        </div>

    </div>


    <!-- ================= JAVASCRIPT ================= -->

    <script>

        let userId = <%= user.getUser_id() %>;

    </script>

    <script src="Scripts/Profile.js"></script>

</body>

</html>