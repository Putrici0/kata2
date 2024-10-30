import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Title> titleList = TsvTitleLoader.with(new File("C:/Users/paull/Desktop/Ingenieria Informática - ULPGC/Tercero/is2 katas/kata2/title.basics.tsv")).load();

        Map<String, Integer> statistics = new TotalTitleStatistics().execute(titleList);
        for (String key : statistics.keySet()) {
            System.out.println(key+" = "+ statistics.get(key));
        }
    }
}
