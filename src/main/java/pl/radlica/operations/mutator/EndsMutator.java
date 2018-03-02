package pl.radlica.operations.mutator;

import pl.radlica.model.Genotype;

public class EndsMutator implements IMutator {

    @Override
    public void mutate(Genotype genotype) {
        if(genotype.getGenotype().length>2){
            int first = genotype.getGenotype()[0];
            int last = genotype.getGenotype()[genotype.getGenotype().length-1];
            int temp = first;
            genotype.getGenotype()[0] = last;
            genotype.getGenotype()[genotype.getGenotype().length-1] = temp;
        }
    }
}
