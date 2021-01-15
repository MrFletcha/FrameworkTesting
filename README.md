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


ConnectionManager

Methods & Uses
1. setUrl:
- Needs a url argument
- Used to ensure all static variables have the correct values for object being tested

2. getStatusCode:
- This works off the currently set URL
- Used to get the current objects url status code.

3. isValidURL:
- Needs a url are to be passed into it for the check
- This creates a hashmap from local Json file the containes all error codes and their assosiated description, these are the printed in error format to the console window for tester information.

4. headerCheck:
- Needs the header you want to check and the url you want to check it on
- The it returns the value of that header
- if the header value is null then it returns "null"

5. headerCount
- Needs a url passed into it for the check
- This then displays a list of all the headers and their values to the console
- The returns the number of headers that the url address has

RetrieveBodyOrResource

Methods & Uses
1. Constructor
- Creates an instance of the class and populates its variables "body" and "resource" for extraction in ValueInjector.

2. Split:
Removes Base url so that the resource name can be taken from the result for use in the ValueInjector Factory


ValueInjector

Methods & Uses
1. whichObject:
- Takes in the url from the below method
- At the moment this method does two things, its primary job is to ensure the correct resource is passed into the createDTO factory to ensure the Object is populated in the correct way. 
- Its secondary job is the correction of a http bug that already exists within the Star wars API, which has only been implemented in order to test other functionality.

2. createDTO:
(This is the money maker)
- Takes in the url
- First it checks to see if the string value is null, if so it returns a null object.
- If it not null then the method uses Object mapper to map the body of the url location onto the class dictated by the found resource value in the whichObject method.
- Then returns this object so it can be cast to the object needed in the test bed.

3.isNull:
- Does what is says on the tin
- Gets called by the above methods


ValueExists

Methods & Uses
1. isStarshipByName
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all starship name values from API and checks if given value is amoung them

2.isPersonByName
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all people name values from API and checks if given value is amoung them

3. isPlanetByName
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all planet name values from API and checks if given value is amoung them

4. isFilmByTitle
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all Film titel values from API and checks if given value is amoung them

5. isSpeciesByName
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all Species name values from API and checks if given value is amoung them

6. isVehicleByName
- Takes in a string argument of the value you are looking for, this needs to match the formatting to produce accurate results
- Gets all Vehicle name values from API and checks if given value is amoung them

7. allBirthYears
- Doesn't need arguments as its used to retrieve data not check it
- Gets all current birth years used in the API into a Set and returns it

Type Package:
People (DTO)

1. hasShip
- Takes String argument of search value
- Checks if the current Person has the ship being searched

2. inFilm
- Takes String argument of search value
- Checks if current person was in the film searched

3. hasVehicle
- Takes String argument of search value
- Checks if current person has the selected vehicle

The class above and all the below share these methods in one form or another, each of them will print out the searched for value in a message to the console along with a boolean confirming true or false. These will all need a string argument of the value you are searching for.

- Films
- Species
- Vehicles 
- Starships 
- Planets 


FrameWork Tests:
- StarwarsTests
Example tests that can be run through the use of either JUNIT or REST-assured

