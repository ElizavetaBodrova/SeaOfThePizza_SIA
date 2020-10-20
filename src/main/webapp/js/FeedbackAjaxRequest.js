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