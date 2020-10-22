function getPoints(){
    $.ajax({
        method: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        url: 'points',
        success: function (results) {
            let point=document.getElementById("point");
            let data=[];
            for(let i=0;i<results.length;i++){
                let div = document.createElement("div");
                data[i]=results[i]['address'];
                div.innerHTML=results[i]['address']+"\ud83d\udcde"+results[i]['phone'];
                point.appendChild(div);

            }
            localStorage.setItem('point', JSON.stringify(data));
            console.log(data);
            console.log("success");

        },
        error: function (e) {
            console.log(e);

        }
    })
}