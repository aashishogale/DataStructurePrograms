package com.bridgelabz.Utility;

public class Util {
	public static long possibleCombinations(int totalNodes){
		long possibleTrees=0;
		int count=0;
		if(totalNodes==1||totalNodes==0)
			return 1;
		else {
			
			while(count<totalNodes) {
				count++;
				possibleTrees=possibleTrees+possibleCombinations((int)count-1)*possibleCombinations((int)totalNodes-count);
			}
			return possibleTrees;
}

}
	public static int dayOfWeek(int mYear,int mMonth){

        int mDay = 1;

        //Calculate the date fall on
        int y = mYear - (14 - mMonth) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = mMonth + 12 * x * ((14 - mMonth) / 12) - 2;
        int d = (mDay + x + 31 * m / 12) % 7;

        //returns falllon date
        return d;
    }

   public static boolean isLeapOrNot(int mYear){
        boolean mIsLeap = false;
        if( mYear >= 1582 ) {
            mIsLeap = (mYear % 4) == 0;
            mIsLeap = mIsLeap && (mYear % 100) != 0;
            mIsLeap = mIsLeap || (mYear % 400) == 0;
        }
        if( mIsLeap == true )
            return mIsLeap;
        else
            return mIsLeap;

    }
   public static void storeArray(String[][] daysArray, int month, int year) {
		// TODO Auto-generated method stub
	   String weekDays[] = { "Sun", "Mon", "Tue", "Wed", "Th", "Fri", "Sat" };
		int daysInMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int dayCount = 1;
		
		int startDay = dayOfWeek(year, month);
		int j = 0;
		if (isLeapOrNot(year)) {
			daysInMonth[2] = 29;
		}
		for (int i = 0; i < 7; i++) {
			daysArray[j][i] = weekDays[i];
		}
 System.out.println(startDay);
		for (int i = 1; i < 7; i++) {
			for (j = 0; j < 7; j++)
				if (startDay >= dayCount) {
					daysArray[i][j] = " ";
					startDay--;

				} else if (dayCount <= daysInMonth[month]) {
					daysArray[i][j] = String.valueOf(dayCount);
					dayCount++;
				} else {
					daysArray[i][j] = " ";
				}
		}
}

  public  static void displayCal(int mYear,int mMonth){
        int date = dayOfWeek(mYear,mMonth);
        System.out.println(date);
        int mNumber = 1;
        int counter = 0;
        String[] months = {"","January","February","March",
                            "April","May","Jun","July",
                            "August","September","Octomber",
                            "November","December"};

        int[] mMonthsNOLeap = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        boolean isLeap = isLeapOrNot(mYear);
        if(isLeap == true) {
            mMonthsNOLeap[2] = 29;
        }

        int i = mMonth;
        System.out.println("   "+months[i] + "   " + mYear);
        System.out.println("=====================");
        System.out.println("S  M  T  W  T  F  S");
        System.out.println("====================");
        for(int k = 0; k < 6; k++ ){
            for(int j = 0; j < 7; j++ ){
                if(counter < date){
                    System.out.print("   ");
                    counter++;
                }
                else if(mNumber <= mMonthsNOLeap[mMonth]) {
                    System.out.print(mNumber);
                    mNumber++;
                    if(mNumber < 11)
                        System.out.print("  ");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }

}
  public static boolean checkPrime(int number) {

		// condition to check if no less than two
		if (number < 2) {
			return false;
		}

		// for loop to for checkin prime no
		for (int factor = 2; factor * factor <= number; factor++) {
			// if factor divides evenly into n, n is not prime, so break out of
			// loop
			if (number % factor == 0) {
				return false;

			}
		} // End of for loop
		return true;
	}
	public static boolean checkAnagram(int number1, int number2) {

		int count1 = numberCount(number1);
		int count2 = numberCount(number2);
		int count = 0;

		if (count1 != count2)
			return false;

		// convert the numbers to array
		int arr1[] = new int[count1];
		int arr2[] = new int[count2];

		convertIntArray(arr1, number1);
		convertIntArray(arr2, number2);

		// Sort the integer
		arr1 = sortInt(arr1);
		arr2 = sortInt(arr2);

		// check if digits are equal
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count == arr1.length;

	}
	public static void convertIntArray(int[] array, int number) {
		int i = 0;

		while (number != 0) {
			array[i] = number % 10;
			number = number / 10;
			i++;
		}

	}

public static int numberCount(int number) {
	int count = 0;
	int tempno = number;

	// find the number of digits of first number
	while (tempno != 0) {
		tempno = tempno / 10;
		count++;

	}
	return count;

}
public static int[] sortInt(int[] array) {
	int temp;

	for (int i = 0; i < array.length; i++) {
		for (int j = 1; j < array.length - i; j++) {
			if (array[j - 1] > array[j]) {
				temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
			}
		}
	}

	return array;
}


public static int removeDuplicates(int arr[], int n)
{
    // Return, if array is empty
    // or contains a single element
    if (n==0 || n==1)
        return n;
 
    int[] temp = new int[n];
    
    // Start traversing elements
    int j = 0;
    for (int i=0; i<n-1; i++)
        // If current element is not equal
        // to next element then store that
        // current element
        if (arr[i] != arr[i+1])
            temp[j++] = arr[i];
    
    // Store the last element as whether
    // it is unique or repeated, it hasn't
    // stored previously
    temp[j++] = arr[n-1];   
    
    // Modify original array
    for (int i=0; i<j; i++)
        arr[i] = temp[i];
 
    return j;
}
}
