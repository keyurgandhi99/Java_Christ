package java_christ_github;
import Guest_User_Registration.*;
import java.util.*;

class CustomException extends Exception { //userdefined exception
	  public CustomException(String message) {
	    // call the constructor of Exception class
	    super(message);
	  }
	}

interface Switch_User //interface 
{
	void switchuser();	
}

abstract class Registration  //abstract class
{
   abstract void registerUser(); // abstract method
}


class Main_User extends Registration implements Switch_User 
{
        
/*------------------------------------------Registration Module----------------------------------*/
String first_Name;
String last_Name;
int user_Age;
public void registerUser() 
{
    
	
        Scanner register_input = new Scanner(System.in);
        System.out.println("Please Provide Your Registartion Details");
        System.out.print("FirstName: ");
        first_Name = register_input.nextLine();
        System.out.print("LastName: ");
        last_Name = register_input.nextLine();
         
	
	    while(first_Name.length()!=0 || last_Name.length()!=0)
        {
        	
            System.out.print("Age: ");	
            user_Age = register_input.nextInt();
        	
            if (user_Age > 10)
            {
            	
                System.out.println("------------------------------------------------");
    	        System.out.println("Welcome to "+first_Name+" "+last_Name+" Thank you for registering");
            }
            else
            {
            	
                System.out.println("Oops!! , You Are Not Eligible Please Check Your Age");
                System.out.println("-------------------------------------------------");
                registerUser();
                
            }
            break;
        }
 
    
}
/*--------------------------------------------Menu Module----------------------------*/
public void mainMenu()
{
    
    
    System.out.println("----------------------Menu----------------------");
    System.out.println("1.Category: - Press 1");
    System.out.println("2.Add Friend To Play - Press 2");
    System.out.println("3.Create Quiz - Press 3");
    System.out.println("4.Your Profile - Press 4");
    System.out.println("5.Switch User Mode - Press 5");
    System.out.println("6.Exit From Quiz - Press 6");
    Scanner select_Menu = new Scanner(System.in);
    System.out.print("Select Your Choice:");
    int menu_Choice = select_Menu.nextInt();
    switch(menu_Choice)
            {
                case 1:
                    allCategory();
                    break;
                case 2:
                    addFriend();
                    break; 
                case 3:
                    createQuiz();
                    break;
                
                case 4:
                    viewProfile();
                    break; 
                    
                case 5:
                    switchuser();
                    break;     
                    
                case 6:
                    quizExit();
                    break;
                
            }
   
}
/*--------------------------------------Subject Module-------------------------*/
public void allCategory()
{
    Scanner select_subject = new Scanner(System.in);
    System.out.println("Please Select your Topics to play Quiz");
    System.out.println("1.Computer Science - Press 1");
    System.out.print("Select Your Choice:");
    int subTopic = select_subject.nextInt();
    switch(subTopic)
    {
        case 1:
            System.out.println("Select Sub Topics Of Computer Science Subject");
            System.out.println("1.Data Structure - press 1");
            System.out.println("2.DBMS - Press 2");
            System.out.print("Select Your Choice:");
            int choice_SubTopic = select_subject.nextInt();
            switch(choice_SubTopic)
            {
                case 1:
                    System.out.println("You are selected Data Structure");
                    playQuiz();
                    /*mainMenu();*/
                   /*play quiz module is pending*/
                    break;
                case 2:
                    System.out.println("You are selected DBMS");
                    mainMenu();
                     /*play quiz module is pending*/
                    break;
                
            }
            
            
        
    }
    
   
    
}

public void playQuiz()
{
	int i = 5;
	System.out.println("Your Quiz Start In:");
    while (i>0){
     	
     System.out.println(i+" - Seconds");
     try {
       i--;
       Thread.sleep(1000L);    // 1000L = 1000ms = 1 second //thread implemented 
       
       
       
      }
      catch (InterruptedException e) {
         
      }
    
    }
    System.out.println(question_List);
    
	
}
/*--------------------------------------Add Friend Module---------------------------------*/
private void addFriend()
{
    System.out.println("You can Add Only Five Friends");
    Scanner select_Friend = new Scanner(System.in);
    String add_friends[]=new String[6];
    System.out.println("Please Provide Your Friends Name");
    for (int i=1; i <= 5; i++)
    {
     
        System.out.print("Friend Name "+i+": ");	
   
       add_friends[i]=select_Friend.next();
     
    }
    System.out.println(Arrays.toString(add_friends));
    mainMenu();
}
/*-------------------------------------------Add Quiz Module-----------------------------*/
ArrayList<String> question_List = new ArrayList<String>();

public void createQuiz()
{
	Scanner select_No_Questions = new Scanner(System.in);
	System.out.print("How many Questions Do you want to Add:");
	int no_Questions=select_No_Questions.nextInt();

    
    String Questions = "";

    int ques;
    String creator="Funlyy Team";
	/*
	 * System.out.print("How many Questions Do you want to Add:"); Scanner
	 * select_Questions = new Scanner(System.in);
	 */
	/* no_Questions = select_Questions.nextInt(); */
    
    for (ques=0; ques < no_Questions; ques++)
    {
     System.out.println("Add Question "+(ques+1));
     Scanner select_Questions = new Scanner(System.in);
     question_List.add(select_Questions.nextLine()); //nextLine() is include the space but here not working
     try {
		addOption();
	} catch (CustomException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
    }
 
    for (int j = 0; j < question_List.size(); j++) 
    {
		   System.out.println("============================");    
		   System.out.print("Question "+(j+1)+" is:");
		   System.out.println(question_List.get(j));
		   System.out.println("Created By:  "+creator);
		   System.out.println("============================");   
		   //options shows work is pending
    }
 
 
    mainMenu(); 
 
    
}

/*-------------------------------Extra Add Option module-----------------------------------*/
ArrayList<String> options_List = new ArrayList<String>();

public void addOption() throws CustomException
{
	try
	{
    System.out.println("How many Option Do you Want to Add:");
    Scanner select_Option = new Scanner(System.in);
    int no_Options = select_Option.nextInt();
    
    for (int i=0; i < no_Options; i++)
    {
    	System.out.println("Add Option "+(i+1)+":");
    	String data=select_Option.next();
    	
    	if(options_List.contains(data))
    	{
    		throw new CustomException(options_List + " Option already exists");
    		
    	}
    	else
    	{
    		
            options_List.add(data);	
            
    	}
        
     
    }
	}
	catch (Exception e) {
	System.out.println("[" + e + "] Exception Occured");
	}

}
 
/*-------------------------------User Switch Mode module-----------------------------------*/
//interface implemented

public void switchuser()
{
	System.out.println("Do You Want to Switch User Mode");
	Scanner select_Mode = new Scanner(System.in);
    String Mode_Response = select_Mode.next();
    String yes = "yes";
    String no = "no";
                
    if(Mode_Response.equals(yes))
        {
           TriviaSystem.main(null);
            
        }
    else if(Mode_Response.equals(no))
        {
            mainMenu();
        }
    else
        {
            System.out.println("Oops Something went wrong!!");
            mainMenu();
        }
	

}
/*-----------------------------------Exit-Module---------------------------------------*/
public void quizExit()
{
    System.out.println("Do you Want to Exit -- yes/no");
    Scanner select_Exit = new Scanner(System.in);
    String exit_Response = select_Exit.next();
    String yes = "yes";
    String no = "no";
                
    if(exit_Response.equals(yes))
        {
            final String greetings="You are Exit....Thank You For Playing Quiz";  //final keyword
            System.out.println(greetings);
        }
    else if(exit_Response.equals(no))
        {
            mainMenu();
        }
    else
        {
            System.out.println("Oops Something went wrong!!");
            quizExit();
        }
}

/*--------------------------------------------------------profile module-----------------------------------*/
public void viewProfile()
{
    System.out.println("--------------Profile--------------");
    System.out.println("First Name :" +first_Name);
    System.out.println("Last Name :" +last_Name);
    System.out.println("Age :" +user_Age);
    System.out.println("Total Created Quiz :" +question_List.size());
    System.out.println("-----------------------------------");
    mainMenu();
}


}



/*-----------------------------------Guest User-Module---------------------------------------*/
class Guest_User1 extends Main_User
{ 
    public void mainGuestMenu()
{
    
    
    System.out.println("----------------------Menu----------------------");
    System.out.println("1.Category: - Press 1");
    System.out.println("2.Create Quiz - Press 2");
    System.out.println("3.Exit From Quiz - Press 3");
    Scanner select_Menu = new Scanner(System.in);
    System.out.print("Select Your Choice:");
    int menu_Choice = select_Menu.nextInt();
    switch(menu_Choice)
            {
                case 1:
                    allCategory();
                    break;
                case 2:
                    createQuiz();
                    break;
                case 3:
                    userExit();
                    break;
                
            }
   
}

    
/*-----------------------------------Exit-User-Module---------------------------------------*/
public void userExit()
{
    System.out.println("Do you Want to Exit -- yes/no");
    Scanner select_Exit = new Scanner(System.in);
    String exit_Response = select_Exit.next();
    String yes = "yes";
    String no = "no";
                
    if(exit_Response.equals(yes))
        {
            System.out.println("You are Exit....Thank You For Playing Quiz");
        }
    else if(exit_Response.equals(no))
        {
            mainGuestMenu();
        }
    else
        {
            System.out.println("Oops Something went wrong!!");
            userExit();
        }
}


    
    
}
/*--------------Main class----------------------*/

public class TriviaSystem
    {
        int question_No;
        String quiz_Question,quiz_Answer;
        static String quiz_Creator = "Funlyy Person"; //static variable
        static{  //static block    
            System.out.println("Welcome To Funlyy Trivia System");
        }
        TriviaSystem(int question_No,String quiz_Question) //constructor
        {
            this.question_No = question_No; //this keyword
            this.quiz_Question = quiz_Question;
        }
        
        TriviaSystem(int que_No,String quiz_Que,String quiz_ans) //constructor
        {
            question_No = que_No;
            quiz_Question = quiz_Que;
            quiz_Answer = quiz_ans;
        }
        
        void view_Questions() //view_Questions method
        {
            System.out.println("Question no is :"+question_No);
            System.out.println("Question is :"+quiz_Question);
            System.out.println("Answer is :"+quiz_Answer);
            System.out.println("Created by :"+quiz_Creator);
        
        }
        
        static void change_CreatorName() //change creator name method 
        {   
            quiz_Creator = "ABC Person";
        }
        
	    public static void main(String[] args)  //main method
	    {
	        System.out.println("Please Select your Role To Play Quiz Game:");
            Scanner select_Role = new Scanner(System.in);
            System.out.println("1. User ");
            System.out.println("2. Guest ");
            System.out.println("3. view Question ");
            System.out.print("Select Your Choice:");
            /*int Role = Integer.parseInt(args[1]);*/ //command line argument
            int Role = select_Role.nextInt();
            
            if(Role == 1)
            {
                Main_User obj_User = new Main_User(); //main user create Object
                obj_User.registerUser();
                obj_User.mainMenu();
            }
            
            else if(Role == 2)
            {
                Guest_User obj_Guest=new Guest_User(); //guest user create object of package class 
                obj_Guest.guestUser();//call method of package class
                Guest_User1 obj_Guest1=new Guest_User1();
                obj_Guest1.mainGuestMenu();
            }
            
            else if(Role == 3) //show Question menu
            {   
                TriviaSystem.change_CreatorName();
                TriviaSystem obj_ViewQuestion = new TriviaSystem(1,"what is java");
                TriviaSystem obj_ViewQuestion1 = new TriviaSystem(1,"what is c","programming language");
                obj_ViewQuestion.view_Questions();
                obj_ViewQuestion1.view_Questions();
            }
            
            else
            {
                 System.out.println("Oops Something went wrong!!");
                /*main(); can we call main method within main method*/
            }
            
            
            
            
    }

}


















