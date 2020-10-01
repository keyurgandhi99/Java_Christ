import java.util.*;
class Main_User
{
/*------------------------------------------Registration Module------------------------------*/
public void registerUser()
{
    
        Scanner register_input = new Scanner(System.in);
        System.out.println("Please Provide Your Registartion Details");	
        System.out.print("FirstName: ");
        String first_Name = register_input.nextLine();
        System.out.print("LastName: ");
        String last_Name = register_input.nextLine();
        while(first_Name.length()!=0 || last_Name.length()!=0)
        {
            System.out.print("Age: ");	
            int user_Age = register_input.nextInt();
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
    System.out.println("4.Exit From Quiz - Press 4");
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
                   mainMenu();
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
public void createQuiz()
{
    ArrayList<String> question_List = new ArrayList<String>();
    String Questions = "";
    int no_Questions,ques;
    String creator="Funlyy Team";
    System.out.print("How many Questions Do you want to Add:");
    Scanner select_Questions = new Scanner(System.in);
    no_Questions = select_Questions.nextInt();
    for (ques=0; ques < no_Questions; ques++)
    {
     System.out.println("Add Question "+(ques+1));
     question_List.add(select_Questions.next()); //nextLine() is include the space nut here not working
     addOption();
    
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
 
 
    
 
 
    
}

/*-------------------------------Add Option module-----------------------------------*/
/*public void addOption()
{
    System.out.println("How many Option Do you Want to Add:");
    Scanner select_Option = new Scanner(System.in);
    int no_Options = select_Option.nextInt();
    int add_Option[] = new int[no_Options];
    System.out.println("Note: Select Only Numeric Value for option");
    for (int i=1; i <= no_Options; i++)
    {
     
        System.out.println("Add Option "+i+":");	
   
        add_Option[i] = select_Option.nextInt();
     
    }
 System.out.println(add_Option);
}*/

/*-------------------------------Extra Add Option module-----------------------------------*/


public void addOption()
{
    System.out.println("How many Option Do you Want to Add:");
    Scanner select_Option = new Scanner(System.in);
    int no_Options = select_Option.nextInt();
    ArrayList<String> options_List = new ArrayList<String>();
    for (int i=0; i < no_Options; i++)
    {
     
        System.out.println("Add Option "+(i+1)+":");	
        options_List.add(select_Option.next());
     
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
            System.out.println("You are Exit....Thank You For Playing Quiz");
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
    
}
/*-----------------------------------GuestUser-Module---------------------------------------*/

class Guest_User extends Main_User
{
    
    
    public void guestUser()
    {
        System.out.println("Give Your Nickname: ");	
        Scanner select_GuestName = new Scanner(System.in);
        String guest_Name = select_GuestName.nextLine();
        System.out.println("Welcome To "+guest_Name+"");
    }

}

public class Main
    {
        int question_No;
        String quiz_Question,quiz_Answer;
        static String quiz_Creator = "Funlyy Person";
        static{
            System.out.println("Welcome To Funlyy Trivia System");
        }
        Main(int que_No,String quiz_Que)
        {
            question_No = que_No;
            quiz_Question = quiz_Que;
        }
        
        Main(int que_No,String quiz_Que,String quiz_ans)
        {
            question_No = que_No;
            quiz_Question = quiz_Que;
            quiz_Answer = quiz_ans;
        }
        
        void view_Questions()
        {
            System.out.println("Question no is :"+question_No);
            System.out.println("Question is :"+quiz_Question);
            System.out.println("Answer is :"+quiz_Answer);
            System.out.println("Created by :"+quiz_Creator);
        
        }
        
        static void change_CreatorName()
        {   
            quiz_Creator = "ABC Person";
        }
        
	    public static void main(String[] args) 
	    {
	        System.out.println("Please Select your Role To Play Quiz Game:");
            Scanner select_Role = new Scanner(System.in);
            System.out.println("1. User ");
            System.out.println("2. Guest ");
            System.out.println("3. view Question ");
            System.out.print("Select Your Choice:");
            int Role = select_Role.nextInt();
            
            if(Role == 1)
            {
                Main_User obj_User = new Main_User();
                obj_User.registerUser();
                obj_User.mainMenu();
            }
            
            else if(Role == 2)
            {
                Guest_User obj_Guest=new Guest_User();
                obj_Guest.guestUser();
                obj_Guest.quizExit();
            }
            
            else if(Role == 3)
            {   
                Main.change_CreatorName();
                Main obj_ViewQuestion = new Main(1,"what is java");
                Main obj_ViewQuestion1 = new Main(1,"what is c","programming language");
                obj_ViewQuestion.view_Questions();
                obj_ViewQuestion1.view_Questions();
            }
            
            else
            {
                 System.out.println("Oops Something went wrong!!");
                /*main(); can we call main mathod within main method*/
            }
    }

}








