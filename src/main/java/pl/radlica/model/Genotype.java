package pl.radlica.model;

import lombok.Getter;
import lombok.Setter;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Genotype {

    @Getter @Setter private int genotype[];
    @Getter @Setter private int fittnes;
    @Getter @Setter private Context context;

    public Genotype(int[] genotype, Context context){
        this.genotype = genotype;
        this.context=context;
        this.fittnes = evaluate();
    }

    public Genotype(Genotype genotype){
        this(genotype.genotype, genotype.context);
    }

    private int evaluate() {
        int fit = 0;

            for (int i = 0; i < genotype.length; i++) {
                for (int j = 0; j < genotype.length; j++) {
                    try {
                    int distance = context.getDistance()[i][j];
                    int facility1 = genotype[i] - 1, facility2 = genotype[j] - 1;
                    int flow = context.getFlow()[genotype[i] - 1][genotype[j] - 1];
                    fit += context.getDistance()[i][j] * context.getFlow()[genotype[i] - 1][genotype[j] - 1];

                } catch (Exception exception){
                        System.out.println("ASD");
                        int distance = context.getDistance()[i][j];
                        int facility1 = genotype[i] - 1, facility2 = genotype[j] - 1;
                        int flow = context.getFlow()[genotype[i] - 1][genotype[j] - 1];
                    System.out.println("ASD");
                } }
            }
        return fit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FIT: "+fittnes+"  [");
        for(int i: genotype){
            stringBuilder.append(i+",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static class GenotypeBuilder{
        private int genotypeSize;

        public GenotypeBuilder(){

        }
        public GenotypeBuilder(int genotypeSize){
            this.genotypeSize=genotypeSize;
        }

        public GenotypeBuilder genotypeSize(int genotypeSize){
            this.genotypeSize=genotypeSize;
            return this;
        }

        public Genotype buildRandomGenotype (Context context){
            List<Integer> randomGenotype = IntStream.range(1, genotypeSize+1).boxed().collect(Collectors.toList());
            Collections.shuffle(randomGenotype);
            int[] genotype = randomGenotype.stream().mapToInt(i -> i).toArray();
            return new Genotype(genotype, context);
        }
    }
}

