package kata2.interfaces;

import kata2.models.Title;

import java.util.List;
import java.util.Map;

public interface TitleHistogram {
    Map<String, Integer> execute(List<Title> titleList);
}
