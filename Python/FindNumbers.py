#*******************************************************************************************************************
# Author: Jeremiah Herr
# Compilation: python FindNumbers.py
# Execution: py FindNumbers.py
# 
# Finds and prints numbers in an input string containing numbers separated by commas and computes their sum
#
#*******************************************************************************************************************

string = input("Input a series of numbers separated by commas: ")
index = 0
lastComma = -1
sum = 0.0
while index<len(string):
	# grab all characters between (and not including) the current comma and the last comma
	if string[index] == ',':
		# grabs a substring from string from the index after the last comma to current index
		# and converts it to a float
		number = float(string[lastComma+1:index])
		# add the float to our sum
		sum = sum + number
		print(sum)
		lastComma = index
	# if we have reached the end of the string, grab all characters from the last comma up to and including where we are now
	if (index) == (len(string)-1):
		number = float(string[lastComma+1:index+1])
		sum = sum + number
		print(sum)
	index = index + 1