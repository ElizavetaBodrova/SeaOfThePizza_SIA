
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
            if(data){//create new div element
                let result=document.getElementById("identification");
                let div = document.createElement("div");
                div.innerHTML="\u041f\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u0435\u043c\u002c\u0020\u043d\u0430\u0448\u0020\u043b\u044e\u0431\u0438\u043c\u044b\u0439\u0020\u0433\u043e\u0441\u0442\u044c\ud83d\ude0a\ud83c\udf55";
                result.replaceWith(div);

                }
            else{
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