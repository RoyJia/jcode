import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class FormatFile {

    public static void main(String[] args) {
        String path = "/Users/rjia/gitRepos/jcode/src/main/java/resources/data.txt";
        List<List<String>> result = getDataFromFile(path);

        System.out.println(result.toString());

        File file = new File(path);
        String lastLine = readLastLine(file);
        System.out.println("lastLine: " + lastLine);
    }

    public static List<List<String>> getDataFromFile(String path) {
        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader br = null;
        FileReader fileReader = null;

        try {
            String record = null;

            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);

            while ((record = br.readLine()) != null) {
                List<String> lineItems = Arrays.asList(record.split("\\|"));
                result.add(lineItems);
            }
            result.remove(0);
            result.remove(result.size() - 1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Java read the last line from file
     * @param file
     * @return
     */
    public static String readLastLine(File file){
        ReversedLinesFileReader rLinesFileReader = null;
        
        try {
            rLinesFileReader = new ReversedLinesFileReader(file);
            return rLinesFileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                rLinesFileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}