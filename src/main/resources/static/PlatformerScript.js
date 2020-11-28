function addLevel(){

    var table = document.getElementById("levelsInput")
    var rows = table.rows.length

    var newLevel = document.createElement("tr")

    newLevel.innerHTML = "<label>Enter Level Number</label> \n"
    newLevel.innerHTML += "<input id='levels" + rows + ".levelNumber' name='levels["+rows+"].levelNumber'> \n"
    newLevel.innerHTML += "<br> \n"
    newLevel.innerHTML += "<label>Enter Completion Time</label> \n"
    newLevel.innerHTML += "<input id='levels" + rows + ".completionTime' name='levels["+rows+"].completionTime'> \n"
    newLevel.innerHTML += "<br> \n"
    newLevel.innerHTML += "<label>Enter Score</label> \n"
    newLevel.innerHTML += "<input id='levels" + rows + ".score' name='levels["+rows+"].score'> \n"
    newLevel.innerHTML += "<br>"

    table.appendChild(newLevel)
    table.appendChild(document.createElement("<br>"))

}