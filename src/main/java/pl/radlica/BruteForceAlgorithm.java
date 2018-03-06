package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Genotype;

import java.util.Arrays;

public class BruteForceAlgorithm {

    private Context context;
    private Genotype bestGenotype;

    public BruteForceAlgorithm(Context context){
        this.context = context;
    }

    public Genotype run(){
        Genotype.GenotypeBuilder genotypeBuilder = new Genotype.GenotypeBuilder().genotypeSize(context.getContextSize());

        Genotype genotype = genotypeBuilder.buildOrderedGenotype(context);
        bestGenotype = genotype;
        permutate(genotype);

        return bestGenotype;
    }

    private void permutate(Genotype genotype) {
        permutation(new int[]{}, genotype.getGenotype());
    }

    private void permutation(int[] prefix, int[] gen) {
        int n = gen.length;
        if (n == 0) {
            if(new Genotype(prefix, context).getFittnes()<bestGenotype.getFittnes());
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(addIntToArr(prefix, gen[i]), mergeTwoArray(Arrays.copyOfRange(gen,0,i),Arrays.copyOfRange(gen,i+1,n)));
        }
    }

    private int[] mergeTwoArray(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length+arr2.length];

        int i=0;
        for(int j=0; j<arr1.length; j++) {
            newArr[i++]=arr1[j];
        }
        for(int k=0; k<arr2.length; k++) {
            newArr[i++]=arr2[k];
        }
        return newArr;
    }

    private int[] addIntToArr(int[] arr, int number){
        int[] newArr = new int[arr.length+1];

        int i=0;
        for(int j=0; j<arr.length; j++) {
            newArr[i++]=arr[j];
        }
        newArr[i]=number;
        return newArr;
    }
}
