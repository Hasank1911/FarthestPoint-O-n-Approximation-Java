# Farthest Point O(n) Approximation Java
Finds approximate result for farthest point problem in O(n).
Performance of the algorithm will depend on variance of the distances in data and the order of the points.

Algorithm;

initiate current pair(p1,p2) with first two points of the data
for i=2 to n
  find the farthest(best) pair between p1-i, p2-i, p1-p2.
  select best pair and update p1 and p2 accordingly
  
 

