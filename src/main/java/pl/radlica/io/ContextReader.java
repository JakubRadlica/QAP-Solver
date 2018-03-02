package pl.radlica.io;

import pl.radlica.io.Exception.ContextFileException;
import pl.radlica.model.Context;

import java.io.*;
import java.util.Arrays;

public class ContextReader {

    public ContextReader(){

    }

    public Context loadContextFromFile(String filePath) throws ContextFileException {
        File file = new File(filePath);
        return loadContextFromFile(file);
    }

    public Context loadContextFromFile(ContextFile ctxFile) throws ContextFileException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("context/"+ctxFile.getFileName()).getFile());
        return loadContextFromFile(file);
    }

    private Context loadContextFromFile(File file) throws ContextFileException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int contextSize = Integer.parseInt(line);
            int distance[][] = new int[contextSize][contextSize];
            int flow[][] = new int[contextSize][contextSize];
            while((line=br.readLine()).matches("\\s++")){
                line=br.readLine();
            }
            distance[0]=lineToIntArr(line);
            for(int i=1; i<contextSize; i++){
                line=br.readLine();
                distance[i]=lineToIntArr(line);
            }
            while((line=br.readLine()).matches("\\s++")){
                line=br.readLine();
            }
            flow[0]=lineToIntArr(line);
            for(int i=1; i<contextSize; i++){
                line=br.readLine();
                flow[i]=lineToIntArr(line);
            }
            return new Context(contextSize, distance, flow);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new ContextFileException();
    }

    private int[] lineToIntArr(String line){
        String tokens[] = line.split("\\s++");
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
    }
}
