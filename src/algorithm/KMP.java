package algorithm;

public class KMP {

    //building lps array for the pattern
    public int[] lps(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n]; //to store prefix len
        int len = 0; //len of the current longest pref-suf

        for (int i = 1; i < n; ) {
            //if curr char matches with the one at position len then pref+1 and move forward
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                //if mismatch and len>0, then we reduce len to the previous known lps
                len = lps[len - 1];
            } else {
                //if mismatch when len=0 then we just set lps[i]=0
                lps[i++] = 0;
            }
        }
        return lps;
    }

    //searches for all "pattern" in "text" using lps array for efficiency
    public Result search(String textName, String text, String pattern) {
        long startBuild = System.nanoTime();
        int[] lps = lps(pattern);
        long endBuild = System.nanoTime();

        int n = text.length();
        int m = pattern.length();
        int i = 0, j = 0, matches = 0;

        long startSearch = System.nanoTime();

        //main search loop:
        //invariant -> all indices < i have been processed correctly
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                //chars match, move forward in both text and pattern
                i++;
                j++;
                if (j == m) {
                    //whole pattern matched
                    matches++;
                    j = lps[j - 1]; //reuse LPS info to keep searching
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        long endSearch = System.nanoTime();

        double buildTimeMs = (endBuild - startBuild) / 1_000_000.0;
        double searchTimeMs = (endSearch - startSearch) / 1_000_000.0;

        //return results
        return new Result(
                textName,
                n,
                m,
                matches,
                buildTimeMs,
                searchTimeMs
        );
    }
}
