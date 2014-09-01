Instruction how to run this project

1. Install the lastest Maven:
http://maven.apache.org/download.cgi

2. Unzip the file ComHemTestCode.zip

3. Open the command and go to the folder which is just unzipped

4. Run the command: mvn package

5. Run the command: java -jar target/montihallforcomhem.jar 1000



NOTE THAT THIS APPLICATION CAN BE RUN ON DIFFERENT DOORS (NOT JUST 3 DOORS).
IN ORDER TO DO SO, JUST CHANGE THE FOLLOWING CODE IN 
src/main/java/se/hiq/comhem/MontiHallGame.java:

private static final int NUMBER_OF_DOORS = 3;