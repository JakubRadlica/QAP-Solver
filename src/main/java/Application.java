import pl.radlica.GeneticAlgorithm;
import pl.radlica.io.ContextFile;
import pl.radlica.io.ContextReader;
import pl.radlica.io.Exception.ContextFileException;
import pl.radlica.model.Context;
import pl.radlica.operations.crossover.SimpleSwapCrossover;
import pl.radlica.operations.mutator.RandomSwapMutator;
import pl.radlica.operations.selector.TournamentSelector;

public class Application {

    public static void main(String[] args) throws ContextFileException {

        Context context = new ContextReader().loadContextFromFile(ContextFile.QNP_12);

        GeneticAlgorithm geneticAlgorithm =
                new GeneticAlgorithm.GeneticAlgolrithmBuilder()
                        .context(context)
                        .selector(new TournamentSelector(20))
                        .mutator(new RandomSwapMutator())
                        .crossover(new SimpleSwapCrossover())
                        .populationsNumber(100)
                        .crossoverProbability(0.5)
                        .mutateProbability(0.00)
                        .build();

        geneticAlgorithm.run();

    }
}
