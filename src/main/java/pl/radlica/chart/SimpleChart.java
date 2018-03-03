package pl.radlica.chart;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;
import pl.radlica.model.Population;
import pl.radlica.operations.selector.ISelector;

import java.util.List;
import java.util.stream.IntStream;

public class SimpleChart implements IChart {

    String frameTitle = "XChart";

    public SimpleChart(){

    }
    public SimpleChart(String title){
        this.frameTitle=title;
    }

    @Override
    public void draw(List<Population> populationList, ISelector selector, double pm, double px, int generations, int genotypesInPopulation) {
        StringBuilder sb = new StringBuilder("Genetic Algorithm | ");
        sb.append(selector.toString()+", ");
        sb.append("Px="+px+", Pm="+pm+" ");
        sb.append("Generations: "+generations+", Population size: "+genotypesInPopulation);
        String title = sb.toString();
        int[] populations = IntStream.range(1, populationList.size()+1).toArray();
        int[] avgFitness = populationList.stream().mapToInt(i-> i.getAvgFittnes()).toArray();
        int[] bestFitness = populationList.stream().mapToInt(i-> i.getBestFittnes()).toArray();
        int[] worstFitness = populationList.stream().mapToInt(i-> i.getWorstFittnes()).toArray();
        final XYChart chart = new XYChartBuilder().width(1200).height(600).theme(Styler.ChartTheme.GGPlot2).title( title).xAxisTitle("Generation number").yAxisTitle("Fitness").build();

        int j=0;
        for(int i: bestFitness){
            System.out.println((j++)+" "+i);
        }
        chart.addSeries("Average fitnesses", populations, avgFitness);
        chart.addSeries("Best fitnesses", bestFitness);
        chart.addSeries("Worst fitnesses", worstFitness);

        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        sw.displayChart(frameTitle);
//        sw.displayChart();
    }

}
