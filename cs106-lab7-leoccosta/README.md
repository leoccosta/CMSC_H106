## CS 106 Lab 7 - Deduplication

Name: Leo T. Costa

---

### Runtime Analysis

For the file SWVF_1_22_med.txt, allPairsDeduplication() took 157.994 seconds, hashLinearDeduplication() took 0.184 seconds, and quicksortDeduplication() took 0.354 seconds.

For deduplicating the whole dataset, hashLinearDeduplication() was the most efficient, but only by a little bit.

However, when it came to running multiple tests with subsets of the dataset, the cummulative time to run hashLinearDeduplication() on subsets of the data was greater than the cummulative time to run quicksortDeduplication() on the same subsets of the data. In general, when I plotted the runtimes for the three deduplication algorithms for different sizes of data against each other, quicksort and linear hash table algoritms were very comparable, while the all pairs algorithm was very clearly much worse. This makes sense because it has an O(n^2) runtime, given that each element may be compared to every other element in the dataset not infrequently. When it comes to quicksort versus linear hash table, they both have the same worst case scenario for a runtime – also O(n^2). However, the best and more likely runtime for quicksort (i.e.  when the data is able to be partitioned and subpartitioned in the middle each time) is O(nlog(n)) while the best and more likely runtime for the hash table (i.e. avoiding collisions) is O(n). That makes it so the hash table algorithm ends up being better (and we can see this a bit towards the right side of the graph), but this is not super apparent with our data because for the n we are working with is not large enough to make log(n) very large and thus very influential. 

---

### Final Project

I added date of birth as a consideration in my compareTo() method because I thought even though multiple people could have the same name, the chances that they were also born on the same day seemed very unlikely. Sure enough, when my compareTo() method only considered first and last name when deduplicating SWVF_1_22_med.txt it found 5211 duplicates. Meanwhile, when I added date of birth as a factor, I only found 2, which is a very dramatic difference. A potential issue this could result in, however, is if a person was accidentally registered with a mistaken birthday (which seems like an easy mistake to make and is actually something that has happened to me) and then reregistered under their correct birthday. If this were the case, such duplicates would remain, which could be an issue if this is a common mistake.

When collecting the statistics about hash table insertion for the hash table deduplication method, I found that when deduplicating SWVF_1_22_med.txt the average number of probes during insertions tended to be just over 1 (~1.055), the max number of probes during insertions was usually 5 or 6, and load factor after insertions was ~0.1. I commented out the code that prints this out for the sake of analysis of the hashtable runtime (also because it was filling up my console) with the new criteria for deduplication (which I altered in Voter.getKey() since the hash table deduplication doesn't use compareTo()).

For the file SWVF_1_22_med.txt, allPairsDeduplication() took 169.548 seconds, hashLinearDeduplication() took 0.274 seconds,  quicksortDeduplication() took 0.228 seconds, and builtinSortDeduplication() took 0.193 seconds.

I plotted just my quicksort method, my hash table method, and Java's Collections.sort() against each other because it was hard to tell how they compared in the graph with all pairs runtimes. The built-in sorting method was faster than my quicksort method, though not by too much. It also had some spikes just as the other two methods did, though I do not know if this is due to it also having a bad but uncommon worst case runtime or just noise due to how my computer is running other programs. The graph I got made sense though for an optimal sorting algorithm of O(nlog(n)). However, the hash table runtime was still generally better than both the sorting methods with it's approximately linear runtime (through looking at the statistics for hash table insertion, this was confirmed because the number of probes remained around 1 and the maximum number remained below 6). 

---

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
  10

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
  3

3. Describe the biggest challenge you faced on this lab:
  Figuring out the quicksort algorithm; finding good intervals for the plot so that it doesn't take forever.