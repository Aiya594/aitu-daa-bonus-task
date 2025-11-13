# Knuth–Morris–Pratt (KMP) Algorithm Implementation


---
Course:Design and Analysis of Algorithms 

Student: Aiya Zhakupova 

---

For this bonus task, I implemented the Knuth–Morris–Pratt (KMP) string-matching algorithm from scratch in Java. 
KMP efficiently searches for all occurrences of a pattern string within a text by precomputing a Longest Prefix Suffix (LPS) array, 
which allows the algorithm to skip redundant comparisons.


* KMP.java — performs the search using the precomputed LPS(KMP has a method lps(pattern) that computes the LPS array for the pattern).

* Metrics.java — records runtime metrics and outputs CSV reports.

---
### Implementation Details

#### LPS Array Construction
The LPS array stores, for each position i in the pattern, 
the length of the longest proper prefix that is also a suffix.
This array is used during the search to avoid unnecessary backtracking
when a mismatch occurs.

Complexity:

* Time: O(m), m-pattern length
* Space:O(m)

#### Pattern Search

The KMP search iterates over the text string, 
comparing characters to the pattern.
On a mismatch, it uses the LPS array to shift the pattern efficiently,
maintaining linear time complexity.

Loop Invariant: 
At each index i in the text, 
all previous positions have been correctly processed —
either matched or skipped according to the prefix information.

Complexity:

* Time:O(n+m), m-pattern length and n-text length
* Space: O(m) for the LPS array

---

### Testing Results

| TextName | Text                             | Pattern   | TextLength | PatternLength | Matches | BuildTime  | SearchTime  |
| -------- |----------------------------------|-----------|------------| ------------- | ------- | ---------- | ----------- |
| Short    | "ababcabcab"                     | "abc"     | 10         | 3           | 2       | 0.006      | 0.001       |
| Medium   | "abababcaababababcabab"          | "ababc"   | 21         | 5          | 2       | 0.002      | 0.002       |
| Long     | "aaaaaaabaaaaaabaaaaaaabaaaaaab" | "aaaaaab" | 30         | 7          | 4       | 0.001      | 0.002       |

Observations:

* The algorithm performs extremely fast for small to medium-sized inputs; 
times are in the microsecond range when converted from milliseconds.

* The number of matches correctly reflects the pattern occurrences in each text.

* Build times are negligible compared to search times for longer patterns, 
consistent with the expected O(n+m) behavior.

---
### Analysis 
* #### Time complexity
The total runtime of the KMP algorithm comes from two main steps: LPS construction and pattern search.

1. LPS Construction (lps(pattern))

   * We iterate through the pattern string of length m once.

   * Each character comparison either increments the len (prefix length) or falls back to a previous LPS value.

   * Key insight: Even with the fallback steps, each character is processed at most twice (once forward, once backward via LPS).

   * Time complexity: O(m) — linear in the pattern length.

2. Pattern Search (search(text,pattern))

   * We iterate through the text string of length n once.

   * Each character comparison either moves both text and pattern indices forward or jumps in the pattern according to LPS.

   * Loop invariant: Each character in the text is visited at most once; we never re-check matched characters unnecessarily.

   * Time complexity:O(n) — linear in the text length.

3. Total Time Complexity

   * Combining LPS building and search:O(m)+O(n)=O(n+m)

* #### Space complexity

KMP space usage comes from:

1. LPS Array

    * Stores an integer for each character of the pattern.

    * Size m integers: O(m) space.

2. Additional Variables

   * Indices i, j, len and counters like matches.

    * Constant extra space :O(1).

3. Total Space Complexity 

    * O(m)+O(1)=O(m)

Observation: Space depends only on the pattern length, not the text length.

Suitable for very long texts, because no additional structures proportional to n are needed.


---
### Conclusion

* The KMP algorithm efficiently finds all occurrences of a pattern in a text with guaranteed linear time complexity. The implementation demonstrates:

* Modular Java design (separate classes for LPS, matching, and metrics).

* Empirical validation via runtime measurements for texts of different lengths.

* Correct handling of matches and minimal memory usage.

