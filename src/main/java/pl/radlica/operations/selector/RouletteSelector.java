package pl.radlica.operations.selector;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import pl.radlica.model.Genotype;
import pl.radlica.model.Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RouletteSelector implements ISelector {

    @Override
    public Genotype select(Population population) {

        List<Genotype> genotypes = population.getGenotypes();
        RangeMap<Integer, Genotype> roulette = TreeRangeMap.create();

        int sum = 0;
        for (Genotype g : genotypes) {
            sum += g.getFittnes();
        }

        int prSum = 0;
        for (Genotype g : genotypes) {
            int pr = sum - g.getFittnes();
            roulette.put(Range.closed(prSum, prSum+pr), g);
            prSum += pr;
        }
        Random random = new Random();


        return roulette.get(random.nextInt(prSum));
    }

    @Override
    public String getSelectorName() {
        return "Roulette selector";
    }

}
