import java.io.Serializable;

public class Statistics implements Serializable {

    private int age;
    private int mobileNo;

    //serial version UID
    private static final long serialVersionUID=1L;

    /**
     * This class contains various statistics of the driver
     * @param age driver's age
     * @param mobileNo driver's mobile no
     */
    public Statistics(int age, int mobileNo) {
        this.age = age;
        this.mobileNo = mobileNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "\n       Age : " + age +
               "\n       Mobile : " + mobileNo;
    }
}
