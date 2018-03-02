package pl.radlica;

import pl.radlica.model.Context;
import pl.radlica.model.Population;
import pl.radlica.operations.mutator.IMutator;
import pl.radlica.operations.selector.ISelector;
import pl.radlica.operations.selector.RandomSelector;

import java.util.List;

public class GenethicAlghoritm {

    private List<Population> populations;
    private Context context;
    private ISelector selector;
    private IMutator mutator;

    private GenethicAlghoritm(Context context, ISelector selector, IMutator mutator){
        this.context = context;
        this.selector = selector;
        this.mutator = mutator;
    }

    public void run(){

    }


    public static class GenethicAlghortimBuilder{

        Context context;
        ISelector selector;
        IMutator mutator;

        public GenethicAlghortimBuilder(){
            selector = new RandomSelector();
        }

        public  GenethicAlghortimBuilder context(Context context){
            this.context=context;
            return this;
        }

        public GenethicAlghortimBuilder selector(ISelector selector){
            selector = selector;
            return this;
        }

        public  GenethicAlghortimBuilder mutator(IMutator mutator) {
            this.mutator=mutator;
            return this;
        }

    }
}
