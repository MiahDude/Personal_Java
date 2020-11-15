#************************************************************************************************
# Author: Jeremiah Herr
# Compilation: python Array.py
# Execution: py Array.py
# 
# Short program used to learn python's basic syntax for arrays.
#
#************************************************************************************************

array1 = [1,2,3,4,5,6]
array2 = [[1,2],[3,4]]
print(array1)
print(array2)
stringA = ["word","word2"]

for row in array2:
	for val in row:
		print('{:4}'.format(val), end=' ')
	print()

n = 2
for i in range(n):
	for j in range(n):
		print('{:4}'.format(array2[i][j]), end=' ')
	print()