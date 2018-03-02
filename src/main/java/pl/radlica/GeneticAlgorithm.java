package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Genotype;
import pl.radlica.model.Population;
import pl.radlica.operations.crossover.ICrossover;
import pl.radlica.operations.mutator.IMutator;
import pl.radlica.operations.selector.ISelector;
import pl.radlica.operations.selector.RandomSelector;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm {

    private List<Population> populations = new ArrayList<>();
    private Context context;
    private ISelector selector;
    private IMutator mutator;
    private ICrossover crossover;
    private int populationsNumber;
    private double crossoverProbability;
    private double mutateProbability;


    private GeneticAlgorithm(Context context, ISelector selector, IMutator mutator, ICrossover crossover,
                             int populationsNumber, double crossoverProbability, double mutateProbability){
        this.context = context;
        this.selector = selector;
        this.mutator = mutator;
        this.crossover = crossover;
        this.populationsNumber = populationsNumber;
        this.crossoverProbability = crossoverProbability;
        this.mutateProbability = mutateProbability;

        Population.PopulationBuilder populationBuilder = new Population.PopulationBuilder()
                .genotypeSize(context.getContextSize())
                .populationSize(populationsNumber);

        this.populations.add(populationBuilder.buildInitPopulation(context));
    }

    public void run(){
        for(int i=0; i<populationsNumber; i++){
            System.out.println(i+","+populations.get(i).getBestFittnes()+","+populations.get(i).getAvgFittnes()+","+populations.get(i).getWorstFittnes());
            Population population = evolve(populations.get(i));
            populations.add(population);
        }
    }

    //dla i do N gdzie N to liczba populacji
    //


    private Population evolve(Population population) {
        ArrayList<Genotype> newGenotypes = new ArrayList<>();

        for(int i=0; i<population.getGenotypes().size(); i++){

            Genotype genotype = new Genotype(selector.select(population));

            if(Math.random()<crossoverProbability){
                crossover.crossover(genotype, new Genotype(selector.select(population)));
            }

            if(Math.random()<mutateProbability){
                mutator.mutate(genotype);
            }

            newGenotypes.add(genotype);
        }
        return new Population(newGenotypes);
    }

    public static class GeneticAlgolrithmBuilder {

        Context context;
        ISelector selector;
        IMutator mutator;
        ICrossover crossover;
        int populationsNumber;
        double mutateProbability;
        double crossoverProbability;

        public GeneticAlgolrithmBuilder(){
            selector = new RandomSelector();
            context = new Context(0,new int[][]{}, new int[][]{});
        }

        public GeneticAlgolrithmBuilder context(Context context){
            this.context=context;
            return this;
        }

        public GeneticAlgolrithmBuilder selector(ISelector selector){
            this.selector = selector;
            return this;
        }

        public GeneticAlgolrithmBuilder mutator(IMutator mutator) {
            this.mutator=mutator;
            return this;
        }

        public GeneticAlgolrithmBuilder crossover(ICrossover crossover) {
            this.crossover=crossover;
            return this;
        }

        public GeneticAlgolrithmBuilder populationsNumber(int populationsNumber) {
            this.populationsNumber = populationsNumber;
            return this;
        }

        public GeneticAlgolrithmBuilder mutateProbability(double mutateProbability){
            this.mutateProbability = mutateProbability;
            return this;
        }

        public GeneticAlgolrithmBuilder crossoverProbability(double crossoverProbability){
            this.crossoverProbability = crossoverProbability;
            return this;
        }

        public GeneticAlgorithm build(){
            return new GeneticAlgorithm(context, selector, mutator, crossover, populationsNumber, mutateProbability, crossoverProbability);
        }

    }
}
