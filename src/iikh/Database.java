/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author oop31
 */

public class Database {
    String recipeName;
    ArrayList<String> indegrients;
    ArrayList<String> method;
    
    private String parsetoString(String recipeName, ArrayList<String> indegrients, ArrayList<String> method){
        String out = recipeName + ",,";
        for(String x: indegrients)
            out += (x + "::");
        out += ",,";
        for(String x: method)
            out += (x + "::");
        System.out.print( out + "vsd");
        return out;
    }
    
    public void addRecipe(String recipeName, ArrayList<String> indegrients, ArrayList<String> method){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/oop31/recipeList.txt", true)))) {
            out.println(parsetoString(recipeName, indegrients, method));  
            System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
        System.out.print("ksadlvbw");
    }
  
    public void getRecipe(String recipeName){
        BufferedReader br = null;
        this.recipeName = null;
        this.indegrients = null;
        this.method = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(recipeName)){
                    this.recipeName = recipeName;
                    this.indegrients = new ArrayList<String>(Arrays.asList(x[1].split("::")));
                    this.method = new ArrayList<String>(Arrays.asList(x[2].split("::")));
                }
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeRecipe(String recipeName, ArrayList<String> indegrients, ArrayList<String> method ){
        BufferedReader br = null;
	try {
            String line;
            br = new BufferedReader(new FileReader("recipeList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",");
                this.recipeName = recipeName;
                this.indegrients = new ArrayList<String>(Arrays.asList(x[1].split(":")));
                this.method = new ArrayList<String>(Arrays.asList(x[2].split(":")));
            }
	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getIndegrients(){
        return this.indegrients;
    }
    public ArrayList<String> getMethod(){
        return this.method;
    }
}
