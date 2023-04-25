import java.util.ArrayList;

public interface ChampionshipManager {

    void addNewDriver(Formula1Driver driver);

    void deleteExistingDriver(String nameOfDriver);

    void changeExistingTeam(String nameOfDriver,String constructorTeamName);

    void displayStatisticsOfDriver(String nameOfDriver);

    void addNewRace(Race race, ArrayList<String> tempRaceList);

    void displayDriverTable();

    void writeFile();

    void readFile();
}
