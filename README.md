# QAP Solver

QAP Solver is a program which using genetic algortihm to solving Quadratic Assignment Problem  
Description of the problem: https://neos-guide.org/content/quadratic-assignment-problem 


#Example

#####Distance Matrix*:

  |  | L0 | L1 | L2 | L3 | L4 | L5 | L6 | L7 | L8 | L9 | L10 | L11 | 
  |:---:|:---:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
  | **L0** | 0 | 1 | 2 | 2 | 3 | 4 | 4 | 5 | 3 | 5 | 6 | 7
  | **L1**  | 1 | 0 | 1 | 1 | 2 | 3 | 3 | 4 | 2 | 4 | 5 | 6
  | **L2**  | 2 | 1 | 0 | 2 | 1 | 2 | 2 | 3 | 1 | 3 | 4 | 5
  | **L3**  | 2 | 1 | 2 | 0 | 1 | 2 | 2 | 3 | 3 | 3 | 4 | 5
  | **L4**  | 3 | 2 | 1 | 1 | 0 | 1 | 1 | 2 | 2 | 2 | 3 | 4
  | **L5**  | 4 | 3 | 2 | 2 | 1 | 0 | 2 | 3 | 3 | 1 | 2 | 3
  | **L6**  | 4 | 3 | 2 | 2 | 1 | 2 | 0 | 1 | 3 | 1 | 2 | 3
  | **L7**  | 5 | 4 | 3 | 3 | 2 | 3 | 1 | 0 | 4 | 2 | 1 | 2
  | **L8**  | 3 | 2 | 1 | 3 | 2 | 3 | 3 | 4 | 0 | 4 | 5 | 6
  | **L9**  | 5 | 4 | 3 | 3 | 2 | 1 | 1 | 2 | 4 | 0 | 1 | 2
  | **L10** | 6 | 5 | 4 | 4 | 3 | 2 | 2 | 1 | 5 | 1 | 0 | 1
  | **L11** | 7 | 6 | 5 | 5 | 4 | 3 | 3 | 2 | 6 | 2 | 1 | 0

 *Distance between locations (L0, L1, L2 ...)
 
 #####Flow Matrix*
 
   |  | F0 | F1 | F2 | F3 | F4 | F5 | F6 | F7 | F8 | F9 | F10 | F11 | 
   |:---:|:---:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
   | **F0** | 0 | 3 | 4 | 6 | 8 | 5 | 6 | 6 | 5 | 1 | 4 | 6
   | **F1**  | 3 | 0 | 6 | 3 | 7 | 9 | 9 | 2 | 2 | 7 | 4 | 7
   | **F2** | 4 | 6 | 0 | 2 | 6 | 4 | 4 | 4 | 2 | 6 | 3 | 6
   | **F3** | 6 | 3 | 2 | 0 | 5 | 5 | 3 | 3 | 9 | 4 | 3 | 6
   | **F4**  | 8 | 7 | 6 | 5 | 0 | 4 | 3 | 4 | 5 | 7 | 6 | 7
   | **F5**  | 5 | 9 | 4 | 5 | 4 | 0 | 8 | 5 | 5 | 5 | 7 | 5
   | **F6**  | 6 | 9 | 4 | 3 | 3 | 8 | 0 | 6 | 8 | 4 | 6 | 7
   | **F7**  | 6 | 2 | 4 | 3 | 4 | 5 | 6 | 0 | 1 | 5 | 5 | 3
   | **F8**  | 5 | 2 | 2 | 9 | 5 | 5 | 8 | 1 | 0 | 4 | 5 | 2
   | **F9**  | 1 | 7 | 6 | 4 | 7 | 5 | 4 | 5 | 4 | 0 | 7 | 7
   | **F10**  | 4 | 4 | 3 | 3 | 6 | 7 | 6 | 5 | 5 | 7 | 0 | 9
   | **F11**  | 6 | 7 | 6 | 6 | 7 | 5 | 7 | 3 | 2 | 7 | 9 | 0
   
   *Flow between facilities (F0, F1, F2 ...)
   
   Program require above data as file in format:
    (had12.dat file in reources)
     
     12
     
     0  1  2  2  3  4  4  5  3  5  6  7
     1  0  1  1  2  3  3  4  2  4  5  6
     2  1  0  2  1  2  2  3  1  3  4  5
     2  1  2  0  1  2  2  3  3  3  4  5
     3  2  1  1  0  1  1  2  2  2  3  4
     4  3  2  2  1  0  2  3  3  1  2  3
     4  3  2  2  1  2  0  1  3  1  2  3
     5  4  3  3  2  3  1  0  4  2  1  2
     3  2  1  3  2  3  3  4  0  4  5  6
     5  4  3  3  2  1  1  2  4  0  1  2
     6  5  4  4  3  2  2  1  5  1  0  1
     7  6  5  5  4  3  3  2  6  2  1  0
      
     0  3  4  6  8  5  6  6  5  1  4  6
     3  0  6  3  7  9  9  2  2  7  4  7
     4  6  0  2  6  4  4  4  2  6  3  6
     6  3  2  0  5  5  3  3  9  4  3  6
     8  7  6  5  0  4  3  4  5  7  6  7
     5  9  4  5  4  0  8  5  5  5  7  5
     6  9  4  3  3  8  0  6  8  4  6  7
     6  2  4  3  4  5  6  0  1  5  5  3
     5  2  2  9  5  5  8  1  0  4  5  2
     1  7  6  4  7  5  4  5  4  0  7  7
     4  4  3  3  6  7  6  5  5  7  0  9
     6  7  6  6  7  5  7  3  2  7  9  0

#####Example usage
```java
//Context from file had12.dat
Context context = new ContextReader().loadContextFromFile(ContextFile.QNP_12);

GeneticAlgorithm geneticAlgorithm =
                new GeneticAlgorithm.GeneticAlgolrithmBuilder()
                        .context(context)
                        .selector(new TournamentSelector(5))
                        .mutator(new RandomSwapMutator())
                        .crossover(new SimpleSwapCrossover())
                        .populationsNumber(100)
                        .generationsNumber(100)
                        .crossoverProbability(0.7)
                        .mutateProbability(0.02)
                        .build();

        geneticAlgorithm.setChartInterpreter(new SimpleChart()); //Showing chart with generations details

        geneticAlgorithm.run();

```