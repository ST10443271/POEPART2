/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121.poepart1;

import java.util.regex.Pattern;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static prog5121.poepart1.Account.passwordLogin;
import static prog5121.poepart1.Account.regPassword;
import static prog5121.poepart1.Account.taskDescription;
import static prog5121.poepart1.Account.userName;
import static prog5121.poepart1.Account.usernameLogin;

public class Login {
    public static boolean checkUserName(String userName){
        return userName.length()<=5 && userName.contains("_");
    }

    public static boolean checkPasswordComplexity(String regPassword){
        return regPassword.length()>=8 && regPassword.matches(".*[A-Z].*" )&& regPassword.matches(".*?["+ Pattern.quote("!@#$%^&*()_-+={}[]:;'<>,.?\'|")+ "].*");
    }

    public static String registerUser(){
        String message;
        if(!checkUserName(userName)){
            message="Your username is incorrect, try again";
        } else if(!checkPasswordComplexity(regPassword)){
            message = "Your password is incorrect, try again";
        }else{
            message = "press 'okay' in order to continue";
        }
        return message;
    }

    public static boolean loginUser(String userName, String regPassword, String usernameLogin, String passwordLogin){
        return userName.equals(usernameLogin) && regPassword.equals(passwordLogin);
    }

    public static String returnLoginStatus( String firstName, String lastName){
        String Output;
        if (!loginUser(userName, regPassword, usernameLogin, passwordLogin)){
            Output = "Failed to login.";
        } else{
            Output = "You have successfully login in";
        }
        return Output;
    }

    static class Task {
        private String taskName;
        private String taskDescription;
        private String developerDetails;
        private int taskDuration;
        private String taskStatus;
        private int taskNumber;
        
        public static boolean checkTaskDescription(String taskDescription){
            if (taskDescription.length() <= 50){
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 charcters");
            
            return false;
        }else{
                JOptionPane.showMessageDialog(null, "Task successfully captured");
            return true;
            }
                
            }
        public String createTaskID (int taskNumber, String developerDetails){
            String taskID = taskName.substring(0, Math.min( taskName.length(), 2)).toUpperCase();
            taskID += ":" + taskNumber + ":" + developerDetails.substring(Math.max(developerDetails.length(), 2)).toUpperCase();
           return taskID;
        }

        public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration) {
            this.taskName = taskName;
            
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
        }

        public void printTaskDetails() {
            String taskID = createTaskID (taskNumber, developerDetails);
            String taskDetails = "Task Status:" + taskStatus + "\n" +
                                 "Developer Details:" + developerDetails + "\n" +
                                "Task Number:" + taskNumber + "\n" +
                                "Task Name:" + taskName + "\n" +
                                "Task Description:" + taskDescription + "\n" +
                                "Task ID:" + taskID + "\n" +
                                "Task Duration:" + taskDuration + "\n" + "hours";
            
            JOptionPane.showMessageDialog(null, taskDetails);
        }

        public int returnTotalHours(){
            return taskDuration;
        }
        public void enterTaskDetails(int taskNumber) {
            taskName = JOptionPane.showInputDialog("Enter Task Name for Task " + taskNumber + ":");
            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters) for Task " + taskNumber + ":");
            checkTaskDescription(taskDescription);
            developerDetails = JOptionPane.showInputDialog("Enter Developer Details for Task " + taskNumber + ":");
            taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours) for Task " + taskNumber + ":"));
            taskStatus = (String) JOptionPane.showInputDialog(null, "Choose Task Status for Task " + taskNumber + ":", "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Done", "Doing"}, "To Do");
           printTaskDetails(taskNumber);
        }

        private void printTaskDetails(int taskNumber) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
    


    
    
   



//Code attribution
//This method was taken from stack overflow
//https://stackoverflow.com/questions/19152656/if-boolean-condition-in-java
//Arafe Zawad Sajid
//https://stackoverflow.com/users/6763091/arafe-zawad-sajid
