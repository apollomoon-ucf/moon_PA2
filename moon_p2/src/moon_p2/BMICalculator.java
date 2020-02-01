// Brian Moon
// BMI Calculator - BMICalculator.java
// COP3330


package moon_p2;

import java.util.Scanner;

public class BMICalculator {
	
	// declaring instance variables to store user data for calculating bmi
	private double weightInPounds;
	private double weightInKilograms;
	private double heightInInches;
	private double heightInMeters;
	private int unitType;
	private int bmiCategory;
	private double bmi;
	
	// this method is to read user data
	public void readUserData()
	{
		// calls method to read unit type for calculating bmi
		readUnitType();
		// calls method to read measurement data based upon which unit type the user selected
		readMeasurementData();
	}
	
	private void readUnitType()
	{
		// declare variable for storing the input from user to determine the unit type needed for calculating bmi
		int userMeasurementSelection = 5;
		
		// prompt user to make a selection for unit type
		System.out.println("Welcome to the BMI calculator!\n");
		System.out.println("Please select the unit type for your measurements: ");
		System.out.println("Enter 1 and press enter for Metric units of measurement (Kilograms and Meters):");
		System.out.println("Enter 2 and press enter for Imperial units of measurement (Pounds and Inches): ");
		Scanner in = new Scanner(System.in);
		userMeasurementSelection = in.nextInt();
		
		// check if user's input in actually valid for the measurement type 
		while(userMeasurementSelection != 1 && userMeasurementSelection != 2)
		{
			System.out.println("The selection you made is invalid.");
			System.out.println("Enter 1 and press enter for Metric units of measurement (Kilograms and Meters):");
			System.out.println("Enter 2 and press enter for Imperial units of measurement (Pounds and Inches) ");
			userMeasurementSelection = in.nextInt();	
		}
		
		// display to user the unit type they selected for calculating bmi
		if (userMeasurementSelection == 1)
		{
			System.out.println("You selected Metric Units (Kilograms and Meters)\n");
			this.unitType = 1;
		}
		else if (userMeasurementSelection == 2)
		{
			System.out.println("You selected Imperial Units (Pounds and Inches)\n");
			this.unitType = 2;
		}	
		
	}
	
	private void readMeasurementData()
	{
		// calls metric or imperial method depending on user's selection
		if (this.unitType == 1)
		{
			readMetricData();
		}
		else if (this.unitType == 2)
		{
			readImperialData();
		}

	}
	
	private void readMetricData()
	{
		// we want to read in metric data if user selected metric units 
		Scanner in = new Scanner(System.in);
		
		// allow user to enter in weight in kilograms and height in meters
		System.out.println("Please enter your weight in kilograms:");
		setWeight(in.nextDouble());
		
		System.out.println("Please enter your height in meters:");
		setHeight(in.nextDouble());		
	}
	
	private void readImperialData()
	{
		// we want to read in imperial data if user selected imperial units 
		Scanner in = new Scanner(System.in);
		
		// allow user to enter in weight in pounds and height in inches
		System.out.println("Please enter your weight in pounds:");
		setWeight(in.nextDouble());
		
		System.out.println("Please enter your height in inches:");
		setHeight(in.nextDouble());		
	}
	
	public double calculateBmi()
	{
		// formula for calculating BMI in imperial(pounds/inches): ( (703 * weightInPounds) / heightInInches^2 )
		// formula for calculating BMI in metric(Kilograms/meters): (weightInKilograms / heightInMeters^2)
		// math to calculate bmi
		// declare variables to store the weight and height in both unit types
		double weightInPounds = this.weightInPounds;
		double heightInInches = this.heightInInches;
		double weightInKilograms = this.weightInKilograms;
		double heightInMeters = this.heightInMeters;
		double bmi = 0.0;
		
		// if the user entered 2 for imperial units then calculate bmi using imperial units
		if (this.unitType == 2)
		{
			bmi = ( (703 * weightInPounds) / (heightInInches * heightInInches) );
		}
		// if the user entered 1 for metric units then calculate bmi using metric units
		else if (this.unitType == 1)
		{
			bmi = weightInKilograms / (heightInMeters * heightInMeters);
		}
		// set bmi value
		this.bmi = bmi;
		// return bmi value
		return this.bmi;
	}
	
	private int calculateBmiCategory()
	{
		// declare variables to store bmi
		double BMI = this.bmi;
		int bmiCategory = 0;

		// BMI Categories
		// Underweight = <18.5
		// Normal weight = 18.5-24.9
		// Overweight = 25-29.9
		// Obesity = BMI of 30 or greater.
		
		// if bmi is less than 18.5 then set bmi category to 1 to represent underweight category
		if (BMI < 18.5)
		{
			bmiCategory = 1;
		}
		// if bmi is between 18.5 and 24.9 then set bmi category to 2 to represent normal weight category
		else if (BMI >= 18.5 && BMI <= 24.9)
		{
			bmiCategory = 2;
		}
		// if bmi is between 25 and 29.9 then set bmi category to 3 to represent overweight category
		else if (BMI >= 25 && BMI <= 29.9)
		{
			bmiCategory = 3;
		}	
		// if bmi is greater than or equal to 30 then set bmi category to 4 to represent obesity category
		else if (BMI > 30)
		{
			bmiCategory = 4;
		}	
		
		// set bmi category
		this.bmiCategory = bmiCategory;
		// return bmi category 
		return this.bmiCategory;
				
	}
	
	public void displayBmi() 
	{
		// declare a variable to store the calculate bmi category
		int bmiCategory = calculateBmiCategory(); 
		// BMI Categories
		// Underweight = <18.5
		// Normal weight = 18.5-24.9
		// Overweight = 25-29.9
		// Obesity = BMI of 30 or greater.
		
		// if the bmi category is 1 then display bmi and show that bmi is in underweight category
		if (bmiCategory == 1)
		{
			System.out.printf("\nYour BMI is: %.1f\n", this.bmi);
			System.out.printf("%.1f is in the Underweight category. (Underweight = <18.5)\n", this.bmi);
		}
		// if the bmi category is 1 then display bmi and show that bmi is in normal weight category
		else if (bmiCategory == 2)
		{
			System.out.printf("\nYour BMI is: %.1f\n", this.bmi);
			System.out.printf("%.1f is in the Normal weight category. (Normal weight = 18.5-24.9)\n", this.bmi);
		}
		// if the bmi category is 1 then display bmi and show that bmi is in overweight category
		else if (bmiCategory == 3)
		{
			System.out.printf("\nYour BMI is: %.1f\n", this.bmi);
			System.out.printf("%.1f is in the Overweight category. (Overweight = 25-29.9)\n", this.bmi);
		}
		// if the bmi category is 1 then display bmi and show that bmi is in obesity category
		else 
		{
			System.out.printf("\nYour BMI is: %.1f\n", this.bmi);
			System.out.printf("%.1f is in the Obesity category. (Obesity = BMI of 30 or greater)\n", this.bmi);
		}
		
		
	}
	
	public double getWeight()
	{
		// if the user enters in 1 for unit type then return back the weight in kilograms
		if (this.unitType == 1)
		{
			return this.weightInKilograms;
		}// if the user enters in 2 for the unit type then return back the weight in pounds
		else if (this.unitType == 2)
		{
			return this.weightInPounds;
		}
		return 0.0;
	}
	
	public void setWeight(double weight)
	{
		// declare variable to store the passed in weight
		double userWeight = weight;
		
		// if the user enters in a negative number for their weight then exit the program with a message
		if (userWeight < 0)
		{
			// enter code for negative weight exiting program
			System.out.println("\nProgram exiting, you entered a negative value for weight. Goodbye.");
			System.exit(1);
		}
		// if user enters 1 for unit type then set the user weight in kilograms
		if (this.unitType == 1)
		{
			this.weightInKilograms = userWeight;
		}
		// if user enters 2 for unit type then set the user weight in pounds
		else if (this.unitType == 2)
		{
			this.weightInPounds = userWeight;
		}		
	}
	
	// get the height
	public double getHeight()
	{
		// if the user entered in 1 for unit then return the height in meters
		if (this.unitType == 1)
		{
			return this.heightInMeters;
		}
		// if the user entered in 2 for units then return the height in inches
		else if (this.unitType == 2)
		{
			return this.heightInInches;
		}
		return 0.0;
	}
	
	// set the height
	public void setHeight(double height)
	{
		// declare variable to store the passed in height
		double userHeight = height;

		// check to see if the user height is a negative number, if so exit the program with a nice message
		if (userHeight < 0)
		{
			// enter code for entering negative height exiting programs
			System.out.println("\nProgram exiting, you entered a negative value for height. Goodbye.");
			System.exit(1);
		}
		if (this.unitType == 1)
		{
			// if the user entered in 1 for the units then read in meters for height
			this.heightInMeters = userHeight;
			
		}
		else if (this.unitType == 2)
		{
			// if the user entered in 2 for the units then read in inches for height
			this.heightInInches = userHeight;
		}
	}
	
	public double getBmi()
	{
		// return the value of bmi 
		return this.bmi;
	
	}
	
	public int getBmiCategory() 
	{
		// return the value of the bmi category
		return this.bmiCategory;
	}
	
	public static void main(String[] args) 
	{
		
		// the program should exit if the user enters a negative weight OR height
		// displays BMI and BMI category
		// should make sure they pick a valid type of units
		
		// formula for calculating BMI in imperial(pounds/inches): ( (703 * weightInPounds) / heightInInches^2 )
		// formula for calculating BMI in metric(Kilograms/meters): (weightInKilograms / heightInMeters^2)
		
		// BMI Categories 
			// Underweight = <18.5
			// Normal weight = 18.5-24.9
			// Overweight = 25-29.9
			// Obesity = BMI of 30 or greater
		// make new bmicalc object and then call the necessary methods
		
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
		
	}

}
