# Game_Log_Tracker
Final project for Object Oriented Analysis and Design. Web Application for tracking games and game sessions. Designed to allow people to have a better experience while gaming

## Team Members
Gregorio Figueroa, Darrien Lee, Jackson Meyer

### Creating Mongo User Collection
The current easiest way for you to create a local starter Mongo database
is to use the MongoCollectionCreator class. Everytime the program is ran, this 
class's "run" method will be called. If this is the first time you are using it, 
just run the program and there will be a collection created locally under the name 
users. Once this is done, comment out the @Component annotation so this code won't be run 
when you run the program later on. 

If you ever need to reset or delete the mongo collection, put the annotation back  

### Running the Project
Step 1) Create an empty MongoDB by executing mongod.exe

Step 2) Create a Mongo terminal window by executing mongo.exe

Step 3) Run the program with @Component uncommented

- (Don't forget to comment it out after this first run (as noted above)! Or it will delete and repopulate the MongoDB.)

Step 4) In this Mongo terminal window, type db.user.find({})

Step 5) Copy one of the preset ObjectID string

Step 6) Compile and run the program with IntelliJ or in terminal in project directory enter this command:

 - For windows: mvnw spring-boot:run 
 - For MacOS/Linux: ./mvnw spring-boot:run

Step 7) Navigate to " LocalHost:8080/?id="PASTE-USER-ID-HERE" " on your browser

- (Paste the ObjectID string obtained from step 4 into the "PASTE-USER-ID-HERE" without quotes)

Step 7) The project should be up and running on your browser! Test it out!

### System Requirements
1. mongo and mongod installation (version 4.4)
2. IntelliJ (version 2020.2.1), terminal, or other IDE to run the program
3. A supported browser

### Demo Link
Final Project Video Demo: https://drive.google.com/file/d/15xkNZoheZbY1gNYjsS7a4OZaXvQZC3y5/view?usp=sharing