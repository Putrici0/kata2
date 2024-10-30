import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleLoader implements TitleReader {
    File file;

    public TsvTitleLoader(File file) {
        this.file = file;
    }

    public static TsvTitleLoader with(File file) {
        return new TsvTitleLoader(file);
    }


    public List<Title> load(BufferedReader bf) throws IOException {
        bf.readLine();
        ArrayList<Title> titles = new ArrayList<>();
        while (true) {

            String line = bf.readLine();
            if (line == null) {

                return titles;
            }
            titles.add(toTitle(line));
        }
    }

    private Title toTitle(String line) {
        return toTitle(line.split("\t"));
    }

    private Title toTitle(String[] split) {
        int i = 0;
        return new Title(
                split[i++],
                split[i++],
                split[i++],
                split[i++],
                parseIntOrDefault(split[i++]),
                parseIntOrDefault(split[i++]),
                split[i++],
                parseIntOrDefault(split[i])
        );
    }

    private int parseIntOrDefault(String s) {
        if (s.equals("\\N")) {

            return 0;
        }
        return Integer.parseInt(s);
    }

    @Override
    public List<Title> load() throws IOException {
        return load(new BufferedReader(new FileReader(file)));
    }
}
