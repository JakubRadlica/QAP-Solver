package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Genotype;
import pl.radlica.model.Population;

public class RandomAlgorithm {

    private Context context;
    private int populationSize;

    public RandomAlgorithm(Context context){
        this.context=context;
    }

    public RandomAlgorithm(Context context, int populationSize){
        this.context=context;
        this.populationSize=populationSize;
    }

    public Genotype run(){
        Population.PopulationBuilder populationBuilder =
                new Population.PopulationBuilder()
                .populationSize(populationSize)
                .genotypeSize(context.getContextSize());

        Population population = populationBuilder.buildInitPopulation(context);

        return population.getBestGenotype();
    }
}
