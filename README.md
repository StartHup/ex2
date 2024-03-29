# Overall structure:
We created an interface called App and then 4 classesm one for each app, which implement this interface. 
The App file contains the basic functions that each app must contain. These are runApp(), printAllContents(), getAppName(), and exitApp().
Since each app will need to implement these functions differently the file is an interface and contains no implementation.

Each app has a main file which runs the app, which (as mentioned above) implements the App interface. These are MediaApp, MessengerApp, PhoneBookApp, and CalendarApp.

The main creates an object from each of the four app classes. Then the main menu calls app.runApp() for the relevent app object as selected by the user in the menu. The implementation of runApp() within each app class then prints the app's menu and gives the user access to all the options for that app.

In addition, each app has supporting classes which are used to store the data. We will go through each and describe them.

### PhonebookApp
The only supporting class is called Contact and is a standalone class which does not inherit or implement anything. Contact contains the data for each individual contact, that being the name and phone number. It also includes getter and setter functions to access the data.

The phonebook itself stores the contact objects in an ArrayList. When a new contact is added by the user, the program creates a new Contact object and adds it to the ArrayList. This happens within the PhonebookApp object which was created in the main.

### MediaApp
The supporting files are Media, AudioFile, VideoFile. 

Media is an abstract class. It includes the basic data that all types of media files will have. It also includes the implementation of the basic functions that all types of media files will share. However there will be no objects created with this class, as the actual files will have a specific type. Thus Media is an abstract class and not an interface. 

There are two classes which extend Media, one for each type of media. These are AudioFile and VideoFile. They use the shared functionality of the parent class and each make relevent changes for their respective types.

### Calendar
The supporting files are BusyDate, Event, and Meeting.

Similar to the Media app, BusyDate is an abstract class which contains basic data that all types of calendar entires will have, ie the duration and the Date object. Again, there will be no objects created with this class, as the actual calandar entries will have a specific type (meeting or event). Thus BusyDate is an abstract class and not an interface.

There are two classes which extend BusyDate, one for each type of calendar entry. These are Meeting and Event. Meeting is with a specific Contact an Event is private. They use the shared functionality of the parent class and each make relevent changes for their respective types.

### Messenger
The Messenger program has only a single supporting class called MessageChain. This contains a list of Strings and a Contact object and represents the conversation with that contact. This class does not inherit or implement any other classes.
