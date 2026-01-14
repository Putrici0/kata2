package software.ulpgc;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieReader implements MovieReader, Closeable {

    private final BufferedReader reader;

    public RemoteMovieReader() throws IOException {
        this.reader = createReader(createConnection());
        this.reader.readLine();
    }

    private static URLConnection createConnection() throws IOException {
        URL url = new URL("https://datasets.imdbws.com/title.basics.tsv.gz");
        URLConnection conn = url.openConnection();
        conn.connect();
        return conn;
    }

    private static BufferedReader createReader(URLConnection connection) throws IOException {
        return new BufferedReader(new InputStreamReader(new GZIPInputStream(new BufferedInputStream(connection.getInputStream()))));
    }


    @Override
    public List<Movie> readAll() {
        List<Movie> movies = new ArrayList<>();
        while (true) {
            Movie movie = readMovie();
            if (movie == null) break;
            movies.add(movie);
        }
        return movies;
    }

    private Movie readMovie() {
        try {
            String line = reader.readLine();
            return line != null ? createMovie(line) : null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Movie createMovie(String line) {
        return createMovie(line.split("\t"));
    }

    private Movie createMovie(String[] line) {
        return new Movie(line[2], toInteger(line[7]));
    }

    private int toInteger(String s) {
        if (s.equals("\\N")) return 0;
        return Integer.parseInt(s);
    }

    @Override
    public void close() throws IOException {
        this.reader.close();
    }
}
