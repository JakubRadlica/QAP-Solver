package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Population;
import pl.radlica.operations.mutator.IMutator;
import pl.radlica.operations.selector.ISelector;
import pl.radlica.operations.selector.RandomSelector;

import java.util.List;

public class GeneticAlgorithm {

    private List<Population> populations;
    private Context context;
    private ISelector selector;
    private IMutator mutator;

    private GeneticAlgorithm(Context context, ISelector selector, IMutator mutator){
        this.context = context;
        this.selector = selector;
        this.mutator = mutator;
    }

    public void run(){

    }


    public static class GeneticAlgolrithmBuilder {

        Context context;
        ISelector selector;
        IMutator mutator;

        public GeneticAlgolrithmBuilder(){
            selector = new RandomSelector();
        }

        public GeneticAlgolrithmBuilder context(Context context){
            this.context=context;
            return this;
        }

        public GeneticAlgolrithmBuilder selector(ISelector selector){
            selector = selector;
            return this;
        }

        public GeneticAlgolrithmBuilder mutator(IMutator mutator) {
            this.mutator=mutator;
            return this;
        }

    }
}
