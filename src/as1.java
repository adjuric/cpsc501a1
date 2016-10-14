
/*
 File: as1.java
 Task: Given a text file load in all the values into a hash table.

    Author: Aleksandar Djuiric, 10057804
    Class: CPSC 335
    Assignment: 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class as1 {

	public static void main(String args[]) throws FileNotFoundException {

		// Check Number of Inputs
		if (args.length != 3) {
			System.out.println("Not enough given arguments, Criteria: File Name, Number of Keys,Bucket Size");
			System.exit(1);
		}
		String file_name;
		if(checkFileName(args[0])){
			file_name = args[0];
		}else{
			System.out.println("String is invalid");
			file_name = "";
		}
		int num_keys = checkNumKeys(args[1]);
		int bucket_size = checkBucketSize(args[2]);

		// Created Hashmap and table
		Map map = new HashMap(bucket_size, 1);
		Hashtable<String, Integer> table = new Hashtable<>(1);

		// Preparing to read the file for all the given information
		File myFile = new File(file_name);
		Scanner scan = new Scanner(myFile);

		if(readFile(num_keys, scan, table)){
			System.out.println("File Read without issues");
		}else{
			System.out.println("Error when reading the file");
		};

		// Storing keys to a hash table
		File newFile = new File(file_name);
		Scanner scanner = new Scanner(newFile);

		// Finding the key in the document
		if(findKey(num_keys, scanner, table)){
			System.out.println("Found the Key");
		}else{
			System.out.println("Key Was not found");
		}

		// Calculating the number of comparisons required to find a given key
		int comparisons = calcNumCompare(num_keys, bucket_size);
		System.out.printf("Average number of comparisons: %d\n", comparisons);
	}
	
	public static int checkBucketSize(String check){
		int bucket_size = 0;
		 bucket_size = Integer.parseInt(check);
		 if(bucket_size <= 0){
			 System.out.println("Bucket Size to Low");
		 }
		return bucket_size;
	}
	public static int checkNumKeys(String check){
		int num_keys = 0;
		 if(num_keys <= 0){
			 System.out.println("Not Enough keys");
		 }
		 num_keys = Integer.parseInt(check);
		return num_keys;
	}
public static boolean checkFileName(String check){
	boolean answer =false;
	if(!check.isEmpty()){
		answer = true;
	}
	return answer;
}
	
	public static boolean findKey(int num_keys, Scanner scanner, Hashtable<String, Integer> table) {
		String key;
		boolean found = false;
		
		for (int i = 0; i < num_keys; i++) {
			if (scanner.hasNext()) {
				key = scanner.nextLine();

				System.out.printf("For key \"%s\"\n", key);
				System.out.printf(" it is stored in Bucket: %d\n\n", table.get(key));
				found = true;
			} else {
				System.out.println("\nNot enough keys were given.\n");
				found = false;
			}
		}
		return found;
	}

	public static boolean readFile(int num_keys, Scanner scan, Hashtable<String, Integer> table) {
		String key;
		int buc_val;
		boolean passed = false;
		// Parse the file until the correct number of keys have been read, and
		// for each String read, perform a hash function to said string
		// in order to evaluate what bucket each key should be stored
		for (int i = 0; i < num_keys; i++) {

			if (scan.hasNext()) {
				// Reading the file line by line
				key = scan.nextLine();
				// Preforming the hash on each key
				buc_val = hashMask(key, num_keys);

				System.out.printf("Key = %s\n", key);
				System.out.printf("Hash Value = %d\n\n", buc_val);
				// Storing the key in the correct part of the hash table (in the
				// correct bucket)
				table.put(key, buc_val);
				passed = true;
			} else {
				System.out.println("\nNot enough keys were given.\n");
				passed = false;
			}
			
		}
		return passed;
	}

	public static int hashMask(String line, int num_keys) {
		int bitMask = 0x11110001;
		int bucket = 0;
		char[] conv = line.toCharArray();

		for (char c : conv) {
			bucket += (int) c;
		}
		bucket = bucket ^ bitMask;
		bucket = bucket % num_keys;
		return bucket;
	}

	public static int calcNumCompare(int num, int buck_size) {
		int ele = num;
		int total;
		int num_buc = 1;
		int i = 0;
		int pow = 0;
		while (ele != 0 && ele > 0) {
			pow = (int) Math.pow(2, i);
			ele = ele - (buck_size * pow);
			i++;
			num_buc = num_buc++;
		}
		num_buc = num_buc * buck_size;

		total = 1 + (num / num_buc) / 2;
		System.out.printf("TOTAL: %d\n", total);
		System.out.printf("TOTAL: %d\n", total);

		return total;
	}

}
