package pl.radlica.operations.selector;

import pl.radlica.model.Genotype;
import pl.radlica.model.Population;

import java.util.Random;

public class RandomSelector implements ISelector {

    @Override
    public Genotype select(Population population) {
        Random random = new Random();
        Genotype genotype = population.getGenotypes().get(random.nextInt(population.getGenotypes().size()));
        return genotype;
    }

    public String toString(){
        return "Random select";
    }
}
