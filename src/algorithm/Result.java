package algorithm;

public class Result {
    public String textName;
    public int textLength;
    public int patternLength;
    public int matches;
    public double buildTimeMs;
    public double searchTimeMs;

    public Result(String textName, int textLength, int patternLength,
                  int matches, double buildTimeMs, double searchTimeMs) {
        this.textName = textName;
        this.textLength = textLength;
        this.patternLength = patternLength;
        this.matches = matches;
        this.buildTimeMs = buildTimeMs;
        this.searchTimeMs = searchTimeMs;
    }
}
