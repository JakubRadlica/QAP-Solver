package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Genotype;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GreedyAlgorithm {

    private Context context;

    public GreedyAlgorithm(Context context) {
        this.context = context;
    }

    public Genotype run(){
        Random random = new Random();

        int genotypeSize = context.getContextSize();
        int[] genotype = new int[genotypeSize];
        genotype[0] = 1;

        for(int i=0; i<genotypeSize-1; i++){
            genotype[i+1] = getNextMinGenotype(genotype, i, context);
        }

        return new Genotype(genotype, context);
    }

    public int getNextMinGenotype(int[] genotype, int current, Context context){
        List<Integer> randomGenotype = IntStream.range(1, context.getContextSize()+1).boxed().collect(Collectors.toList());
        for(int i=0; i<current+1; i++){
            int j = randomGenotype.indexOf(genotype[i]);
            randomGenotype.remove(randomGenotype.indexOf(genotype[i]));
        }

        int best = randomGenotype.get(0);
        int bestV = distanceBetweenLoc(current, current+1)*flowBeteenFacilities(genotype[current], randomGenotype.get(0));

        for(int i=0; i<randomGenotype.size(); i++){
            int tempV = distanceBetweenLoc(current, current+1)*flowBeteenFacilities(genotype[current], randomGenotype.get(i));
            if(tempV<bestV){
                best = randomGenotype.get(i);
                bestV = tempV;
            }
        }

        return best;
    }

    private int distanceBetweenLoc(int loc1, int loc2) {
        return this.context.getDistance()[loc1][loc2];
    }

    private int flowBeteenFacilities(int fac1, int fac2) {
        return this.context.getFlow()[fac1-1][fac2-1];
    }
}
