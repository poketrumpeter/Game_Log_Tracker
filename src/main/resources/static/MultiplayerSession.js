function addMatchInput(){

    var table = document.getElementById("statsTable");
    var rows = table.rows.length

    var newMatch = document.createElement("tr")

    newMatch.innerHTML = "<label>Match Kills</label> \n"
    newMatch.innerHTML += "<input id='matches" + rows + ".kills' name='matches["+rows+"].kills'> \n"
    newMatch.innerHTML += "<br>"
    newMatch.innerHTML += "<label>Match Deaths</label> \n"
    newMatch.innerHTML += "<input id='matches" + rows + ".deaths' name='matches["+rows+"].deaths'> \n"
    newMatch.innerHTML += "<br> \n"
    newMatch.innerHTML += "<label>Match Assists</label> \n"
    newMatch.innerHTML += "<input id='matches" + rows + ".assists' name='matches["+rows+"].assists'>"
    newMatch.innerHTML += "<div> \n"
    newMatch.innerHTML += "<input type='radio' id='matches" + rows + ".victory' name='matches["+rows+"].victory' value=True> \n"
    newMatch.innerHTML += "<label for='matches["+rows+"].victory'>Win</label> \n"
    newMatch.innerHTML += "<input type='radio' id='matches" + rows + ".victory' name='matches["+rows+"].victory' value=False> \n"
    newMatch.innerHTML += "<label for='matches["+rows+"].victory'>Loss</label> \n"
    newMatch.innerHTML += "</div>"

    console.log(newMatch);

    table.appendChild(newMatch)
    table.appendChild(document.createElement("br"))


}