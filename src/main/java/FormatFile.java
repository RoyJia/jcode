import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.input.ReversedLinesFileReader;


public class FormatFile {

    public static final int LIMIT = 10000;
    public static final String FILE_PATH = "/Users/rjia/gitRepos/jcode/src/main/java/resources/data.txt";

	public static void main(String[] args) throws IOException {

        // Read the line 3 from file
        System.out.println("line 3 is: " + getSpecificLine(FILE_PATH, 3));
        System.out.println("-------------------------------------------------------");

        // Read 10 lines start at 10
        getSpecificLines(FILE_PATH, 10, LIMIT).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        // Get data from file
        getDataFromFile(FILE_PATH).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        File file = new File(FILE_PATH);
        String lastLine = readLastLine(file);
        System.out.println("lastLine: " + lastLine);
    }

    public static Map<String, Object> getData(int startLine) {
        Map<String, Object> result = new HashMap<String, Object>();
        boolean isReadingFinished = false;
        List<List<String>> data = getSpecificLines(FILE_PATH, 10, LIMIT);
        if (startLine == 1) {
            data.remove(0);
        }

        if (data.size() < LIMIT) {
            isReadingFinished = true;
        }

        result.put("data", data);
        result.put("isReadingFinished", isReadingFinished);

        return result;
    }

    /**
     * To get specific line (lineIndex) from file (path)
     * Read specific line for small file
     * @param path
     * @param lineIndex
     * @return
     */
    public static String getSpecificLine(String path, int lineIndex) {
		try {
            return Files.readAllLines(Paths.get(path)).get(lineIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Using Stream to get (limit) lines start at {startLine} from file {path}
     * Read specific line for large file
     * @param path
     * @param startLine
     * @param limit
     * @return the lines list
     */
    public static List<List<String>> getSpecificLines(String path, int startLine, int limit) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.skip(startLine).limit(limit).map(p -> Arrays.asList(p.split("\\|"))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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