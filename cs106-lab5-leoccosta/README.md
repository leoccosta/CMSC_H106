## CS 106 Lab 5 - Binary Trees

Name: Leonardo Costa

Number of Late Days Using for this lab: 0

---

### Analysis Questions

1. In Lab 3 we used insertion sort with Linked Lists to gradually build up
a sorted list of names. If the total number of names is n, what was the big-O runtime
of this algorithm? Briefly explain your answer.
O(n^2) – in the worst case scenario, the whole list except for the last Node had to be
traversed/walked to. This produced a linear runtime. If this were done for every name's
insertion, that would produce a quadratic runtime.

2. In this assignment (Lab 5) we used insertion sort with a Binary Tree, then
used a tree traversal to obtain a sorted list of candidates. If the total
number of candidates is n, what is the big-O runtime of this algorithm? Briefly 
explain your answer.
The runtime of going the full depth of the tree (worst case scenario) is O(log(n)) – 
the fact that this has to be done three times (for pre-, post-, and in-order) does not 
change the big-O runtime. The fact that this has to be done n times – for each insertion 
– produces a runtime of O(nlog(n)).

---

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
  6

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
  3

3. Describe the biggest challenge you faced on this lab:
  The tree traversals for toString(). Also understanding some parts of what the lab 
  was asking me to do.

4. Was the **VerifyFormat** file useful to you during testing?
  Yes.
