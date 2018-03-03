package pl.radlica.operations.selector;

import pl.radlica.model.Genotype;
import pl.radlica.model.Population;

import java.util.Random;

public class TournamentSelector implements ISelector {

    private int tour;

    public TournamentSelector(int tour){
        this.tour=tour;
    }

    @Override
    public Genotype select(Population population) {

        int popSize = population.getGenotypes().size();

        Random random = new Random();

        Genotype bestGenotype = population.getGenotypes().get(random.nextInt(popSize));

        for(int i=1; i<tour; i++){
            Genotype genotype = population.getGenotypes().get(random.nextInt(popSize));

            if(bestGenotype.getFittnes()>genotype.getFittnes()){
                bestGenotype = genotype;
            }
        }
        return bestGenotype;
    }

    @Override
    public String toString() {
        return "Tour: "+tour;
    }
}
