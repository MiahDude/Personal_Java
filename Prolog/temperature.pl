%****************************************************************************************************
% Author: Jeremiah Herr
% Execution: swipl -s temperature.pl -g "convert(t,s)." -t halt.
% 
% Where t is a number and s is a temperature scale c (for Celsius) or f (for Fahrenheit)
%
% Converts an input temperature in a specified scale (Fahrenheit or Celsius) to the other scale.
%
%****************************************************************************************************

/* define temperature scales of f and c,
   for fahrenheit and celsius respectively */
scale(f).
scale(c).

fahrenheit(T):-
	F is T*(9 / 5) + 32,
	write(F), write(' F').

celsius(T):-
	C is (T-32)*(5 / 9),
	write(C), write(' C').

/* input temperature and temperature scale
   example input: convert(32,c).
   example output: 89.6 F */
convert(T,S):-
	scale(S),
	S = f -> celsius(T); fahrenheit(T).