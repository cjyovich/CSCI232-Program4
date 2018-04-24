import java.util.ArrayList;

/*
 * Courtney Yovich and Tyler Fleetwood 
 * April 23, 2018
 * Class to implement greedy algorithm
 * Minimum Coin Change Problem
 */

public class Coins {

	int coins[];
	int amount;

	public int[] minCoins(int arr[], int amt) { //dynamic programming solution
		amount = amt;
		int numCoins[] = new int[amt + 1];
		int coinsUsed[] = new int[amt + 1]; //this is what we'll use to store the coin amounts we need to return
		numCoins[0] = 0; // if amt is 0, it takes zero coins

		if (arr.length == 0) { //case: no coins? throw exception
			throw new IllegalArgumentException("Array of size zero is not allowed");
		}
		for( int i = 0; i < arr.length; i++){
			if (arr[i] <= 0){
				throw new IllegalArgumentException("No negative currency allowed in here my friend");
			}
		}
		
		for (int i = 1; i <= amt; i++) { //initialize array with some stuff!
			numCoins[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= amt; i++) { //iterates through amount by 1
			for (int j = 0; j < arr.length; j++) { //iterates through coin denominations
				if (arr[j] <= i && 1 + numCoins[i - arr[j]] < numCoins[i]) {
					numCoins[i] = 1 + numCoins[i - arr[j]];
					if (numCoins[i] < 0){
						coinsUsed[i] = 0;
					} else{
						coinsUsed[i] = arr[j]; //stores the coin amount
					}
				}
			}
		}
		ArrayList<Integer> change = new ArrayList<Integer>();
		int count = amount;
		while(count >= 1) { //now we need to go back through and find the actual coins we used...
			change.add(coinsUsed[count]);
			int temp = count;
			count = amount - coinsUsed[count];
			amount -= coinsUsed[temp];
		}
		coins = new int[change.size()];
		for (int i = 0; i < change.size(); i++) {
			coins[i] = change.get(i);
		}
		return coins; //and return them!
	}

}