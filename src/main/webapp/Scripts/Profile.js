// =========================
// NAME
// =========================

function editName() {

    let currentName =
        document.getElementById("nameValue").innerText;


    document.getElementById("nameValue").innerHTML =

        '<input ' +
        'type="text" ' +
        'id="nameInput" ' +
        'class="edit-input" ' +
        'value="' +
        currentName +
        '">';


    document.getElementById("nameButtons").innerHTML =

        '<button ' +
        'class="save-btn" ' +
        'onclick="saveName()">' +
        'Save' +
        '</button>' +

        '<button ' +
        'class="cancel-btn" ' +
        'onclick="cancelName()">' +
        'Cancel' +
        '</button>';
}


function saveName() {

    let newName =
        document.getElementById(
            "nameInput"
        ).value.trim();


    if (newName === "") {

        alert("Name cannot be empty.");

        return;
    }


    updateUser({

        name: newName

    });
}


function cancelName() {

    location.reload();

}


// =========================
// EMAIL
// =========================

function editEmail() {

    let currentEmail =
        document.getElementById(
            "emailValue"
        ).innerText;


    document.getElementById(
        "emailValue"
    ).innerHTML =

        '<input ' +
        'type="email" ' +
        'id="emailInput" ' +
        'class="edit-input" ' +
        'value="' +
        currentEmail +
        '">';


    document.getElementById(
        "emailButtons"
    ).innerHTML =

        '<button ' +
        'class="save-btn" ' +
        'onclick="saveEmail()">' +
        'Save' +
        '</button>' +

        '<button ' +
        'class="cancel-btn" ' +
        'onclick="cancelEmail()">' +
        'Cancel' +
        '</button>';
}


function saveEmail() {

    let newEmail =
        document.getElementById(
            "emailInput"
        ).value.trim();


    if (newEmail === "") {

        alert("Email cannot be empty.");

        return;
    }


    updateUser({

        email: newEmail

    });
}


function cancelEmail() {

    location.reload();

}


// =========================
// PHONE
// =========================

function editPhone() {

    let currentPhone =
        document.getElementById(
            "phoneValue"
        ).innerText;


    document.getElementById(
        "phoneValue"
    ).innerHTML =

        '<input ' +
        'type="tel" ' +
        'id="phoneInput" ' +
        'class="edit-input" ' +
        'value="' +
        currentPhone +
        '">';


    document.getElementById(
        "phoneButtons"
    ).innerHTML =

        '<button ' +
        'class="save-btn" ' +
        'onclick="savePhone()">' +
        'Save' +
        '</button>' +

        '<button ' +
        'class="cancel-btn" ' +
        'onclick="cancelPhone()">' +
        'Cancel' +
        '</button>';
}


function savePhone() {

    let newPhone =
        document.getElementById(
            "phoneInput"
        ).value.trim();


    if (newPhone === "") {

        alert("Phone cannot be empty.");

        return;
    }


    if (!/^[0-9]{10}$/.test(newPhone)) {

        alert(
            "Please enter a valid 10 digit phone number."
        );

        return;
    }


    updateUser({

        phone: parseInt(newPhone)

    });
}


function cancelPhone() {

    location.reload();

}


// =========================
// UPDATE USER
// =========================

function updateUser(updatedData) {

    fetch(
        "/updateUser/" + userId,
        {
            method: "PUT",

            headers: {
                "Content-Type":
                    "application/json"
            },

            body:
                JSON.stringify(updatedData)
        }
    )

    .then(function(response) {

        if (!response.ok) {

            throw new Error(
                "Update failed"
            );
        }

        return response.text();

    })

    .then(function() {

        alert(
            "Profile updated successfully."
        );

        location.reload();

    })

    .catch(function(error) {

        console.error(error);

        alert(
            "Failed to update profile."
        );

    });

}