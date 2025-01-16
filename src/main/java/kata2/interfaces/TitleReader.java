package kata2.interfaces;

import kata2.models.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> load() throws IOException;
}
