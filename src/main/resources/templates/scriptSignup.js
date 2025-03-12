document.getElementById("signupForm").addEventListener("submit", async function (event) {
    event.preventDefault();

    const fullname = document.getElementById("fullname").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const loginData = {
        fullname: fullname,
        email: email,
        password: password
    };

    try {
        const response = await fetch("http://localhost:8080/api/auth/signup", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(loginData)
        });

        const data = await response.json();

        if (response.ok) {
            document.getElementById("message").innerText = "Login successed!";
            localStorage.setItem("token", data.token);
            window.location.href = "dashboard.html";
        } else {
            document.getElementById("message").innerText = "Login failed: " + (data.message || "Please check again you username and password");
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("message").innerText = "there are error, please try again letter.";
    }
});