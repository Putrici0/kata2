package es.software.ulpgc.kata2.models;

public record Title(String tconst,
                    String titleType,
                    String primaryTitle,
                    String originalTitle,
                    int isAdult,
                    int startYear,
                    String endYear,
                    int runtimeMinutes) {
}
