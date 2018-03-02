package pl.radlica.chart;

import pl.radlica.model.Population;
import pl.radlica.operations.selector.ISelector;

import java.util.List;

public interface IChart {
    void draw(List<Population> populationList, ISelector selector, double pm, double px, int generations, int genotypesInPopulation);
}
