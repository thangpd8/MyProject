function validateRegister() {
	var firstNameElement = document.getElementById("firstName");
	var lastNameElement = document.getElementById("lastName");
	var emailElement = document.getElementById("email");
	var userNameElement = document.getElementById("userName");
	var passwordElement = document.getElementById("password");
	var confirmpasswordElement = document.getElementById("confirmpassword");

	function setBorderColor(element) {
		if (element.value == "") {
			element.style.borderColor = "red";
		} else {
			element.style.borderColor = "green";
		}
	}
	setBorderColor(firstNameElement);
	setBorderColor(lastNameElement);
	setBorderColor(emailElement);
	setBorderColor(userNameElement);
	setBorderColor(passwordElement);
	setBorderColor(confirmpasswordElement);

	var status = false;
	var message = "please all fill madatory fields";
	var email = emailElement.value;
	if (email != "" && !validateEmail(email)) {
		message = "Email is incorrect format";
		emailElement.style.borderColor = "red";
	} else if (passwordElement.value != confirmpasswordElement.value) {
		message = "Confirm password is not match with password"
	}

	// count number of input tags
	var numberOfInput = document.getElementsByTagName("input").length;
	var countNumberValiInput = 0;
	for (var j = 0; j < numberOfInput; j++) {
		if (document.getElementsByTagName("input")[j].style.borderColor == "green") {
			countNumberValiInput++;
		}
	}
	if (countNumberValiInput == numberOfInput) {
		message = "";
		status = true;
	}
	document.getElementById("error").innerHTML = message;
	if (status) {
//		showUserRegisted();
		return true;
	}
	return false;
}
function validateEmail(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
function showUserRegisted() {
	var table = document.getElementById("tbl-result").getElementsByTagName(
			"tbody")[0];
	var index = table.rows.length;
	if (table.rows.length == 0) {
		var thead = document.getElementById("tbl-result").getElementsByTagName(
				"thead")[0];
		var row = thead.insertRow(0);
		row.insertCell(0).outerHTML = "<th>No</th>";
		row.insertCell(1).outerHTML = "<th>First Name</th>";
		row.insertCell(2).outerHTML = "<th>Last Name</th>";
		row.insertCell(3).outerHTML = "<th>Email</th>";
		row.insertCell(4).outerHTML = "<th>User Name</th>";
	}
	var row = table.insertRow(table.rows.length);
	row.insertCell(0).innerHTML = ++index;
	row.insertCell(1).innerHTML = document.getElementById("firstName").value;
	row.insertCell(2).innerHTML = document.getElementById("lastName").value;
	row.insertCell(3).innerHTML = document.getElementById("email").value;
	row.insertCell(4).innerHTML = document.getElementById("userName").value;

}
