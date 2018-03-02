package pl.radlica.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Genotype {

    protected int genotype[];
    protected int fittnes;

    public Genotype(int[] genotype){
        this.genotype=genotype;
    }

    public Genotype(Genotype genotype){
        this.genotype=genotype.genotype;
    }


    public static class GenotypeBuilder{
        private int genotypeSize;

        public GenotypeBuilder(){

        }
        public GenotypeBuilder(int genotypeSize){
            this.genotypeSize=genotypeSize;
        }

        public GenotypeBuilder genotypeSize(int genotypeSize){
            this.genotypeSize=genotypeSize;
            return this;
        }

        public Genotype buildRandomGenotype (){
            List<Integer> randomGenotype = IntStream.range(1, genotypeSize).boxed().collect(Collectors.toList());
            Collections.shuffle(randomGenotype);
            int[] genotype = randomGenotype.stream().mapToInt(i -> i).toArray();
            return new Genotype(genotype);
        }
    }
}

