%*******************************************************************************************************************
% Author: Jeremiah Herr 
% Execution: swipl -s robotfactory.pl -g "robotFactory(0,[0])." -t halt.
%
% Simulates the development of a robot factory over a period of 20 years.
% 
% NOTE: Running the program using the above command causes it to report an error in addition to the expected output,
% but it does not report any errors if you run it in the swipl interpreter.
%
%*******************************************************************************************************************

newborn(R):-
	R = 0.
firstYear(R):-
	R = 1.
secondYear(R):-
	R = 2.
thirdYear(R):-
	R = 3.
fourthYear(R):-
	R = 4.
retired(R):-
	R >= 5.

countBots([],0,0,0,0,0,0).
countBots([H|T],Num0,Num1,Num2,Num3,Num4,Num5):-
	countBots(T,Num0i,Num1i,Num2i,Num3i,Num4i,Num5i),
	(newborn(H) -> Num0 is Num0i+1; Num0 = Num0i),
	(firstYear(H) -> Num1 is Num1i+1; Num1 = Num1i),
	(secondYear(H) -> Num2 is Num2i+1; Num2 = Num2i),
	(thirdYear(H) -> Num3 is Num3i+1; Num3 = Num3i),
	(fourthYear(H) -> Num4 is Num4i+1; Num4 = Num4i),
	(retired(H) -> Num5 is Num5i+1; Num5 = Num5i).

ageBots([],[]).
ageBots([H|T],L):-
	ageBots(T,Li),
	H1 is H+1,
	append([H1],Li,L).

makeBots([],[]).
makeBots([H|T],L):-
	makeBots(T,Li),
	(secondYear(H) -> append([0],Li,L); makeBots(T,L)).

nextYear(Bots,Num0,Num1,Num2,Num3,Num4,Num5,AllBots):-
	ageBots(Bots,AgedBots),
	makeBots(AgedBots,NewBots),
	append(AgedBots,NewBots,AllBots),
	countBots(AllBots,Num0,Num1,Num2,Num3,Num4,Num5).

robotFactory(Year,Bots):-
	Year < 20, Next is Year+1,nl,
	nextYear(Bots,Num0,Num1,Num2,Num3,Num4,Num5,AllBots),
	write(Num0),write(' '), /* First column: number of newborns this year */
	write(Num1),write(' '), /* Second column: number of one-year-olds this year */
	write(Num2),write(' '), /* Third column: number of two-year-olds this year */
	write(Num3),write(' '), /* Fourth column: number of three-year-olds this year */
	write(Num4),write(' '), /* Fifth column: number of four-year-olds this year */
	write(Num5),write(' '), /* Sixth column: number of retirees this year */
	robotFactory(Next,AllBots).
/* to get the desired results, input robotFactory(0,[0]). */