document.getElementById("registerForm")
    .addEventListener("submit", function(event) {

        event.preventDefault();

        let name =
            document.getElementById("name").value;

        let email =
            document.getElementById("email").value;

        let password =
            document.getElementById("password").value;

        let phone =
            document.getElementById("phone").value;

        let role =
            document.getElementById("role").value;


        let user = {

            name: name,

            email: email,

            password: password,

            phone: Number(phone),

            role: role

        };


        fetch("/addUser", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(user)

        })

        .then(response => {

            if (!response.ok) {
                throw new Error("Registration failed");
            }

            return response;

        })

        .then(() => {

            document.getElementById("message").innerText =
                "Registration successful!";

            document.getElementById("registerForm").reset();

        })

        .catch(error => {

            console.error(error);

            document.getElementById("message").innerText =
                "Registration failed!";

        });

    });