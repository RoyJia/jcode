import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatFile {

    public static void main(String[] args) {
        String path = "/Users/rjia/gitRepos/jcode/src/main/java/resources/data.txt";
        List<List<String>> result = getDataFromFile(path);

        System.out.println(result.toString());
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
}