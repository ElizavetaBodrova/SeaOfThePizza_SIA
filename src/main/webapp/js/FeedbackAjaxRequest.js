function getFeedbaks() {
    $.ajax({
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        url: 'feedbacks',
        success: function (results) {
            let feedbacks = document.getElementById("feedback");
            for (let i = 0; i < results.length; i++) {
                let div = document.createElement("div");
                let stars;
                switch (results[i]['mark']) {
                    case 1: {
                        stars = "\u2b50";
                        break;
                    }
                    case 2: {
                        stars = "\u2b50\u2b50";
                        break;
                    }
                    case 3: {
                        stars = "\u2b50\u2b50\u2b50";
                        break;
                    }
                    case 4: {
                        stars = "\u2b50\u2b50\u2b50\u2b50";
                        break;
                    }
                    case 5: {
                        stars = "\u2b50\u2b50\u2b50\u2b50\u2b50";
                        break;
                    }
                }
                div.innerHTML = results[i]['comment'] + "  " + stars;
                feedbacks.appendChild(div);
            }
            console.log("success");
        },
        error: function (e) {
            console.log(e);
        }
    })
}

function setFeedbacks() {
    let order = document.getElementById("_order").value;
    let phone = document.getElementById("_phoneOrder").value;
    let comment = document.getElementById("_comment").value;
    let mark;
    for (let i = 5; i >= 1; i--) {
        let id = "star-" + i;
        let element = document.getElementById(id);
        if (element.checked) {
            mark = element.value;
            i = 0;
        }
    }
    if (order !== null && phone !== null && comment !== null && mark !== null) {
        let SendData =
            {
                order: order,
                phone: phone,
                mark: mark,
                comment: comment
            }
        let JsonData = JSON.stringify(SendData);
        $.ajax({
            method: 'POST',
            dataType: 'JSON',
            contentType: 'application/json',
            url: 'newF',
            data: JsonData,
            success: function (results) {
                console.log(results);
                if (results == 0) {
                    alert("\u041e\u0439\u002d\u043e\u0439\u0021\u0020\u041f\u043e\u0445\u043e\u0436\u0435\u002c\u0020\u0442\u0430\u043a\u043e\u0433\u043e\u0020\u0437\u0430\u043a\u0430\u0437\u0430\u0020\u043d\u0435\u0020\u0431\u044b\u043b\u043e\u0020\u0438\u043b\u0438\u0020\u0432\u044b\u0020\u043d\u0435\u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e\u0020\u0443\u043a\u0430\u0437\u0430\u043b\u0438\u0020\u043d\u043e\u043c\u0435\u0440");

                }
                else{
                    alert("\u0421\u043f\u0430\u0441\u0438\u0431\u043e\u0020\u0437\u0430\u0020\u043e\u0442\u0437\u044b\u0432\u0021");
                }
            },
            error: function (e) {
                console.log(e);
            }
        })
    } else {
        alert("\u0424\u043e\u0440\u043c\u0430\u0020\u043d\u0435\u0020\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0430");
    }
}