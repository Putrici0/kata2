package es.software.ulpgc.kata2.interfaces;

import es.software.ulpgc.kata2.models.Title;

import java.util.List;
import java.util.Map;

public interface TitleHistogram {
    Map<String, Integer> execute(List<Title> titleList);
}
