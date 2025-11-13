package metrics;

import algorithm.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Metrics {
    public void saveToCSV(List<Result> results, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("TextName,TextLength,PatternLength,Matches,BuildTime(ms),SearchTime(ms)\n");
            for (Result r : results) {
                writer.write(String.format("%s,%d,%d,%d,%d,%d%n",
                        r.textName, r.textLength, r.patternLength, r.matches,
                        r.buildTimeMs, r.searchTimeMs));
            }
            System.out.println("Metrics saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving metrics to CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void printSummary(List<Result> results) {
        System.out.println("KMP Algorithm Results:");
        for (Result r : results) {
            System.out.printf(
                    "%-15s | TextLen=%5d | PatternLen=%3d | Matches=%3d | Build=%5dms | Search=%5dms%n",
                    r.textName, r.textLength, r.patternLength, r.matches,
                    r.buildTimeMs, r.searchTimeMs
            );
        }
    }
}
