
# FFBEUnitEquiper

This began as a bad unit calculator I made for an intro App design class.
Ive been recoding with better practices than when I firist started.
My goal is to take what I learned and create something I can share with the FFBE community, and learn some new things during the process. It is a Java based program that connects to a Database using JDBC driver.

## ToDo

1. Create Splitter for Database.json data - Upload splitter, .json data and SQL file of values.
2. Add data into Database - MYSQL Workbench or GCP commandline
3. Create Functionality for Controller
4. Rework visual design of FXML

## Getting Started

### Prerequisites

[Eclipse](https://www.eclipse.org/) - IDE for Java
[JavaFX Scenebuilder](https://www.oracle.com/technetwork/java/javase/downloads/javafxscenebuilder-info-2157684.html) -  To create and edit the FXML layout file

### Installing

1. Create a new Java project
2. Place the .java files into the default Package. The FFBEDatabase.java and FFBEDatabaseController.java need to be in default to interact with the FXML.
3. MySQLAccess could be placed in it's own package, I put mine in default.
4. Add the FXML file to the project. Make sure it is within the SRC folder, but not within any packages.

## Running the tests

Currently, the database information we have provided in the files will not allow any user to access the database. Once more security measures are in place, access will be open to the public to use.


### Break down into end to end tests

Currently, testing is difficult without the controller set properly.
A user could hardcode in the ID to recieve the information from whatever table they desire.
It properly fetches the data and displays it.
More to come on testing when the GUI is further along.


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

* Big thanks to 
* Inspiration
