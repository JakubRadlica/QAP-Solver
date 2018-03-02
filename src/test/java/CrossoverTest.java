import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.radlica.io.ContextFile;
import pl.radlica.io.ContextReader;
import pl.radlica.io.Exception.ContextFileException;
import pl.radlica.model.Context;
import pl.radlica.model.Genotype;
import pl.radlica.operations.crossover.ICrossover;
import pl.radlica.operations.crossover.SimpleSwapCrossover;

import java.util.stream.IntStream;

public class CrossoverTest {


    @Test
    @DisplayName("#1 SimpleSwapCrossover")
    public void simpleSwapCrossoverTest1() throws ContextFileException {

        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_12);

        Genotype genotype = new Genotype(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, ctx);
        Genotype genotype2 = new Genotype(new int[]{1,2,12,11,3,4,5,6,7,8,9,10}, ctx);

        ICrossover crossover = new SimpleSwapCrossover();
        crossover.crossover(genotype, genotype2);

        Assertions.assertEquals(eachElemUnique(genotype.getGenotype()), true);

    }

    @Test
    @DisplayName("#2 SimpleSwapCrossover")
    public void simpleSwapCrossoverTest2() throws ContextFileException {

        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_12);

        Genotype genotype = new Genotype(new int[]{1,8,12,9,5,6,7,2,4,10,11,3}, ctx);
        Genotype genotype2 = new Genotype(new int[]{11,12,3,1,2,4,6,5,7,8,9,10}, ctx);

        ICrossover crossover = new SimpleSwapCrossover();
        crossover.crossover(genotype, genotype2);

        Assertions.assertEquals(eachElemUnique(genotype.getGenotype()), true);

    }

    private boolean eachElemUnique(int[] array){
        return IntStream.of(array).distinct().toArray().length==array.length;
    }
}
