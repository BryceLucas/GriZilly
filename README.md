# GriZilly
GriZilly is a *local* music playing application. This means that GriZilly can only play music files located on your computer's hard drive or SSD.

GriZilly's main features are adding directories that music lives in, playing/pausing music, and skipping tracks.

## How to build and run GriZilly
### Dependencies

GriZilly is built in Java using Maven. So to begin with you will have to install Maven and Java.

Once you have that, Maven itself will handle all of the dependencies that the project needs, such as JavaFx, gson, and jaudiotagger.

### Building & running GriZilly

1. Git clone the repository
```
git clone https://github.com/BryceLucas/GriZilly
```
2. Change directories into the repo
```
cd GriZilly
```
3. Build and run the project with
```
mvn clean javafx:run
```