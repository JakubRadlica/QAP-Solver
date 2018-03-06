package pl.radlica.operations.mutator;

import pl.radlica.model.Genotype;

import java.util.Random;

public class RandomSwapMutator implements IMutator {

    @Override
    public void mutate(Genotype genotype) {
        Random random = new Random();
        int genoLength = genotype.getGenotype().length;
        int indexOfFirstGene = random.nextInt(genoLength);
        int indexOfSecondGene = random.nextInt(genoLength);
        int temp = genotype.getGenotype()[indexOfFirstGene];
        genotype.getGenotype()[indexOfFirstGene] = genotype.getGenotype()[indexOfSecondGene];
        genotype.getGenotype()[indexOfSecondGene] = temp;
        genotype.evaluate();
    }

    @Override
    public void mutateSingleGeno(Genotype genotype, int geno) {
        Random random = new Random();
        int indexOfSecondGene = random.nextInt(genotype.getGenotype().length);
        int temp = genotype.getGenotype()[geno];
        genotype.getGenotype()[geno] = genotype.getGenotype()[indexOfSecondGene];
        genotype.getGenotype()[indexOfSecondGene] = temp;
        genotype.evaluate();
    }
}
