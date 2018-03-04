import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.radlica.io.ContextFile;
import pl.radlica.io.ContextReader;
import pl.radlica.io.Exception.ContextFileException;
import pl.radlica.model.Context;
import pl.radlica.model.Genotype;

public class GenotypeTest {

    @Test
    @DisplayName("#1 Genotype test, calculate fitness")
    public void genotypeTest1(){
        int[][] distanceMatrix = {
                {0,22,53,53},
                {22,0,40,62},
                {53,40,0,55},
                {53,62,55,0}
        };

        int[][] flowMatrix = {
                {0,3,0,2},
                {3,0,0,1},
                {0,0,0,4},
                {2,1,4,0}
        };
        Context context = new Context(4, distanceMatrix, flowMatrix);
        Genotype genotype = new Genotype(new int[]{1,2,3,4}, context);

        Assertions.assertEquals(908, genotype.getFittnes());
    }

    @Test
    @DisplayName("#2 Genotype test, calculate fitness")
    public void genotypeTest2() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_12);
        Genotype genotype = new Genotype(new int[]{3,10,11,2,12,5,6,7,8,1,4,9}, ctx);
        Assertions.assertEquals(1652, genotype.getFittnes());
    }

    @Test
    @DisplayName("#3 Genotype test, calculate fitness")
    public void genotypeTest3() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_14);
        Genotype genotype = new Genotype(new int[]{8,13,10,5,12,11,2,14,3,6,7,1,9,4}, ctx);
        Assertions.assertEquals(2724, genotype.getFittnes());
    }

    @Test
    @DisplayName("#4 Genotype test, calculate fitness")
    public void genotypeTest4() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_16);
        Genotype genotype = new Genotype(new int[]{9,4,16,1,7,8,6,14,15,11,12,10,5,3,2,13}, ctx);
        Assertions.assertEquals(3720, genotype.getFittnes());
    }

    @Test
    @DisplayName("#5 Genotype test, calculate fitness")
    public void genotypeTest5() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_18);
        Genotype genotype = new Genotype(new int[]{8,15,16,6,7,18,14,11,1,10,12,5,3,13,2,17,9,4}, ctx);
        Assertions.assertEquals(5358, genotype.getFittnes());
    }

    @Test
    @DisplayName("#6 Genotype test, calculate fitness")
    public void genotypeTest6() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_20);
        Genotype genotype = new Genotype(new int[]{8,15,16,14,19,6,7,17,1,12,10,11,5,20,2,3,4,9,18,13}, ctx);
        Assertions.assertEquals(6922, genotype.getFittnes());
    }

    @Test
    @DisplayName("#7 Genotype test, constructor")
    public void genotypeTest7() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_20);
        Genotype genotype = new Genotype(new int[]{8,15,16,14,19,6,7,17,1,12,10,11,5,20,2,3,4,9,18,13}, ctx);
        Assertions.assertEquals(genotype.getFittnes(), new Genotype(genotype).getFittnes());
    }

    @Test
    @DisplayName("#8 Genotype test, constructor")
    public void genotypeTest8() throws ContextFileException {
        ContextReader contextReader = new ContextReader();
        Context ctx = contextReader.loadContextFromFile(ContextFile.QNP_18);
        Genotype genotype = new Genotype(new int[]{8,15,16,14,6,7,17,1,12,10,11,5,2,3,4,9,18,13}, ctx);
        Genotype newGenotype = new Genotype(genotype);
        Genotype newGenotype2 = new Genotype(newGenotype);
        Assertions.assertEquals(genotype.getFittnes(), newGenotype2.getFittnes());

    }
}
