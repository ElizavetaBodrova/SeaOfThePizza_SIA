function getCustomers() {
    $.ajax({
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        url: 'customers',
        success: function (results) {
            console.log(results);
            let roles = document.getElementById("customers.role");
            let phones = document.getElementById("customers.phone");
            let counts = document.getElementById("customers.count");
            let sums = document.getElementById("customers.sum");
            let data = [];
            for (let i = 0; i < results.length; i++) {
                let divR = document.createElement("div");
                data[i] = checkRole(results[i]['role']);
                divR.innerHTML = data[i];
                roles.appendChild(divR);
            }
            for (let i = 0; i < results.length; i++) {
                let divP = document.createElement("div");
                divP.innerHTML = "\ud83d\udcde" + results[i]['phone'];
                phones.appendChild(divP);
            }
            for (let i = 0; i < results.length; i++) {
                let divC = document.createElement("div");
                divC.innerHTML = results[i]['countOfOrders'];
                counts.appendChild(divC);
            }
            for (let i = 0; i < results.length; i++) {
                let divS = document.createElement("div");
                console.log(results[i]['sumOfAllOrders'] != null ? results[i]['sumOfAllOrders'] : 0);
                divS.innerHTML = (results[i]['sumOfAllOrders'] != null ? results[i]['sumOfAllOrders'] : 0).toString();
                sums.appendChild(divS);
            }
            // localStorage.setItem('customer', JSON.stringify(data));
            console.log(data);
            console.log("success");

        },
        error: function (e) {
            console.log(e);

        }
    })
}

function checkRole(item) {
    switch (item) {
        case "CUSTOMER": {
            return "Пользователь"
        }
        case "VISITOR": {
            return "Посетитель"
        }
        case "ADMIN": {
            return "Администратор"
        }
    }

}
