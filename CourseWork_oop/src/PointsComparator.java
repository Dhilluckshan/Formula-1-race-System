import java.util.Comparator;

public class PointsComparator implements Comparator<Formula1Driver> {


    @Override
    public int compare(Formula1Driver driver_1, Formula1Driver driver_2) {

        if(driver_1.getTotalPoint() > driver_2.getTotalPoint()){
            return -1;
        }
        else if(driver_1.getTotalPoint() < driver_2.getTotalPoint()){
            return 1;
        }
        else if(driver_1.getNoOfFirstPosition() > driver_2.getNoOfFirstPosition()){
            return -1;
        }
        else if(driver_1.getNoOfFirstPosition() < driver_2.getNoOfFirstPosition()){
            return 1;
        }
        else {
            return 0;
        }
        }

}
