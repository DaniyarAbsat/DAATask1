## 1. **MergeSort (Divide & Conquer, Master Case 2)**

**Architecture notes.** 
Recursive depth of 'O(log n)'; memory buffering is done once and reused for all merges. Small subsets (  16 elements) are sorted by inserts to reduce overhead. Thus, both the depth of recursion and the number of extractions are controlled.

**Recurrence analysis.** 
Recurrent ratio:
`T(n) = 2T(n/2) + Θ(n)' (sorting of two halves + linear merging).
According to the Master theorem (Case 2), the solution is: T(n) = Θ(n log n).

## 2. **QuickSort (Robust)**

**Architecture notes.**
Piwo is selected randomly, which prevents worst cases on sorted inputs. Recursion is performed **on the least of two parts** and on the most part - iteration (tail recursion). This guarantees an average stack depth of O(log n). No additional array localization is required (in-place).

**Recurrence analysis.** 
On average: T(n) = T(pn) + T((1-p)n) + Θ(n), where p 1/2 is waiting.
Using probabilistic analysis or Akra-Bazzi, we get Θ(n log n).
Worst case (unlikely with random beer): 'Θ(n 2)'.

##3. **Deterministic Select** (Median-of-Medians, O(n))

**Architecture notes.**
The array is divided into groups of 5 elements, each looking for a median. A recursive call to find the median of the median gives a good pico (  30% of the elements discarded). The recursion is always only one way (where k is), with a smaller part for depth control. The algorithm is executed in-place, so add. Memory is limited to O(1).

**Recurrence analysis.**
`T(n) = T(n/5) + T(7n/10) + Θ(n).
By Akra-Bazzi or through a median analysis, the solution is: T(n) = Θ(n).
This gives a linear complexity even in the worst case.

## 4. **Closest Pair of Points (2D)**

**Architecture notes.**
First, the points are sorted by 'x'. Recursive halving gives the depth of 'O(log n)'. At each step, a "band" of width `2d', sorted by 'y', is formed and checked to 7-8 neighbors, which gives linear processing at each level. Additional allokations: "stripe" arrays.

**Recurrence analysis.**
`T(n) = 2T(n/2) + Θ(n)' (two recursive calls + linear strip check).
According to the Master theorem (Case 2), the solution is: T(n) = Θ(n log n).

