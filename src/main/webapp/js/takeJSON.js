"use strict";

let Users = new Object();
function req(){
    Users.name = document.getElementById("Name").value;
    Users.lastname = document.getElementById("LN").value;
    Users.middlename = document.getElementById("MN").value;
    Users.age = document.getElementById("Age").value;
    Users.language = document.getElementById("Lng").value;

    let mydata = JSON.stringify(Users);
    /*
    jsonreq.open('POST', "http://localhost:8081/L2_war_exploded/AddingServlet?data=" + encodeURIComponent(mydata), true);
    jsonreq.setRequestHeader("Content-Type", "application/json");*/

    $.ajax({
        type: 'POST',
        url: "http://localhost:8081/L2_war_exploded/AddingServlet?data=" + encodeURIComponent(mydata),
        data: mydata,
        dataType: "json",
        contentType: "application/json"
    });
}


