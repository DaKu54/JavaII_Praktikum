package gamblinghall;

import java.util.Scanner;

public abstract class SlotMachine 
	{
		public String name;
		public final double revenue = 0;
		public double profit = 0;
		public int countGames = 0;
		public int countWins = 0;
		 	
		public SlotMachine(String name)
		{
			if(this.name==null||this.name.isEmpty())
			{
				throw new IllegalArgumentException("Name darf nicht null oder leer sein.");
			}
			this.profit = 0;
			this.countGames = 0;
			this.countWins = 0;
		}

		public String getName()
		{
			return name;
		}
		
		public double getRevenue()
		{
			return revenue;
		}
		
		public double getProfit()
		{
			return profit;
		}
		
		public int getCountGames()
		{
			return countGames;
		}
		
		public int getCountWins()
		{
			return countWins;
		}
		public void checkValues() {
			if (name == "" || name == null)
			{
				throw new IllegalArgumentException("Name darf nicht leer oder null sein!");
			}
			
			
		}
		
		public void payIn() 
		{
			Scanner scan = new Scanner(System.in);
			double cash = scan.nextDouble();
			if (cash <= 0)
			{
				throw new IllegalArgumentException("Du hast nicht genug Cash eingeworfen");
			}
		}
		public void payOut() 
		{
			Scanner scan = new Scanner(System.in);
			double cash = scan.nextDouble();
			if (cash <= 0)
			{
				throw new IllegalArgumentException("Du hast nicht genug Cash eingeworfen");
			}
		}
		
		public int hashCode() 
		{
			return countGames;
		}
		
		public boolean equals(Object DoubleShot,Object ArcadeFun, Object Roulette, String name)
		{
			return true;
		}
		
		public abstract void play(); 

		public String toString() 
		{
			return name;
		}
	}
