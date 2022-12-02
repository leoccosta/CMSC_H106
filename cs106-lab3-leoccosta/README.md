## CS 106 Lab 3 - Linked Lists

Name: Leonardo Costa

Number of Late Days Using for this lab: 0

---

### Writeup

1. Which instance variables do you have in your Name class?
I did not make a distinct Name class and instead included it in my Node class. 

It contains the name that the Node represents, a reference to the next Node, areference to the previous Node, the total # of babies for the name for all years, and an ArrayList containing the Node's yearly info (year, rank, and number).

2. How do you organize the storage of the yearly statistics per name versus the totals?
Yearly statistics per name are held in each Node while the totals per year are stored in the LinkedList.

3. Where are the overall totals stored and where are the yearly totals stored?
The total number of babies per name is store in each Node. The total number of babies and the yearly totals are stored in the LinkedList class.


4. How do you keep the linked lists in alphabetically sorted order?
Every time I add a new Node to the list it is inserted alphabetically.

5. How is total rank computed?
It isn't...

---

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
  14

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
  4/5

3. Describe the biggest challenge you faced on this lab:
I was never able to figure out the method for calculating a total rank. I had an algorithm for it but it was not executing properly. 
