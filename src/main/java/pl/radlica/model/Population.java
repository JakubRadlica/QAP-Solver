package pl.radlica.model;

import java.util.ArrayList;
import java.util.List;

public class Population {

    protected List<Genotype> genotypes;
    protected int bestFittnes;
    protected int avgFittnes;
    protected int worstFittnes;

    public Population(List<Genotype> genotypes){
        this.genotypes=genotypes;
    }

    public List<Genotype> getGenotypes(){
        return this.genotypes;
    }


    public static class PopulationBuilder{

        private int populationSize;
        private int genotypeSize;

        public PopulationBuilder(){
            this.populationSize = 0;
            this.genotypeSize = 0;
        }

        public void populationSize(int populationSize){
            this.populationSize=populationSize;
        }

        public void genotypeSize(int genotypeSize){
            this.genotypeSize = genotypeSize;
        }

        public Population buildInitPopulation(){
            List<Genotype> genotypes = new ArrayList<Genotype>();
            Genotype.GenotypeBuilder genotypeBuilder = new Genotype.GenotypeBuilder().genotypeSize(genotypeSize);
            for(int i = 0; i<populationSize; i++){
                genotypes.add(genotypeBuilder.buildRandomGenotype());
            }

            return new Population(genotypes);
        }
    }
}
