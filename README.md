
# FFBEUnitEquiper
**Unit Equipper Main Files is _depricated._ Use FFBE Database instead.**

This began as a unit calculator I made for an intro App design class.
I've been recoding with better practices.
My goal is to take what I learned and create something I can share with the FFBE community, and learn some new things during the process. It is a Java based program that connects to a Database using JDBC driver.

## ToDo

1. ~~Create Splitter for Database.json data - Upload splitter, .json data and SQL file of values.~~
2. ~~Add data into Database - MYSQL Workbench or GCP commandline~~
3. ~~Create Functionality for Controller~~
4. Rework visual design of FXML
5. Edit JSON data to split more data and fill empty fields.

## Getting Started

### Prerequisites

[Eclipse](https://www.eclipse.org/) - IDE for Java

[JavaFX Scenebuilder](https://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html) -  To create and edit the FXML layout file

### Installing

1. Create a new Java project
2. Place the .java files into the default Package. The FFBEDatabase.java and FFBEDatabaseController.java need to be in default to interact with the FXML.
3. MySQLAccess could be placed in it's own package, I put mine in default.
4. Add the FXML file to the project. Make sure it is within the SRC folder, but not within any packages.
5. You will need JDBC Connector and JSON-simple-1.1.jar downloaded. Add them both to the projects buildpath.

## Running the tests

Users can replicate the database by using the .sql file and creating their own database.
If you do this, you must enter your database's information into the MySQLAccess.java file to allow for connection.
You may also need to whitelist your computer's IP to gain access.


### Break down into end to end tests

As of now, the user should be able to select a unit, and all of the equppables, as well as an esper. Each will populate the correct stat data into the proper fields and update the final stat data. 
Currently, ailment, element, and many of the hidden stats like evasion, killers, etc are not implemented. This is  WIP.


## Built With

* [Eclipse](https://www.eclipse.org/) - IDE for Java
* [JavaFX Scenebuilder](https://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html) -  To create and edit the FXML layout file
* [MYSQL Workbench](https://www.mysql.com/products/workbench/) - To Create and manage the Database
* [Google Cloud Platform](https://cloud.google.com/) - For hosting of the Database

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Shane Kavage** - *Initial work* - [FFBEUnit Equipper](https://github.com/ShaneKavage/FFBEUnitEquiper)
* **Tyler Kavage** - *Initial work* - MYSQL database ERD and database management.

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Big thanks to the people who provided JSON data of all the games equipment and items.
* Inspiration from Final Fantasy Brave Exvius
* Acknowledge any images or data belongs to the company or indiviual that created the asset. We do not claim ownership in anyway.
