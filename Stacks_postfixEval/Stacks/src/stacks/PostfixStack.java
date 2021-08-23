 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author Devin
 */
public class PostfixStack {
    
    protected Stack<Integer> stack = new Stack<>();
    
    public int postfixEval(){
        
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a postfix expresssion!\n");
        
       
         String exp = sc.nextLine();
       
        
        
        
        //iterate through the expression
        for(int i = 0; i<exp.length(); i++){
            //will be the temporary character variable to determine 
            //if there is an integer or an operand throughout iteration
            char ch = exp.charAt(i);
            
            /* if the ch variable is an integer
            ** push it into the stack
            */
            if(Character.isDigit(ch)){
                stack.push(Character.getNumericValue(exp.charAt(i)));

            }else{
                /*if an operator is met, pop the last two
                  integers and push them back with the 
                  operand to evaluate
                
                **num1 and num2 represent the previous elements
                */
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                /*switch case to evaluate the expression
                  depending on the operand
                */
                switch(ch){
                    
                    case '^':
                        stack.push(num2 ^ num1);
                        break;
                    case '*': 
                        stack.push(num2 * num1);
                        break;
                    
                    //I need to add logic to prevent a divide by zero as well
                    //as make sure it can display a decimal.
                    case '/': //broken at the moment
                        stack.push(num2 / num1);
                        break;
                    case '+': 
                        stack.push(num2 + num1);
                        break;
                    case '-': 
                        stack.push(num2 - num1);
                        break;
                    /*I plan on playing with this in order to fix it.    
                    case '(': //throws an exception when used
                        stack.pop();
                        break;
                    case ')': //throws an exception when used
                        stack.pop();
                        break;
                    */
                    default: 
                        System.out.println("Error!");
                }
            }
            
               
            //output
           System.out.println(" " + stack);
        
        }
        
        System.out.println("Postfix Evaluation: " + stack);

        
       return stack.pop();
    }
    
}
