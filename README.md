# Overall structure:
We created an interface called App and then 4 classesm one for each app, which implement this interface. 
The App file contains the basic functions that each app must contain. These are runApp(), printAllContents(), getAppName(), and exitApp().
Since each app will need to implement these functions differently the file is an interface and contains no implementation.

Each app has a main file which runs the app, which (as mentioned above) implements the App interface. These are MediaApp, MessengerApp, PhoneBookApp, and CalendarApp.

The main creates an object from each of the four app classes. Then the main menu calls app.runApp() for the relevent app object as selected by the user in the menu. The implementation of runApp() within each app class then prints the app's menu and gives the user access to all the options for that app.

In addition, each app has supporting classes which are used to store the data. We will go through each and describe them.

### PhonebookApp
This is the most simple of all the apps. The only supporting class is called Contact and is a standalone class which does not inherit or implement anything. Contact containts the data for each individual contact, that being the name and phone number. It also includes getter and setter functions to access the data.

The phonebook itself stores the contact objects in an ArrayList. When a new contact is added by the user, the program creates a new Contact object and adds it to the ArrayList.



