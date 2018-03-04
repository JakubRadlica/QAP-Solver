
import pl.radlica.GeneticAlgorithm;
import pl.radlica.chart.SimpleChart;
import pl.radlica.io.ContextFile;
import pl.radlica.io.ContextReader;
import pl.radlica.io.Exception.ContextFileException;
import pl.radlica.model.Context;
import pl.radlica.model.Genotype;
import pl.radlica.operations.crossover.SimpleSwapCrossover;
import pl.radlica.operations.mutator.RandomSwapMutator;
import pl.radlica.operations.selector.RandomSelector;
import pl.radlica.operations.selector.RouletteSelector;
import pl.radlica.operations.selector.TournamentSelector;

public class Application {

    public static void main(String[] args) throws ContextFileException {

        Context context = new ContextReader().loadContextFromFile(ContextFile.QNP_12);

        GeneticAlgorithm geneticAlgorithm =
                new GeneticAlgorithm.GeneticAlgolrithmBuilder()
                        .context(context)
//                        .selector(new RouletteSelector())
                        .selector(new TournamentSelector(5))
//                        .selector(new RandomSelector())
                        .mutator(new RandomSwapMutator())
                        .crossover(new SimpleSwapCrossover())
                        .populationsNumber(100)
                        .generationsNumber(100)
                        .crossoverProbability(0.8)
                        .mutateProbability(0.3)
                        .build();
        geneticAlgorithm.setChartInterpreter(new SimpleChart());
        Genotype bestGenotype = geneticAlgorithm.run();
        System.out.println("Najlepszy genotyp: " + bestGenotype.toString());

    }
}
