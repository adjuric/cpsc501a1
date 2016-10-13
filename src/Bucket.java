/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 Buycket file given by the TA
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bucket{
	
	int depth;
	ArrayList<String> elements = new ArrayList<>();
	
	public Bucket(int depth) {
		this.depth = depth;
		this.elements.add("");
    }
	
	public void setDepth(int d){
		
			depth=d;
	
	}
	public int getDepth(){
		
			return depth;
	
	}
	
	public void insert(String value){
		
			elements.add(value); 
	
	}
	
	public void firstInsert(String value){
		
			elements.set(0, value);
	
	}
	
	public boolean full(){
		
		if (elements.size()<3)
			return false;
		else
			return true;
	}
	
	public void print(){
		 for(int i=0; i<elements.size(); i++){
              System.out.println(elements.get(i));
         }
	}
	
}