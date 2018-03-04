package pl.radlica.operations.selector;

import pl.radlica.model.Genotype;
import pl.radlica.model.Population;

public interface ISelector {

    Genotype select(Population population);
    String getSelectorName();
}
