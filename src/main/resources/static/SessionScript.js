function addQuestInput(){

    var table = document.getElementById("questsInput")
    var rows = table.rows.length
    var rowIndex = rows

    var newQuest = document.createElement("tr")
    // newQuest.setAttribute("th:each", "quest,status: ${currentSession.quests}")
    newQuest.innerHTML = "<label>Quest Name</label> \n"
    newQuest.innerHTML += "<input id = \"quests" + rowIndex + ".questName\" name=\"quests["+rowIndex+"].questName\"> \n"
    newQuest.innerHTML += "<br> \n"
    newQuest.innerHTML += "<label>Quest Description</label> \n"
    newQuest.innerHTML += "<input id = \"quests" + rowIndex + ".questDescription\" name=\"quests["+rowIndex+"].questDescription\">"

    // var descriptionLabel = document.createElement("label")
    // descriptionLabel.innerText = "Quest Description"


    var quests = table

    quests.appendChild(newQuest)
    quests.appendChild(document.createElement("br"))
//    quests.appendChild(descriptionLabel)


}