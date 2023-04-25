import java.util.Objects;
import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {

    private int noOfFirstPosition;
    private int noOfSecondPosition;
    private int noOfThirdPosition;
    private int totalPoint;
    private int noOfParticipatedGames;

    //serial version UID
    private static final long serialVersionUID=1L;

    public Formula1Driver(){

    }

    public Formula1Driver(String nameOfDriver, String locationOfDriver, String constructorTeamName, Statistics statistics) {
        super(nameOfDriver, locationOfDriver, constructorTeamName, statistics);
    }

    /**
     * This class contains the drivers match statistics
     * @param noOfFirstPosition how many 1st positions
     * @param noOfSecondPosition how many 2nd positions
     * @param noOfThirdPosition how many 3rd positions
     * @param totalPoint how many points
     * @param noOfParticipatedGames how many games
     */
    public Formula1Driver(String nameOfDriver, String locationOfDriver, String constructorTeamName, Statistics statistics,
                          int noOfFirstPosition, int noOfSecondPosition, int noOfThirdPosition, int totalPoint, int noOfParticipatedGames) {
        super(nameOfDriver, locationOfDriver, constructorTeamName, statistics);
        this.noOfFirstPosition = noOfFirstPosition;
        this.noOfSecondPosition = noOfSecondPosition;
        this.noOfThirdPosition = noOfThirdPosition;
        this.totalPoint = totalPoint;
        this.noOfParticipatedGames = noOfParticipatedGames;
    }


    public int getNoOfFirstPosition() {
        return noOfFirstPosition;
    }

    public void setNoOfFirstPosition(int noOfFirstPosition) {
        this.noOfFirstPosition = noOfFirstPosition;
    }

    public int getNoOfSecondPosition() {
        return noOfSecondPosition;
    }

    public void setNoOfSecondPosition(int noOfSecondPosition) {
        this.noOfSecondPosition = noOfSecondPosition;
    }

    public int getNoOfThirdPosition() {
        return noOfThirdPosition;
    }

    public void setNoOfThirdPosition(int noOfThirdPosition) {
        this.noOfThirdPosition = noOfThirdPosition;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getNoOfParticipatedGames() {
        return noOfParticipatedGames;
    }

    public void setNoOfParticipatedGames(int noOfParticipatedGames) {
        this.noOfParticipatedGames = noOfParticipatedGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formula1Driver)) return false;
        if (!super.equals(o)) return false;
        Formula1Driver that = (Formula1Driver) o;
        return getNoOfFirstPosition() == that.getNoOfFirstPosition() &&
               getNoOfSecondPosition() == that.getNoOfSecondPosition() &&
               getNoOfThirdPosition() == that.getNoOfThirdPosition() &&
               getTotalPoint() == that.getTotalPoint() &&
               getNoOfParticipatedGames() == that.getNoOfParticipatedGames();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNoOfFirstPosition(), getNoOfSecondPosition(), getNoOfThirdPosition(),
                            getTotalPoint(), getNoOfParticipatedGames());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n    Total First Position : " + noOfFirstPosition +
                "\n    Total Second Position : " + noOfSecondPosition +
                "\n    Total Third Position : " + noOfThirdPosition +
                "\n    Total Points : " + totalPoint +
                "\n    Participated Games : " + noOfParticipatedGames;
    }
}
