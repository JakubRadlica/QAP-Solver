package pl.radlica.operations.crossover;

import pl.radlica.model.Genotype;

public interface ICrossover {

    void crossover(Genotype genotype, Genotype genotype2);
}
