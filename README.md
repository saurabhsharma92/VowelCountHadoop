# VowelCountHadoop
This is a Hadoop project which count number of vowel in each word given in a sentence

Goal:
Your job is to find patterns from this text. Specifically, you are required to find all
words which have vowels (a, e, i, o, u) in them and present a count of the number
of vowels they contain. For e.g. the word ``introduction” contains the vowels
(i,o,u,i,o) making the total count of vowels for this word five. Your goal in this
project is to design a map and reduce function for the above task.

Input File:
My introduction to the world of Nature was a painful one. Aged five,
I was coming down the spiral staircase from the roof of our
bungalow, when inadvertently I dislodged a beehive under one of
the steps. I was immediately attacked by a swarm of angry bees,
who proceeded to sting me on my face, arms and legs. I got down
the stairs and ran indoors screaming for help.

Output:
We are using 4 partitioner and 4 reducer in our program to segeregate the output based on length of the words. List of file generate after successful execution of program.
•	SUCCESS
•	Part-00000
•	Part-00001
•	Part-00002
•	Part-00003
      
 Check out the attahced output file for actual vowel count.      
