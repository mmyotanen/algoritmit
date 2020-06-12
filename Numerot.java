
import java.util.stream.IntStream;



public class Numerot {
    int summa(int x) {
        int[] intTab = String.valueOf(x).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.of(intTab).sum();
        return sum;
        
    }
}
