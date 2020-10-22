function sendOrder() {//ajax request
    let number = JSON.parse(localStorage.getItem('number')), cart = JSON.parse(localStorage.getItem('cart')),
        phone = document.getElementById("phoneOrder").value,
        idDelivery = document.getElementById("del").querySelectorAll("input");
    let point,idType,nameType;
    for (let elem in idDelivery) {
        if (idDelivery[elem].checked) {
             idType=JSON.parse(idDelivery[elem].id),
                nameType=idDelivery[elem].parentNode.outerText;
        }

    }
    let typeofDelivery= {
        id: idType,
        name: nameType
    };
    if (typeofDelivery["id"]==="1"){
        let pointRadio=document.getElementById("pointCheck").querySelectorAll("input");
        for(let elem in pointRadio){
            if(pointRadio[elem].checked){
                point={
                    id:pointRadio[elem].id,
                    address:pointRadio[elem].parentNode.outerText,
                    phone:null
                }

            }
        }
    }
    else{
        let points=JSON.parse(localStorage.getItem('point'))
        let pointId= Math.floor(Math.random() * (points.length ));
        point={
            id:pointId+1,
            address:points[pointId],
            phone:null
        }

    }
    let order=[],numberOfDish=[];
    for(let i=1;i<cart.length;i++){
        if(cart[i]!==null){
            numberOfDish.push(number[i]);
            order.push(cart[i]);
        }
    }
    if(orderCorrect(order,phone,typeofDelivery,point)){
        let data={
            order:order,
            numberOfDish:numberOfDish,
            phone:phone,
            typeOfDelivery:typeofDelivery,
            point:point
        }
        console.log(data);
        let JsonData = JSON.stringify(data);

        $.ajax({
            method: 'POST',
            dataType: 'JSON',
            contentType: 'application/json',
            url: 'order',
            data: JsonData,
            success: function (data) {
               alert(""+data);
                localStorage.removeItem('cart');
                localStorage.removeItem('number');
                window.location.reload();
                console.log(data);

            },
            error: function (e) {
                console.log(e);

            }
        })

    }
    else{
        alert("")
    }

}

function orderCorrect(order,phone,typeofDelivery,point){
    return order!==null && phone!=="" && typeofDelivery!==null && point !==null
}




