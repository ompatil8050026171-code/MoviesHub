// ==============================
// LOGIN FORM
// ==============================

document
    .getElementById("loginForm")
    .addEventListener(
        "submit",
        function(event) {

            event.preventDefault();


            // ==============================
            // GET FORM VALUES
            // ==============================

            let email =
                document.getElementById("email").value;


            let password =
                document.getElementById("password").value;


            // ==============================
            // CREATE REQUEST PARAMETERS
            // ==============================

            let params =
                new URLSearchParams();


            params.append(
                "email",
                email
            );


            params.append(
                "password",
                password
            );


            // ==============================
            // SEND LOGIN REQUEST
            // ==============================

            fetch("/login", {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/x-www-form-urlencoded"

                },

                body: params

            })


            .then(response => {

                return response.text();

            })


            .then(result => {

                console.log(result);


                document.getElementById(
                    "message"
                ).innerText = result;


                // ==============================
                // LOGIN SUCCESS
                // ==============================

                if (result === "Login successful") {

                    window.location.href =
                        "index.jsp";

                }

            })


            .catch(error => {

                console.error(error);


                document.getElementById(
                    "message"
                ).innerText =
                    "Something went wrong";

            });

        }
    );