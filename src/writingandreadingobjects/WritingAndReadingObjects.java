/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package writingandreadingobjects;

import java.io.*;
import java.util.Scanner;


/**
 *
 * @author etwat3497
 */
public class WritingAndReadingObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File newFile = new File("students.dat");
        int numOfStudents = 0, studentScore = 0;
        String studentName = "";
        
        
        try{
            FileOutputStream out = new FileOutputStream(newFile);
            ObjectOutputStream writeFile = new ObjectOutputStream(out);
            
            Scanner input = new Scanner(System.in);
            System.out.println("How many students are there?");
            numOfStudents = Integer.parseInt(input.nextLine());
            
            for(int i=0; i<numOfStudents; i++){
                System.out.println("What is the students name?");
                studentName = input.nextLine();
                System.out.println("What is "+studentName+"'s score?");
                studentScore = Integer.parseInt(input.nextLine());
                writeFile.writeObject(new Student(studentName,studentScore));
                writeFile.close();
                System.out.println("Data written to file");
                
                FileInputStream in = new FileInputStream(newFile);
                ObjectInputStream readFile = new ObjectInputStream(in);
                Student stu1 = (Student)readFile.readObject();
                Student stu2 = (Student)readFile.readObject();
                readFile.close();
                
                System.out.println(stu1);
                System.out.println(stu2);
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println("File could not be found");
        }
        catch(IOException e){
            System.out.println("Problem with input/output");
        }
        catch(ClassNotFoundException e){
            System.out.println("Class could not be used to cast object");
        }
        
    }
    
}
