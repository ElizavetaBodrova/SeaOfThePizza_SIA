function getPoints(){
    $.ajax({
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        url: 'points',
        success: function (results) {
            let feedbacks=document.getElementById("point");
            for(let i=0;i<results.length;i++){
                let div = document.createElement("div");
                div.innerHTML=results[i]['address']+"\ud83d\udcde"+results[i]['phone'];
                feedbacks.appendChild(div);

            }

            console.log("success");

        },
        error: function (e) {
            console.log(e);

        }
    })
}