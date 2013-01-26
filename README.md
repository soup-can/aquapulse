Aquapulse
=========

Abstract
--------
To be added.


Configuring Development Environment
-----------------------------------
Maven is being used to handle the dependencies of the project. Setting up the project should be as cloning the
repository and importing it into your IDE.

###Commands

Taken from the [wiki](http://code.google.com/p/libgdx/wiki/MavenProjectSetup)).


####Desktop

To create a runnable jar file for the desktop, run:

`mvn -Pdesktop package`

This will create a file called test-desktop-1.0-SNAPSHOT-jar-with-dependencies.jar in the test/desktop/target folder.
It contains all the necessary dependencies, the assets and a manifest file specifying the main class. You can run this
file via:

`java -jar test-desktop-1.0-SNAPSHOT-jar-with-dependencies.jar`


####Android

To create an unsigned APK for Android, run:

`mvn -Pandroid package`

This will create a file called test-android-1.0-SNAPSHOT.apk in the test/android/target folder. To install the apk to a
connected device or emulator, run

`mvn -Pandroid install`

For more information on Android goals, see the [Maven Android plugin](http://code.google.com/p/maven-android-plugin/).


####HTML5/GWT

To compile the HTML5 project to Javascript, run:

`mvn -Phtml package`

The end result is located in the target/ folder. You can either use the .war file that was generated and deploy that to
Jetty/Tomcat, or copy the contents of the html/target/test-html-1.0-SNAPSHOT/ folder to a location your web server can
server(or even better, create a symlink if you are on an apropriate OS). The war/folder contains all the compiled
Javascript code, the index html file and the assets.

There's currently no way to run the HTML5 project via Maven. This is partially due to path issues and the way the gwt
and jetty plugins work.