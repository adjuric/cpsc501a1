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

//Checking if the number of inputs is correct
        if (args.length != 3) {
            System.out.println("Not enough given arguments, Criteria: File Name, Number of Keys");
            System.exit(1);
        }

        String file_name = args[0];
        int num_keys = Integer.parseInt(args[1]);
        int bucket_size = Integer.parseInt(args[2]);


//Initalizing a HASH map, and Hashtable
        Map map = new HashMap(bucket_size,1);
        Hashtable<String, Integer> table = new Hashtable<>(1);


//Preparing to read the file for all the given information
        File myFile = new File(file_name);
        Scanner scan = new Scanner(myFile);
        
        readFile(num_keys,scan,table);


//Reading the keys from the file and locating them in the hash table.
        File newFile = new File(file_name);
        Scanner scanner = new Scanner(newFile);

        //Going through the entire document and locating where a spefic key is located.
        findKey(num_keys,scanner,table);
        

//Calculating the number of comparisons required to find a given key
        int comparisons = calcNumCompare(num_keys, bucket_size);
        System.out.printf("Average number of comparisons: %d\n", comparisons);
    }
    
    private static void findKey(int num_keys, Scanner scanner,Hashtable<String, Integer> table){
    	 String key;
    	
    	for (int i = 0; i < num_keys; i++) {
            if (scanner.hasNext()) {
                key = scanner.nextLine();


                System.out.printf("For key \"%s\"\n", key);
                System.out.printf(" it is stored in Bucket: %d\n\n", table.get(key));
            } else {
                System.out.println("\nNot enough keys were given.\n");
            }
        }
    }
    
    private static void readFile(int num_keys,Scanner scan, Hashtable<String, Integer> table  ){
    	 String key;
         int buc_val;
    	
    	//Parse the file until the correct number of keys have been read, and for each String read, perform a hash function to said string
    	// in order to evaluate what bucket each key should be stored
    	        for (int i = 0; i < num_keys; i++) {
    	           
    	            
    	            if (scan.hasNext()) {

    	                //Reading the file line by line
    	                key = scan.nextLine();
    	                //Preforming the hash on each key
    	                buc_val = hash(key,num_keys);

    	                System.out.printf("Key = %s\n", key);
    	                System.out.printf("Hash Value = %d\n\n", buc_val);
    	                //Storing the key in the correct part of the hash table (in the correct bucket)
    	                table.put(key, buc_val);
    	            } else {
    	                System.out.println("\nNot enought keys were given.\n");
    	            }
    	        }	
    }

    private static int hash(String line, int num_keys) {
        int bitMask = 0x11110001;
        int bucket = 0;
        char[] conv = line.toCharArray();
       
        for (char c : conv) {
            bucket += (int) c;
        }
        bucket = bucket^bitMask;
        bucket = bucket % num_keys;
        return bucket;
    }
    
    private static int calcNumCompare(int num, int buck_size){
        //return (int)Math.round(Math.random()*(num-1)) + 1;
        int ele = num;
        int total;
        int num_buc = 1;
        int i = 0;
        int pow = 0;
        while(ele != 0 && ele > 0){
            pow = (int) Math.pow(2,i);
            ele = ele - (buck_size*pow);
            i++;
            num_buc = num_buc++;
        }
        num_buc = num_buc*buck_size;
        
         total = 1 + (num/num_buc)/2; 
        System.out.printf("TOTAL: %d\n", total);
        System.out.printf("TOTAL: %d\n", total);
       
        return total;
    }

}
