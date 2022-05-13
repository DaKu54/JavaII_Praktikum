package Aufgabe_III;

import java.util.Scanner;
public class Sudoku {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int count = 0;
		int [][] sudoku = getExample();
		
		while (count != 81) {
			for (int i = 0; i < sudoku.length; i++) {
				for(int j = 0; j < sudoku[i].length; j++) {
					if (sudoku[i][j] != 0)
						count += 1;
				}
			}
			printSoduko(sudoku);
			System.out.println("Zeile:");
			int row = scanner.nextInt();
			System.out.println("Spalte:");
			int column = scanner.nextInt();
			System.out.printf("Welcher Wert soll bei %d %d eingesetzt werden?%n", row, column);
			int entry = scanner.nextInt();
			
			if (!(0 <= row && row <=8) || !(0 <= column && column <= 8) || !(0 < entry && entry <= 9))
				throw new IllegalArgumentException("Ihre Eingaben sind nicht gültig");
			
			if(!isValidEntry(sudoku, row, column, entry))
				throw new IllegalArgumentException("Der Eintrag " + entry + " kann hier nicht gesetzt werden");
			
			if (sudoku[row][column] != 0 && !(sudoku[row][column] < 0)) {
				System.out.printf("Bei %d %d ist bereits ein Eintrag, wollen Sie diesen überschreiben? (y/n)%nEintrag an dieser Stelle: %d", row, column, sudoku[row][column]);
				String str = scanner.next();
				if (str.equals("y"))
					sudoku[row][column] = entry;
				else
					continue;
			}
			else if (sudoku[row][column] < 0) {
				System.out.printf("%n\"An dieser Stelle ist ein fester Wert, dieser kann nicht ersetzt werden.\"%n");
				continue;
			}
			else
				sudoku [row][column] = entry;
			printSoduko(sudoku);
			System.out.println();
		}
		System.out.println(isSolution(sudoku));
		count = 0;
	}
	
	public static int[][] getExample() {
		int[][] sudoku = new int[][]
		{
			{-5,-3,0,0,-7,0,0,0,0},
			{-6,0,0,-1,-9,-5,0,0,0},
			{0,-9,-8,0,0,0,0,-6,0},
			{-8,0,0,0,-6,0,0,0,-3},
			{-4,0,0,-8,0,-3,0,0,-1},
			{-7,0,0,0,-2,0,0,0,-6},
			{0,-6,0,0,0,0,-2,-8,0},
			{0,0,0,-4,-1,-9,0,0,-5},
			{0,0,0,0,-8,0,0,-7,-9}
		};
		return sudoku;
	}
	
	public static void printSoduko(int[][]sudoku) {
		System.out.printf("    0 1 2   3 4 5   6 7 8%n  +-------+-------+-------+%n");
		for(int i = 0; i < sudoku.length; i++){
			if (i == 3 || i == 6)
				System.out.println("  +-------+-------+-------+");
			System.out.printf("%d | ", i);
		    for(int j = 0; j < sudoku[i].length; j++){
		        if (j == 2 || j == 5) {
		        	if (sudoku[i][j] == 0)
		        		System.out.print("  | ");
		        	else
		        		System.out.print(Math.abs(sudoku[i][j]) + " | ");
		        }
		        else if (j == 8 && sudoku[i][j] != 0)
		            System.out.print(Math.abs(sudoku[i][j]) + " | ");
		        else {
		        	if (sudoku[i][j] == 0 && j == 8)
		        		System.out.print("  |");
		        	else if (sudoku[i][j] == 0)
		        	    System.out.print("  ");
		        	else
		        		System.out.print(Math.abs(sudoku[i][j]) + " ");
		        }
		         
		    }
		    System.out.println();
		}
		System.out.println("  +-------+-------+-------+");	
	}
	
	public static void checkValidSudokuMatrix(int [][] sudoku) {
		if (sudoku == null)
			throw new IllegalArgumentException("Sudoku darf nicht \"null\" sein!");
		if(sudoku.length != 9)
			throw new IllegalArgumentException("Die Anzahl der Zeilen muss 9 sein!");
		for(int i  = 0; i < sudoku.length; i++){
			if (sudoku[i] == null)
				throw new IllegalArgumentException("Keine Zeile darf \"null\" sein!");
		    if(sudoku[i].length != 9)
		        throw new IllegalArgumentException("Die Anzahl der Spalten in jeder Zeile muss 9 sein!");
		    for (int j = 0; j < sudoku[i].length; j++) {
				if(!(0 <= Math.abs(sudoku[i][j]) && Math.abs(sudoku[i][j]) <= 9))
					throw new IllegalArgumentException("Alle Einträge müssen zwischen 0 und 9 liegen!");
			}
		}
	}
	
	public static boolean isValidEntry(int[][] sudoku, int row, int column, int entry) {
		checkValidSudokuMatrix(sudoku);
		if (!(0 <= row && row <= 8))
			throw new IllegalArgumentException("row entspricht nicht den Erwartungen!");
		if (!(0 <= column && column <= 8))
			throw new IllegalArgumentException("column entspricht nicht den Erwartungen!");
		if(!(0 <= entry && entry <= 9))
			throw new IllegalArgumentException("entry entspricht nicht den Erwartungen!");
		
		boolean test = true;
		int count_row = 0, count_column = 0, count_block = 0;
		for(int i = 0; i < sudoku.length; i++) {
		    if (i == column)
		        continue;
			if (Math.abs(sudoku[row][i]) == entry)
				count_row += 1;
		}
		if (count_row != 0)
		    test = false;
		if (test) {
		    for (int k = 0; k < sudoku.length; k++){
		        if (k == row)
		            continue;
		        if (Math.abs(sudoku[k][column]) == entry)
		            count_column += 1;
		    }
		    if (count_column != 0)
		        test = false;
		    if (test){
                for(int i = (int)(row/3)*3; i < (int)(row/3)*3 + 3; i++) {
    		        for (int j = (int)(column/3)*3; j < (int)(column/3)*3 + 3; j++) {
    		            if (i == row && column == j)
    		                continue;
    					if(Math.abs(sudoku[i][j]) == entry)
    						count_block += 1;
    				}
    			}
    			if(count_block != 0)
    			    test = false;
		    }	
		}
		return test;
	}
	
	public static boolean isSolution(int[][] sudoku) {
		checkValidSudokuMatrix(sudoku);
		boolean test = true; 
		int sum = 0;
		
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				sum += Math.abs(sudoku[i][j]);
				test = isValidEntry(sudoku, i, j, Math.abs(sudoku[i][j]));
				if (!test)
					break;
				if (Math.abs(sudoku[i][j]) == 0)
					test = false;
			}
			if (!test)
				break;
		}
		if (sum != 405)
			test = false;
		return test;
	}
}