init();

function init(){

    getFeedbaks();
    getPoints();
   // createOrder();
}
function findById(data){
    let id=document.getElementById(data);
    id.scrollIntoView({block: "start", inline: "center"});
}