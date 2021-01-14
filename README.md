# FrameworkTesting

Project outline:
Attempt to build a testing framework to test a star wars API specifically, this included creating classes for at least the following:

1. DTO's for different types of json files that can be called.
2. Connection manager to get the status code of a response for a supplied url.
3. Value injector to map the data in the online json file into the DTO

FrameWork Structure

Classes
FrameWork Package:
- ConnectionManager
- RetrieveBodyOrResource
- ValueExists
- ValueInjector 

FrameWork Tests:
- StarwarsTests

ConnectionManager

Methods & Uses
1. setUrl:
- Used to ensure all static variables have the correct values for object being tested

2. getStatusCode:
- Used to get the current objects url status code.

3. isValidURL:
- This creates a hashmap from local Json file the containes all error codes and their assosiated description, these are the printed in error format to the console window for tester information.

RetrieveBodyOrResource

Methods & Uses
1. Constructor
- Creates an instance of the class and populates the class variables for extraction in ValueInjector.

2. Split:
Removes Base url so that the resource name can be taken from the result for use in the ValueInjector Factory


ValueInjector

Methods & Uses
1. whichObject:
- At the moment this method does two things, its primary job is to ensure the correct resource is passed into the createDTO factory to ensure the Object is populated in the correct way. 
- Its secondary job is the correction of a http bug that already exists within the Star wars API, which has only been implemented in order to test other functionality.

2. createDTO:
(This is the money maker)
- First it checks to see if the string value is null, if so it returns a null object.
- If it not null then the method uses Object mapper to map the body of the url location onto the class dictated by the found resource value in the whichObject method.
- Then returns this object so it can be cast to the object needed in the test bed.

3.isNull:
Does what is says on the tin


ValueExists

Methods & Uses
1. isStarshipByName
- Gets all starship name values from API and checks if given value is amoung them

2.isPersonByName
- Gets all people name values from API and checks if given value is amoung them

3. isPlanetByName
- Gets all planet name values from API and checks if given value is amoung them

4. isFilmByTitle
- Gets all Film titel values from API and checks if given value is amoung them

5. isSpeciesByName
- Gets all Species name values from API and checks if given value is amoung them

6. isVehicleByName
- Gets all Vehicle name values from API and checks if given value is amoung them
