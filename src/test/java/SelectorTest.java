import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.radlica.GreedyAlgorithm;
import pl.radlica.model.Context;
import pl.radlica.model.Genotype;

public class SelectorTest {

    @Test
    @DisplayName("#1 Roulette Selector")
    void testRouletteSelector1() {
        Context context = new Context(4,
                new int[][]{{0,22,53,53},{22,0,40,62},{53,40,0,55},{53,62,55,0}},
                new int[][]{{0,3,0,2},{3,0,0,1},{0,0,0,4},{2,1,4,0}});

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(context);

    }
}
