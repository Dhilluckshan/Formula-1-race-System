import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplication {


    private static Scanner scannerObj = new Scanner(System.in);
    private static Formula1ChampionshipManager championshipManager = new Formula1ChampionshipManager(10);
    private final static String TITLE = "----------------------------------------------------------------------------\n" +
                                        "              FORMULA 1 RACING CAR CHAMPIONSHIP 2021\n" +
                                        "----------------------------------------------------------------------------\n" +
                                        "                    <<<EXPERTISE OVER YEARS>>>\n";

    public static void main(String[] args) {

        championshipManager.readFile();
        System.out.println(TITLE);
        boolean consoleMenu = true;

        while (consoleMenu) {

            mainMenu();
            String userInput = scannerObj.nextLine();

            switch (userInput) {
                case "A":
                case "a":
                    addNewDriver();
                    break;
                case "D":
                case "d":
                    deleteExistingDriver();
                    break;
                case "C":
                case "c":
                    changeExistingTeam();
                    break;
                case "S":
                case "s":
                    displayStatisticsOfDriver();
                    break;
                case "T":
                case "t":
                    displayDriverTable();
                    break;
                case "R":
                case "r":
                    addNewRace();
                    break;
                case "G":
                case "g":
                    DisplayGUI guiComponents = new DisplayGUI();
                    guiComponents.homeScreen();
                    break;
                case "Q":
                case "q":
                    championshipManager.writeFile();
                    consoleMenu = false;
                    System.out.println("THANK YOU FOR CONSIDERATION, VISIT AGAIN :-)");
                    break;
                default:
                    System.out.println("PLEASE ENTER A VALID LETTER TO CONTINUE!!!");
                    break;
            }
        }

    }

    private static void mainMenu(){

        System.out.println( "Main Menu : \n" +
                "Please select the option : \n" +
                "\"A\" - Register a new driver\n" +
                "\"D\" - Delete an existing driver\n" +
                "\"C\" - Change team of a driver\n" +
                "\"S\" - Display Statistics of a driver\n" +
                "\"T\" - Display Driver table\n" +
                "\"R\" - Add a race info\n" +
                "\"G\" - Visualize GUI\n" +
                "\"Q\" - Quit Main Menu");
        System.out.print("CHOICE : ");
    }

    private static void addNewDriver() {

        System.out.println("\nENTER THE FOLLOWING INFORMATIONS ->");
        System.out.print("Name : ");
        String nameOfDriver = scannerObj.nextLine();

        System.out.print("Location :  ");
        String locationOfDriver = scannerObj.nextLine();

        System.out.print("Constructor Team :  ");
        String constructorTeamName = scannerObj.nextLine();

        int age = 0, mobileNo = 0;

        while(true){
            try {
                System.out.print("Age : ");
                age =  Integer.parseInt(scannerObj.next());    //check if age is only a input
                break;
            } catch(NumberFormatException e) {
                System.out.println("    [ERROR] Wrong Input type, please enter INTEGERS");
            }
        }

        while(true){
            try {
                System.out.print("Mobile No : ");
                mobileNo =  Integer.parseInt(scannerObj.next());  //check if mobile no = 10 digits
                if(((String.valueOf(mobileNo)).length() == 9)){
                    break;
                }else {
                    System.out.println("    [ERROR] Mobile number should be 10 digits");
                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("    [ERROR] Wrong Input type, please enter INTEGERS");
            }
        }

        scannerObj.nextLine();
        Formula1Driver driver = new Formula1Driver(nameOfDriver, locationOfDriver,constructorTeamName,new Statistics(age,mobileNo));
        championshipManager.addNewDriver(driver);

    }

    private static void deleteExistingDriver() {

        System.out.print("\nENTER THE NAME : ");
        String nameOfDriver = scannerObj.nextLine();

        championshipManager.deleteExistingDriver(nameOfDriver);

    }

    private static void changeExistingTeam(){

        System.out.println("\nENTER THE FOLLOWING INFORMATIONS ->");
        System.out.print("Name : ");
        String nameOfDriver = scannerObj.nextLine();

        System.out.print("New Constructor Team :  ");
        String constructorTeamName = scannerObj.nextLine();

        championshipManager.changeExistingTeam(nameOfDriver,constructorTeamName);

    }

    private static void displayStatisticsOfDriver(){

        System.out.print("\nENTER THE NAME : ");
        String nameOfDriver = scannerObj.nextLine();

        championshipManager.displayStatisticsOfDriver(nameOfDriver);
    }

    private static void addNewRace(){
        int size = 10;
        ArrayList<String> tempRaceList = new ArrayList<String>(size);
        System.out.println("\nENTER THE FOLLOWING INFORMATIONS TO ADD A MATCH ->");
        System.out.println("Date of the match ->  ");
        int day = 0,month = 0;


        while(true){
            try {
                System.out.print("Day <1-31>: ");
                day =  Integer.parseInt(scannerObj.next());   //check if day in range 1:31
                if(day > 0 && day <= 31){
                    break;
                }else {
                    System.out.println("    [ERROR] Enter day between 1 - 31");
                    continue;
                }

            } catch(NumberFormatException e) {
                System.out.println("    [ERROR] Wrong Input type, please enter INTEGERS\n");
            }
        }

        while(true){
            try {
                System.out.print("Month <1-12>: ");
                month =  Integer.parseInt(scannerObj.next());   //check if month in range 1:12
                if(month > 0 && month <= 31){
                    break;
                }else {
                    System.out.println("    [ERROR] Enter month between 1 - 12");
                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("    [ERROR] Wrong Input type, please enter INTEGERS");
            }
        }
        scannerObj.nextLine();
        System.out.println("\nDrivers' Positions in the match - >");

        for(int i=0; i < size; i++) {
//checks if same driver added to different positions
            System.out.print("Position " + (i+1) + ":");
            String position = scannerObj.nextLine();
            if(i==0){
                tempRaceList.add(position);
            }else{
                while(true){
                    if(!tempRaceList.contains(position)){
                            tempRaceList.add(position);
                            break;
                    }
                    else {
                        System.out.println("    [ERROR] Driver already positioned");
                        System.out.print("Position " + (i+1) + ":");
                        position = scannerObj.nextLine();
                        continue;
                    }

                    }
                }
            }

        Race race = new Race(new Date(day,month,2021),tempRaceList.get(0),tempRaceList.get(1),tempRaceList.get(2),tempRaceList.get(3),tempRaceList.get(4),
                            tempRaceList.get(5),tempRaceList.get(6),tempRaceList.get(7),tempRaceList.get(8),tempRaceList.get(9));

        championshipManager.addNewRace(race,tempRaceList);

    }

    private static void displayDriverTable() {
        championshipManager.displayDriverTable();
    }

}
