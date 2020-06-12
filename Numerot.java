
import java.util.stream.IntStream;


// Laskee annetun positiivisen kokonaisluvun numeroiden summa. Esimerkiksi luvun 4075 numeroiden summa on 4 + 0 + 7 + 5 = 16.
public class Numerot {
    int summa(int x) {
        int[] intTab = String.valueOf(x).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.of(intTab).sum();
        return sum;
        
    }
}
