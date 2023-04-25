import java.io.Serializable;
import java.util.Objects;

public class Race implements Serializable {

    //serial version UID
    private static final long serialVersionUID=1L;

    private Date date;
    private String firstPosition;
    private String secondPosition;
    private String thirdPosition;
    private String fourthPosition;
    private String fifthPosition;
    private String sixthPosition;
    private String seventhPosition;
    private String eighthPosition;
    private String ninthPosition;
    private String tenthPosition;

    public Race(){

    }

    public Race(Date date, String firstPosition, String secondPosition, String thirdPosition, String fourthPosition, String fifthPosition,
                String sixthPosition, String seventhPosition, String eighthPosition, String ninthPosition, String tenthPosition) {
        this.date = date;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
        this.thirdPosition = thirdPosition;
        this.fourthPosition = fourthPosition;
        this.fifthPosition = fifthPosition;
        this.sixthPosition = sixthPosition;
        this.seventhPosition = seventhPosition;
        this.eighthPosition = eighthPosition;
        this.ninthPosition = ninthPosition;
        this.tenthPosition = tenthPosition;
    }

    public String getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(String firstPosition) {
        this.firstPosition = firstPosition;
    }

    public String getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(String secondPosition) {
        this.secondPosition = secondPosition;
    }

    public String getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(String thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public String getFourthPosition() {
        return fourthPosition;
    }

    public void setFourthPosition(String fourthPosition) {
        this.fourthPosition = fourthPosition;
    }

    public String getFifthPosition() {
        return fifthPosition;
    }

    public void setFifthPosition(String fifthPosition) {
        this.fifthPosition = fifthPosition;
    }

    public String getSixthPosition() {
        return sixthPosition;
    }

    public void setSixthPosition(String sixthPosition) {
        this.sixthPosition = sixthPosition;
    }

    public String getSeventhPosition() {
        return seventhPosition;
    }

    public void setSeventhPosition(String seventhPosition) {
        this.seventhPosition = seventhPosition;
    }

    public String getEighthPosition() {
        return eighthPosition;
    }

    public void setEighthPosition(String eighthPosition) {
        this.eighthPosition = eighthPosition;
    }

    public String getNinthPosition() {
        return ninthPosition;
    }

    public void setNinthPosition(String ninthPosition) {
        this.ninthPosition = ninthPosition;
    }

    public String getTenthPosition() {
        return tenthPosition;
    }

    public void setTenthPosition(String tenthPosition) {
        this.tenthPosition = tenthPosition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return Objects.equals(getDate(), race.getDate()) &&
                Objects.equals(getFirstPosition(), race.getFirstPosition()) &&
                Objects.equals(getSecondPosition(), race.getSecondPosition()) &&
                Objects.equals(getThirdPosition(), race.getThirdPosition()) &&
                Objects.equals(getFourthPosition(), race.getFourthPosition()) &&
                Objects.equals(getFifthPosition(), race.getFifthPosition()) &&
                Objects.equals(getSixthPosition(), race.getSixthPosition()) &&
                Objects.equals(getSeventhPosition(), race.getSeventhPosition()) &&
                Objects.equals(getEighthPosition(), race.getEighthPosition()) &&
                Objects.equals(getNinthPosition(), race.getNinthPosition()) &&
                Objects.equals(getTenthPosition(), race.getTenthPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(),
                getFirstPosition(),
                getSecondPosition(),
                getThirdPosition(),
                getFourthPosition(),
                getFifthPosition(),
                getSixthPosition(),
                getSeventhPosition(),
                getEighthPosition(),
                getNinthPosition(),
                getTenthPosition());
    }

    @Override
    public String toString() {
        return "Race{" +
                "date=" + date +
                ", firstPosition='" + firstPosition + '\'' +
                ", secondPosition='" + secondPosition + '\'' +
                ", thirdPosition='" + thirdPosition + '\'' +
                ", fourthPosition='" + fourthPosition + '\'' +
                ", fifthPosition='" + fifthPosition + '\'' +
                ", sixthPosition='" + sixthPosition + '\'' +
                ", seventhPosition='" + seventhPosition + '\'' +
                ", eighthPosition='" + eighthPosition + '\'' +
                ", ninthPosition='" + ninthPosition + '\'' +
                ", tenthPosition='" + tenthPosition + '\'' +
                '}';
    }
}
