# Farthest Point O(n) Approximation Java
Finds approximate result for farthest point problem in O(n). <br />
Performance of the algorithm will depend on variance of the distances in data and the order of the points. <br />

Algorithm; <br /> 

initiate current pair(p1,p2) with first two points of the data <br />
for i=2 to n <br />
 &nbsp;&nbsp;&nbsp;find the farthest(best) pair between p1-i, p2-i, p1-p2. <br />
 &nbsp;&nbsp;&nbsp;select best pair and update p1 and p2 accordingly
  
 

