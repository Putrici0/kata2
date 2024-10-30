import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalTitleStatistics implements TitleHistogram {

    @Override
    public Map<String, Integer> execute(List<Title> titleList) {

        Map<String, Integer> map = new HashMap<>();

        for (Title title : titleList) {

            String type = title.titleType();
            map.put(type, map.getOrDefault(type, 0) +1);
        }
        return map;

    }
}
