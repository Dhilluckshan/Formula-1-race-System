import java.io.Serializable;
import java.util.Objects;

public abstract class Driver implements Serializable {

    private String nameOfDriver;
    private String locationOfDriver;
    private String constructorTeamName;
    private Statistics statistics;

    //serial version UID
    private static final long serialVersionUID=1L;

    public Driver(){

    }

    /**
     * This class contains the basic information of the driver
     * @param nameOfDriver - Driver's name
     * @param locationOfDriver - Driver's location
     * @param constructorTeamName - Team sponsoring the driver
     * @param statistics - Age / Mobile No
     */
    public Driver(String nameOfDriver, String locationOfDriver, String constructorTeamName, Statistics statistics) {
        this.nameOfDriver = nameOfDriver;
        this.locationOfDriver = locationOfDriver;
        this.constructorTeamName = constructorTeamName;
        this.statistics = statistics;
    }


    public String getNameOfDriver() {
        return nameOfDriver;
    }

    public void setNameOfDriver(String nameOfDriver) {
        this.nameOfDriver = nameOfDriver;
    }

    public String getLocationOfDriver() {
        return locationOfDriver;
    }

    public void setLocationOfDriver(String locationOfDriver) {
        this.locationOfDriver = locationOfDriver;
    }

    public String getConstructorTeamName() {
        return constructorTeamName;
    }

    public void setConstructorTeamName(String constructorTeamName) {
        this.constructorTeamName = constructorTeamName;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Driver)) return false;
        Driver driver = (Driver) obj;
        return getNameOfDriver().equals(driver.getNameOfDriver()) && 
               getLocationOfDriver().equals(driver.getLocationOfDriver()) && 
               getConstructorTeamName().equals(driver.getConstructorTeamName()) &&
               Objects.equals(getStatistics(), driver.getStatistics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfDriver(), getLocationOfDriver(), getConstructorTeamName(), getStatistics());
    }

    @Override
    public String toString() {
        return "Driver's details:" +
                "\n    Name : '" + nameOfDriver +
                "'\n    Location : '" + locationOfDriver +
                "'\n    Constructor Name : '" + constructorTeamName +
                "'\n    Statistics : " + statistics;
    }

}