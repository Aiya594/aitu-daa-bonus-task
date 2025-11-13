import algorithm.KMP;
import algorithm.Result;
import metrics.Metrics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        Metrics collector = new Metrics();
        List<Result> results = new ArrayList<>();


        //testing different strings
        results.add(kmp.search("Short", "ababcabcab", "abc"));
        results.add(kmp.search("Medium", "abababcaababababcabab", "ababc"));
        results.add(kmp.search("Long", "aaaaaaabaaaaaabaaaaaaabaaaaaab", "aaaaaab"));

        collector.printSummary(results);
        collector.saveToCSV(results, "kmp_results.csv");


    }
}