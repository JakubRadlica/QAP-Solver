import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.radlica.model.Context;
import pl.radlica.model.Genotype;
import pl.radlica.operations.mutator.EndsMutator;
import pl.radlica.operations.mutator.RandomSwapMutator;


public class MutatorTest {

    @Test
    @DisplayName("#1 Test EndsMutator")
    void testEndMutator1(){
        EndsMutator endsMutator = new EndsMutator();
        Context context = new Context(4, new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}}, new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}});
        Genotype genotype = new Genotype(new int[]{1,3,2,4}, context);
        endsMutator.mutate(genotype);
        Assertions.assertArrayEquals(genotype.getGenotype(), new int[]{4,3,2,1});
    }

    @Test
    @DisplayName("#2 Test EndsMutator")
    void testEndMutator2(){
        EndsMutator endsMutator = new EndsMutator();
        Context context = new Context(4, new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}}, new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}});
        Genotype genotype = new Genotype(new int[]{1,2,3,4}, context);
        endsMutator.mutate(genotype);
        Assertions.assertArrayEquals(genotype.getGenotype(), new int[]{4,2,3,1});
    }

}
