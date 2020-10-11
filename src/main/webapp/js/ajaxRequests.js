function sendCustomer() {
    let phone = document.getElementById("_phone").value;
    let password = document.getElementById("_password").value;

    let SendData =
        {
            phone: phone,
            password: password
        }


   let JsonData = JSON.stringify(SendData);

    $.ajax({
        method: 'POST',
        dataType: 'JSON',
        contentType: 'application/json',
        url: 'customer',
        data: JsonData,
        success: function (data) {
            console.log("success");
            console.log(data);

        },
        error: function (e) {
            console.log(e);

        }
    })
}