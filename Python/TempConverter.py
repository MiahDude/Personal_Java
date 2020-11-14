#************************************************************************
# Author: Jeremiah Herr
# Compilation: python TempConverter.py
# Execution: py TempConverter.py
# 
# Converts input temperatures between Fahrenheit and Celsius
# This was my first attempt at writing a program to teach myself Python
#
#************************************************************************

# function that inputs a temperature fahrenheit
# and outputs the same temperature celsius
def F2C(F):
	cels = (float(F) - 32.0) * (5.0/9.0)
	return cels   

# function that inputs a temperature celsius
# and outputs the same temperature fahrenheit
def C2F(C):
	fahren = ((9.0/5.0) * float(C)) + 32.0
	return fahren

# function that takes over if the user wants to convert a temperature in Fahrenheit to Celsius
def ConvertF():
	print("\nPlease give an integer temperature in fahrenheit\n")
	fah = input()
	print(str(fah) + " degrees F = " + str(F2C(fah)) + " degrees C")

# function that takes over if the user wants to convert a temperature in Celsius to Fahrenheit
def ConvertC():
	print("\nPlease give an integer temperature in celsius\n")
	cel = input()
	print(str(cel) + " degrees C = " + str(C2F(cel)) + " degrees F")

# function that acts as the main program
def TempConv():
	print("\nIf you would like to convert Fahrenheit to Celsius, type '1'")
	print("or if you would like to convert Celsius to Fahrenheit, type '2'")
	print("or if you would like to stop, type '3'\n")

	answer = input(input())

	if answer == 1:
		ConvertF()
	elif answer == 2:
		ConvertC()
	elif answer == 3:
		return
	else:
		print("Incorrect answer")

	TempConv()

# run the temperature converter
TempConv()
