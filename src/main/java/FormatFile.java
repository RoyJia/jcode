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

    public static final int LIMIT = 10;
    public static final String FILE_PATH = "/Users/rjia/gitRepos/jcode/src/main/java/resources/data.txt";

	public static void main(String[] args) throws IOException {

        // // Read the line n from file
        // int n = 1;
        // System.out.println("-------------------------------------------------------");
        // System.out.println("line n: " + n + " is: " + readSpecificLine(FILE_PATH, n-1));

        // // Read 10 lines start at 1
        // System.out.println("-------------------------------------------------------");
        // getSpecificLines(FILE_PATH, 1, 10).forEach(System.out::println);

        // // Read 10 lines start at 11
        // System.out.println("-------------------------------------------------------");
        // getSpecificLines(FILE_PATH, 11, 10).forEach(System.out::println);

        // // Get data from file
        // System.out.println("-------------------------------------------------------");
        // getDataFromFile(FILE_PATH).forEach(System.out::println);

        // File file = new File(FILE_PATH);
        // String lastLine = readLastLine(file);
        // System.out.println("lastLine: " + lastLine);

        int allLinesSize = validateFile(FILE_PATH);
        boolean isReadingFinished = false;
        int startLine = 1;

        while(!isReadingFinished) {
            Map<String, Object> result = getData(startLine, allLinesSize);
            System.out.println("-------------------------------------------------------");
            Arrays.asList(result.get("data")).forEach(System.out::println);

            isReadingFinished = (boolean)result.get("isReadingFinished");
            startLine = (int)result.get("nextStartLine");
            
        }
    }

    /**
     * Verify file content
     * @param path
     * @return
     */
    public static int validateFile(String path) {
        try {
            List<String> allLines =  Files.readAllLines(Paths.get(path));
            
            String firstLine = allLines.get(0);
            if (!firstLine.matches("^(10)\\|(\\d+)\\|((([0-9]{4})(0[1-9]|1[0-2]))|(([0-9]{4})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1]))|(([0-9]{4})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])(2[0-3]|[01][0-9])([0-5][0-9])([0-5][0-9])))$")) {
                throw new RuntimeException("文件第一行不符合条件!" + firstLine);
            }

            String lastLine = allLines.get(allLines.size() - 1);
            if (!lastLine.matches("^90\\|[0-9]+$")) {
                throw new RuntimeException("文件最后一行不符合条件!" + lastLine);
            }

            int count = Integer.parseInt(firstLine.split("\\|")[1]);

            if ((count + 2) != allLines.size()) {
                throw new RuntimeException("文件记录数错误!" + "记录数: " + count + " + 2 不等于文件总行数" + allLines.size());
            }

            return allLines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 
     * @param startLine
     * @param allLinesSize
     * @return
     */
    public static Map<String, Object> getData(int startLine, int allLinesSize) {
        Map<String, Object> result = new HashMap<String, Object>();
        boolean isReadingFinished = false;
        List<List<String>> data = getSpecificLines(FILE_PATH, startLine, LIMIT);

        int nextStartLine = startLine + LIMIT;
        if (nextStartLine >= allLinesSize) {
            isReadingFinished = true;
        }

        if (isReadingFinished) {
            data.remove(data.size() - 1);
        }

        result.put("data", data);
        result.put("isReadingFinished", isReadingFinished);
        result.put("nextStartLine", nextStartLine);

        return result;
    }

    /**
     * To get specific line (lineIndex) from file (path)
     * Read specific line for small file
     * @param path
     * @param lineIndex
     * @return
     */
    public static String readSpecificLine(String path, int lineIndex) {
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

    /**
     * To read file line from file (path)
     * @param path
     * @return
     */
    public static String readFirstLine(String path) {
        return readSpecificLine(path, 0);
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

    /**
     * To use BufferedReader read file
     * @param path
     * @return
     */
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
}