package pl.radlica;

import lombok.Getter;
import pl.radlica.chart.IChart;
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

    @Getter private List<Population> populations = new ArrayList<>();
    private Context context;
    private ISelector selector;
    private IMutator mutator;
    private ICrossover crossover;
    private int populationsNumber;
    private int generationNumber;
    private double crossoverProbability;
    private double mutateProbability;
    private IChart chart;


    private GeneticAlgorithm(Context context, ISelector selector, IMutator mutator, ICrossover crossover,
                             int populationsNumber, int generationNumber, double crossoverProbability, double mutateProbability){
        this.context = context;
        this.selector = selector;
        this.mutator = mutator;
        this.crossover = crossover;
        this.populationsNumber = populationsNumber;
        this.generationNumber = generationNumber;
        this.crossoverProbability = crossoverProbability;
        this.mutateProbability = mutateProbability;

        Population.PopulationBuilder populationBuilder = new Population.PopulationBuilder()
                .genotypeSize(context.getContextSize())
                .populationSize(populationsNumber);

        this.populations.add(populationBuilder.buildInitPopulation(context));
    }

    public void run(){
        Genotype bestGenotype = populations.get(0).getBestGenotype();

        for(int i=0; i<generationNumber; i++){
            Population population = evolve(populations.get(i));
            populations.add(population);
            if(population.getBestGenotype().getFittnes() < bestGenotype.getFittnes()){
                bestGenotype = new Genotype(population.getBestGenotype());
            }
        }
        System.out.println("Best genotype: "+bestGenotype.toString());
        if(chart!=null)
            chart.draw(populations, selector, crossoverProbability, mutateProbability, generationNumber, populationsNumber);
    }

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

    public void setChartInterpreter(IChart chart) {
        this.chart=chart;
    }

    public static class GeneticAlgolrithmBuilder {

        Context context;
        ISelector selector;
        IMutator mutator;
        ICrossover crossover;
        int populationsNumber;
        int generationsNumber;
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

        public GeneticAlgolrithmBuilder generationsNumber(int generationsNumber){
            this.generationsNumber = generationsNumber;
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
            return new GeneticAlgorithm(context, selector, mutator, crossover, populationsNumber, generationsNumber, mutateProbability, crossoverProbability);
        }

    }
}
