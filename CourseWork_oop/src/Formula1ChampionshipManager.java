import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager{

    private static ArrayList<Formula1Driver> driverList;
    private static ArrayList<Race> raceList;
    private static ArrayList<Integer> pointsTablelist;
    private static int MAX_DRIVER;

    /**
     * Assumption : The maximum and minimum of drivers is '10'
     * All drivers participate in the race
     * @param MAX_DRIVER
     */
    public Formula1ChampionshipManager(int MAX_DRIVER) {
        driverList = new ArrayList<>(MAX_DRIVER);
        raceList = new ArrayList<>();
        pointsTablelist = new ArrayList<>(Arrays.asList(25,18,15,12,10,8,6,4,2,1));
        this.MAX_DRIVER = MAX_DRIVER;
    }

    public static ArrayList<Formula1Driver> getDriverList() {
        return driverList;
    }

    @Override
    public void addNewDriver(Formula1Driver driver) {

        boolean foundDriver = false, foundTeamName = false;     //variable to predict if driver/team already exist
        if (driverList.size()==MAX_DRIVER){
            System.out.println("\n[APPLICATION] : No available openings, the list is full.\n" +
                               "[APPLICATION] : THANK YOU\n");
        }
        else{
            for (Formula1Driver formula1Driver:driverList) {
                if(driver.getNameOfDriver().equals(formula1Driver.getNameOfDriver())){
                    foundDriver = true;
                    break;
                }
                if(driver.getConstructorTeamName().equals(formula1Driver.getConstructorTeamName())){
                    foundTeamName = true;
                    break;
                }
            }
            if(foundDriver){
                System.out.println("\n[APPLICATION] : The Driver has already registered for the race.\n");
            }
            else if(foundTeamName){
                System.out.println("\n[APPLICATION] : The Constructor Team has already registered for the race.\n");
            }
            else{
                driverList.add(driver);
                System.out.println("\n[APPLICATION] : Driver '" + driver.getNameOfDriver() + "' has successfully registered for the race." +
                                   "\n[APPLICATION] : " + driver.toString() +
                                   "\n[APPLICATION] : REMAINING SLOTS : " + (MAX_DRIVER - (driverList.size())) + "\n");
            }
        }
    }

    @Override
    public void deleteExistingDriver(String nameOfDriver){

        boolean foundDriver = false;
        if(driverList.isEmpty()){
            System.out.println("\n[APPLICATION] : No Drivers registered so far, the list is empty.\n" +
                               "[APPLICATION] : THANK YOU\n");
        }
        else{
            for (Formula1Driver driver:driverList) {
                if(nameOfDriver.equals(driver.getNameOfDriver())){
                    System.out.println(driver.toString());
                    driverList.remove(driver);
                    foundDriver = true;
                    break;
                }
            }

        if(foundDriver){
            System.out.println("\n[APPLICATION] : Driver '" + nameOfDriver + "' has successfully UNREGOSTERED from the race." +
                               "\n[APPLICATION] : REMAINING SLOTS : " + (MAX_DRIVER - (driverList.size())) + "\n");
        }
        if(!foundDriver){
            System.out.println("\n[APPLICATION] : Driver '" + nameOfDriver + "' is NOT registered so far.\n");
        }

        }
    }

    @Override
    public void changeExistingTeam(String nameOfDriver,String constructorTeamName) {

        boolean foundDriver = false;
        if(driverList.isEmpty()){
            System.out.println("\n[APPLICATION] : No Drivers registered so far, the list is empty.\n" +
                    "[APPLICATION] : THANK YOU\n");
        }
        else {
            for (Formula1Driver driver:driverList) {
                if (driver.getConstructorTeamName().equals(constructorTeamName)){
                    System.out.println("\n[APPLICATION] : Constructor team '" + constructorTeamName + "' already registered.\n");
                    System.out.println(driver.toString() + "\n");
                    foundDriver = true;
                    break;
                }
                else {
                    if(driver.getNameOfDriver().equals(nameOfDriver)){
                        driver.setConstructorTeamName(constructorTeamName);
                        System.out.println("\n[APPLICATION] : Constructor team of Driver '" + nameOfDriver + "' changed to '" + constructorTeamName +"'.\n");
                        System.out.println(driver.toString() + "\n");
                        foundDriver = true;
                        break;
                    }
                }
            }
            if(!foundDriver){
                System.out.println("\n[APPLICATION] : Driver '" + nameOfDriver + "' is not registered for the race.\n");
            }
        }
    }

    @Override
    public void displayStatisticsOfDriver(String nameOfDriver) {

        boolean foundDriver = false;
        if(driverList.isEmpty()){
            System.out.println("\n[APPLICATION] : No Drivers registered so far, the list is empty.\n" +
                    "[APPLICATION] : THANK YOU\n");
        }
        else{
            for(Formula1Driver driver : driverList){
                if(driver.getNameOfDriver().equals(nameOfDriver)){
                    System.out.println("\n[APPLICATION] : Driver '" + nameOfDriver + "' found.\n");
                    System.out.println(driver.toString() + "\n");
                    foundDriver = true;
                }
            }

        if(!foundDriver){
            System.out.println("\n[APPLICATION] : Driver '" + nameOfDriver + "' is not registered for the race.\n");
            }
        }
    }

    @Override
    public void addNewRace(Race race,ArrayList<String> tempRaceList) {

        boolean foundDriver = true;
        String nameOfDriver = null;
        if(driverList.isEmpty()){
            System.out.println("\n[APPLICATION] : No Drivers registered so far, the list is empty.\n" +
                    "[APPLICATION] : THANK YOU\n");
        }else{

            raceList.add(race); //adding the race details

            for (Formula1Driver driver :driverList) {
                if(!tempRaceList.contains(driver.getNameOfDriver())){
                    nameOfDriver = driver.getNameOfDriver();
                    foundDriver = false;
                    break;
                }else{
                    /**
                     * checking for no of first position
                     * @PARAM setNoOfFirstPosition
                     */
                    if(race.getFirstPosition().equals(driver.getNameOfDriver())){
                        driver.setNoOfFirstPosition(driver.getNoOfFirstPosition() + 1);
                        driver.setTotalPoint(driver.getTotalPoint() + pointsTablelist.get(0));
                    /**
                     * checking for no of second position
                     * @PARAM setNoOfSecondPosition
                     */
                    }else if (race.getSecondPosition().equals(driver.getNameOfDriver())){
                        driver.setNoOfSecondPosition(driver.getNoOfSecondPosition() + 1);
                        driver.setTotalPoint(driver.getTotalPoint() + pointsTablelist.get(1));
                    /**
                     * checking for no of third position
                     * @PARAM setNoOfThirdPosition
                     */
                    }else if (race.getThirdPosition().equals(driver.getNameOfDriver())){
                        driver.setNoOfThirdPosition((driver.getNoOfFirstPosition() + 1));
                        driver.setTotalPoint(driver.getTotalPoint() + pointsTablelist.get(2));
                    }else{
                        for (int i = 0; i < (driverList.size()-3); i++){
                            if(tempRaceList.get(i+3).equals(driver.getNameOfDriver())){
                                driver.setTotalPoint(driver.getTotalPoint() + pointsTablelist.get(i+3));  //set points for position 4-10
                            }
                        }
                    }
                    foundDriver = true;
                    driver.setNoOfParticipatedGames(driver.getNoOfParticipatedGames() + 1);
                }
            }

            if(!foundDriver){
                System.out.println("\n[APPLICATION] : Wrong position list.");
                System.out.println("[APPLICATION] : Driver '" + nameOfDriver + "' is not included in the race positions.\n");
            }
            if(foundDriver){
                System.out.println("\n[APPLICATION] : Race positions are recorded successfully");
                printRaceList(tempRaceList);
                System.out.println("\n");
            }
        }
    }

    private void printRaceList(ArrayList<String> tempRaceList) {
        for(int i = 0; i < tempRaceList.size(); i++){
            System.out.println(("   Position " + (i+1) + ": " + tempRaceList.get(i)));
        }
    }

    @Override
    public void displayDriverTable() {

        if(driverList.isEmpty()){
            System.out.println("\n[APPLICATION] : No Drivers registered so far, the list is empty.\n" +
                    "[APPLICATION] : THANK YOU\n");
        }else{
            Collections.sort(driverList, new PointsComparator());
            System.out.println("                                                   F1 CHAMPIONSHIP TABLE\n" +
                               "--------------------------------------------------------------------------------------------------------------------------------------\n" +
                               "||  DRIVER NAME  ||      TEAM      ||  FIRST POSITION  ||  SECOND POSITION   ||  THIRD POSITION  ||    POINTS    ||   NO OF GAMES  ||");
            for (Formula1Driver formula1Driver : driverList) {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\n||       "+ formula1Driver.getNameOfDriver() + "       ||      " + formula1Driver.getConstructorTeamName() + "        ||         " +
                                  formula1Driver.getNoOfFirstPosition() + "        ||           " + formula1Driver.getNoOfSecondPosition() + "           ||         " +
                                  formula1Driver.getNoOfThirdPosition() + "         ||        " + formula1Driver.getTotalPoint() + "      ||       " +
                                  formula1Driver.getNoOfParticipatedGames() + "     ||");
            }

        }
    }

    @Override
    public void writeFile(){


        try{

//driver statistics
            File file1=new File("DriverStatistics.txt");
            FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

//race summary
            File file2=new File("RaceSummary.txt");
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);

            for(Formula1Driver formula1Driver : driverList) {
                objectOutputStream1.writeObject(formula1Driver);
            }

            objectOutputStream1.flush();
            fileOutputStream1.close();
            objectOutputStream1.close();

            for(Race race : raceList) {
                objectOutputStream2.writeObject(race);
            }

            objectOutputStream2.flush();
            fileOutputStream2.close();
            objectOutputStream2.close();

            System.out.println("[APPLICATION] Details recorded in file successfully\n");

        }
        catch(IOException e){
            System.out.println("[ERROR] Unable to save in file\n");

        }
    }

    @Override
    public void readFile() {
        try {

//driver Statistics
            File file=new File("DriverStatistics.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);


//race summary
            File file2=new File("RaceSummary.txt");
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            ObjectInputStream objectInputStream2= new ObjectInputStream(fileInputStream2);

            for(;;) {
                try {

                    Formula1Driver formula1Driver = (Formula1Driver) objectInputStream.readObject();
                    driverList.add(formula1Driver);

                }
                catch (EOFException e) {
                    break;
                }
            }

            for(;;) {
                try {

                    Race race = (Race) objectInputStream.readObject();
                    raceList.add(race);

                }
                catch (EOFException e) {
                    break;
                }
            }


        }catch (FileNotFoundException e) {
            System.out.println("[ERROR] File not found\n");

        }catch (IOException e) {
            System.out.println("[ERROR] Cannot load file\n");
        }catch (ClassNotFoundException e) {
            System.out.println("[ERROR] Class not found\n");
        }

    }
}