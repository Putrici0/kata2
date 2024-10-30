import java.util.List;
import java.util.Map;

public interface TitleHistogram {
    Map<String, Integer> execute(List<Title> titleList);
}
