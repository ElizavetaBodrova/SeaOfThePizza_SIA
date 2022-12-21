init();

function init(){

    getFeedbaks();
    getPoints();
    //getCustomers();
}
function findById(data){
    let id=document.getElementById(data);
    id.scrollIntoView({block: "start", inline: "center"});
}
