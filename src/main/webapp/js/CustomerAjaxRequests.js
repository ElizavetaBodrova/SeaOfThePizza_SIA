function sendCustomer() {
    let phone = document.getElementById("_phone").value;
    let password = document.getElementById("_password").value;
    let check = checkPassword(password)
    if (check) {

        let SendData =
            {
                phone: phone,
                pswd: password,
                role: "CUSTOMER"
            }
console.log(SendData);

        let JsonData = JSON.stringify(SendData);

        $.ajax({
            method: 'POST',
            dataType: 'JSON',
            contentType: 'application/json',
            url: 'customer',
            data: JsonData,
            success: function (data) {
                if (data) {//create new div element
                    let ResponseData =
                        {
                            phone: SendData.phone,
                            role: data['role']['name']
                        }
                    console.log(JSON.stringify(ResponseData))
                    JsonData =JSON.stringify(ResponseData);
                    localStorage.setItem('user',JsonData);
                    customerLog(data);

                } else {
                    alert("\u041d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u044b\u0439\u0020\u043f\u0430\u0440\u043e\u043b\u044c\ud83d\ude1f")
                }
                console.log(data);

            },
            error: function (e) {
                console.log(e);

            }
        })
        return SendData;
    }

}

function checkPassword(inputtxt) {
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    if (inputtxt.match(passw)) {
        return true;
    } else {
        alert('Wrong...!')
        return false;
    }
}

function customerLog() {
    data = JSON.parse(localStorage.getItem('user'));
    if (data['role']==="ADMIN") {
        let result = document.getElementById("identification");
        let div = document.createElement("div");
        div.id = "identification";
        let button = document.createElement("button");
        button.id = "clear_customer";
        button.class = "buttonOrder";
        button.setAttribute("onclick","clear()");
        button.innerHTML = "\u0412\u044b\u0439\u0442\u0438";
        div.innerHTML =
         "\u041f\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u0435\u043c\u002c\u0020\u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0442\u043e\u0440\u0021";
        div.append(button);
        result.replaceWith(div);
        let adminElem = document.getElementById("admin");
        div = document.createElement("div");
        div.id="admin";
        let input = document.createElement("input");
        input.type="button";
        input.value="\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0438";
        input.setAttribute("onclick","location.href='admin'");
        input.setAttribute("class","buttonOrder");
        div.append(input)
        adminElem.replaceWith(div);
    }
    else {
        let result = document.getElementById("identification");
        let div = document.createElement("div");
        div.id = "identification";
        let button = document.createElement("button");
        button.id = "clear_customer";
        button.class = "buttonOrder";
        button.setAttribute("onclick","clear()");
        button.innerHTML = "\u0412\u044b\u0439\u0442\u0438";
        div.innerHTML = "\u041f\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u0435\u043c\u002c\u0020\u043d\u0430\u0448\u0020\u043b\u044e\u0431\u0438\u043c\u044b\u0439\u0020\u0433\u043e\u0441\u0442\u044c\ud83d\ude0a\ud83c\udf55";
        div.append(button);
        result.replaceWith(div);
    }

}

function clear() {
    data = JSON.parse(localStorage.getItem('user'))['role'];
    localStorage.removeItem('user');
    let result = document.getElementById("identification");
    let div = document.createElement("div");
    div.id = "identification";
    let log = "<input autocomplete='username' type='text' placeholder='\u0412\u0432\u0435\u0434\u0438\u0442\u0435\u0020\u0432\u0430\u0448\u0020\u0442\u0435\u043b\u0435\u0444\u043e\u043d' id='_phone' required='required'>"
        + "<input autocomplete='current-password' type='password' id='_password' placeholder='\u0412\u0432\u0435\u0434\u0438\u0442\u0435\u0020\u043f\u0430\u0440\u043e\u043b\u044c' required='required'>"
        + " <button style='height: 20px' onclick='sendCustomer()' class='buttonOrder'>" + "\u0412\u043e\u0439\u0442\u0438" + " </button>";
    div.insertAdjacentHTML('afterbegin', log);
    result.replaceWith(div);
    if(data==="ADMIN"){
        result = document.getElementById("admin");
        div = document.createElement("div");
        div.id = "admin";
        let log = "";
        div.insertAdjacentHTML('afterbegin', log);
        result.replaceWith(div);
    }
    if(window.location.href ==="/") window.location.href="cart"
    window.location.href = "/";
    window.location.reload();

}

