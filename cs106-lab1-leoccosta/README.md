## CS 106 Lab 1 - Data Structure Design

Name: Leonardo Costa

Number of Late Days Using for this lab: 0

---

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
  Lab 1: 5
  Lab 2: 5

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
  Lab 1: 2
  Lab 2: 4

3. Describe the biggest challenge you faced on this lab:
  Lab 1: Not being sure which methods to make. 
  Lab 2: My output never matched the table we were given and I spent most of my time just trying to find out why and I still have no idea. The TAs couldn't help me either... :(
  
### Reading in Data

If any of your validation methods indicate that your precondition assumptions were not met by the data, document what preconditions were violated and in what way. Update your validation methods one error at a time, documenting all issues, until you can read in all the data. If this did not happen, mention that.
  I did not account for the inputs F5, F6, F7 for the degree of the recidivism charge and thus it throwing the IllegalArgumentException I made.

Describe a person who would generate data that would not pass your (updated) precondition assumptions.
  Non-binary and intersex people would not pass the precondition assumptions of gender/sex. People who are mixed race may identify as multiple racial categories.
 
### Analysis
I chose to filter out driving tickets just as the ProPublica analysts did. I also filtered out Fail To Obey Police Officer and Resisting W/O Violence because I know that police officers often perpetuate racism and other forms of prejudice in their perceptions and claims of cooperation. Just these filters made a larger impact on the percent of African-American defendants that Didn't Re-Offend, but Labeled High Risk than White defendants in the same category. It also significantly decreased the % of African-Americans in the Did Re-Offend, but Labeled Low Risk category while it had a smaller impact on White defendants in the same category.
