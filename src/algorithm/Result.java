package algorithm;

public class Result {
    public String textName;
    public int textLength;
    public int patternLength;
    public int matches;
    public long buildTimeMs;
    public long searchTimeMs;

    public Result(String textName, int textLength, int patternLength,
                  int matches, long buildTimeMs, long searchTimeMs) {
        this.textName = textName;
        this.textLength = textLength;
        this.patternLength = patternLength;
        this.matches = matches;
        this.buildTimeMs = buildTimeMs;
        this.searchTimeMs = searchTimeMs;
    }
}
