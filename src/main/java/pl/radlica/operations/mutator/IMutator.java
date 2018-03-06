package pl.radlica.operations.mutator;

import pl.radlica.model.Genotype;

public interface IMutator {

    void mutate(Genotype genotype);
    void mutateSingleGeno(Genotype genotype, int geno);

}
