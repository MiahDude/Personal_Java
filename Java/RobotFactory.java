/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac RobotFactory.java
 *  Execution:    java RobotFactory
 *
 *  Simulates the development of a robot factory over a period of 20 years.
 *
 ************************************************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;

public class RobotFactory
{
	public static void main(String[] args)
	{
		Robot robot = new Robot();

		ArrayList<Robot> allBots = new ArrayList<Robot>();
		allBots.add(robot);

		int[][] numBots = new int[20][6];

		for (int year = 0; year < 20; year++)
		{
			int n = allBots.size();
			for (int i = 0; i < n; i++)
			{
				Robot bot = allBots.get(i);
				bot.age();
				if (!bot.isActive()) numBots[year][5]++;
				else if (bot.getAge() == 1) numBots[year][1]++;
				else if (bot.getAge() == 2) 
				{
					allBots.add(bot.makeRobotBaby());
					numBots[year][2]++;
					numBots[year][0]++;
				}
				else if (bot.getAge() == 3) numBots[year][3]++;
				else if (bot.getAge() == 4) numBots[year][4]++;
				else if (bot.getAge() == 5) 
				{
					bot.retire();
					numBots[year][5]++;
				}
			}
			System.out.println(Arrays.toString(numBots[year]));
			// First column: number of newborns this year
			// Second column: number of one-year-olds this year
			// Third column: number of two-year-olds this year
			// Fourth column: number of three-year-olds this year
			// Fifth column: number of four-year-olds this year
			// Sixth column: number of retirees this year
		}
	}
}

class Robot
{
	private int age;
	private boolean active;

	public Robot()
	{
		age = 0;
		active = true;
	}

	public int getAge()
	{
		return age;
	}

	public boolean isActive()
	{
		return active;
	}

	public void age()
	{
		age++;
	}

	public void retire()
	{
		active = false;
	}

	public Robot makeRobotBaby()
	{
		return new Robot();
	}
}