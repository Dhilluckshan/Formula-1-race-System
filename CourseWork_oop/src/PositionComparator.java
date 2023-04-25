import java.util.Comparator;

public class PositionComparator implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver driver1, Formula1Driver driver2) {
        if (driver1.getNoOfFirstPosition() > driver2.getNoOfFirstPosition()){
            return -1;
        }
        else if (driver1.getNoOfFirstPosition() < driver2.getNoOfFirstPosition()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
