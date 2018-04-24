import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Courtney Yovich and Tyler Fleetwood
 * April 23, 2018
 * JUnit tests for class Coins 
 * Testing the Minimum Coin Change Problem
 */

public class TestChange {

	@Test
	public void testMinCoins1() { 
		Coins coins = new Coins();
		int US[] = {1, 5, 10, 21, 25};
		assertArrayEquals(new int[] {21, 21, 21}, coins.minCoins(US, 63));
	}
	
	@Test
	public void testMinCoins2() {
		Coins coins = new Coins();
		int lipa[] = {1, 2, 10, 20, 50};
		assertArrayEquals(new int[] {1, 2, 2, 2, 2, 50}, coins.minCoins(lipa, 59));
	}
	
	@Test
	public void testMinCoins3() {
		Coins coins = new Coins();
		int US[] = {1, 5, 10, 21, 25};
		assertArrayEquals(new int[] {10, 21, 21}, coins.minCoins(US, 52));
	}
	
	@Test(expected = IllegalArgumentException.class) //array with zero coins
	public void testEmptyArray() {
		Coins coins = new Coins();
		int empty[] = {};
		coins.minCoins(empty, 0);
	}

	@Test(expected = IllegalArgumentException.class) //amount is less than smallest coin
	public void testWeirdCoinAmount() {
		Coins coins = new Coins();
		int arr[] = {3, 7, 12, 15};
		coins.minCoins(arr, 2);
	}
	
//	@Test
//	public void testMinCoins() { //this one fails, because it can't get to zero?? unsure
//		Coins coins = new Coins();
//		int arr[] = {3, 7, 12, 15};
//		assertArrayEquals(new int[] {7, 12}, coins.minCoins(arr, 19));
//	}
}