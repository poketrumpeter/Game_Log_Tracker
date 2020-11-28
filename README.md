# Game_Log_Tracker
Final project for Object Oriented Analysis and Design. Web Application for tracking games and game sessions. Designed to allow people to have a better experience while gaming

### Creating Mongo User Collection
The current easiest way for you to create a local starter Mongo database
is to use the MongoCollectionCreator class. Everytime the program is run, this 
class's "run" method will be called. If this is the first time you are using it, 
just run the program and there will be a collection created locally under the name 
users. Once this is done, comment out the @Component annotation so this code wont be run 
when you run the program later on. 

If you ever need to reset or delete the mongo collection, put the annotation back  
