import java.util.Scanner;
import java.util.Arrays;

class main_user
{
/*------------------------------------------Registration Module------------------------------*/
public void register()
{
    
    Scanner in = new Scanner(System.in);
        System.out.println("Give Your Registartion Details");	
        System.out.println("Enter name: ");	
        String name=in.nextLine();
        while(name.length()!=0)
        {
            System.out.println("Enter age: ");	
            int age=in.nextInt();
            if (age>10)
            {
    	        System.out.println("You are eligible");
            }
            else
            {
                System.out.println("You are not eligible");
                register();
                
            }
            break;
        }
   
    System.out.println("welcome to "+name);
}
/*--------------------------------------------Menu Module----------------------------*/
public void menu()
{
    
    Scanner in1 = new Scanner(System.in);
    System.out.println("Your Quiz Profile");
    System.out.println("1.Select Subject For Quiz: - press 1");
    System.out.println("2.Add Friend To Play - press 2");
    System.out.println("3.Create Your Own Quiz - press 3");
    System.out.println("4.Exit - press 4");
    int ch2=in1.nextInt();
    switch(ch2)
            {
                case 1:
                    select_subject();
                    break;
                case 2:
                    addfriend();
                    break; 
                case 3:
                    addquiz();
                    break;
                        
                case 4:
                    Exit();
                    break;
                
            }
   
}
/*--------------------------------------Subject Module-------------------------*/
public void select_subject()
{
    Scanner in5=new Scanner(System.in);
    System.out.println("Select your Subject to play Quiz");
    System.out.println("1.Computer Science - Press 1");
    int ch=in5.nextInt();
    switch(ch)
    {
        case 1:
            System.out.println("Select Sub Topic Of Computer Science Subject");
            System.out.println("1.Data Structure - press 1");
            System.out.println("2.DBMS - Press 2");
            int ch1=in5.nextInt();
            switch(ch1)
            {
                case 1:
                    System.out.println("You are selected Data Structure");
                   menu();
                   /*play quiz module is pending*/
                    break;
                case 2:
                    System.out.println("You are selected DBMS");
                    menu();
                     /*play quiz module is pending*/
                    break;
                
            }
            
            
        
    }
    
    
    
}
/*--------------------------------------Add Friend Module---------------------------------*/
private void addfriend()
{
    System.out.println("You can Enter Only Five Friend name");
 Scanner in2 = new Scanner(System.in);
 String add_guest[]=new String[6];
  for (int i=1;i<=5;i++)
   {
     
     System.out.println("Enter Friendname "+i+": ");	
   
     add_guest[i]=in2.next();
     
   }
 System.out.println(Arrays.toString(add_guest));
    menu();
}
/*-------------------------------------------Add Quiz Module-----------------------------*/
public void addquiz()
{
     String Question="";
     Scanner in3 = new Scanner(System.in);
     System.out.println("How many Question Do you want to Add:");
     int no=in3.nextInt();
     String creator="Trivia Team";
 for (int i=0;i<=no;i++)
 {
    Question=in3.nextLine();
     System.out.println("Add Question "+i+": ");	
     
   
     
     
 }
 System.out.println("Question is : " +Question);
 System.out.println("Created By:  "+creator);
addoption();    
    
    
    
}

/*-------------------------------Add Option module-----------------------------------*/
public void addoption()
{
 Scanner in4 = new Scanner(System.in);
 System.out.println("How many Option Do you Want to Add:");
 int no=in4.nextInt();
int add_option[]=new int[no];
System.out.println("Note:Select Numeric number for option");
 for (int i=1;i<=no;i++)
 {
     
     System.out.println("Add Option "+i+":");	
   
     add_option[i]=in4.nextInt();
     
 }
 System.out.println(add_option);
}

/*----------------Exit-Module---------------------------------------*/
public void Exit()
{
    Scanner Exit_data=new Scanner(System.in);
     System.out.println("Do you Want to Exit -- yes/no");
                    String ans_response=Exit_data.next();
                    String yes="yes";
                    String no="no";
                
                   if(ans_response.equals(yes))
                    {
                    System.out.println("You are Exit");
                    }
                    else if(ans_response.equals(no))
                    {
                    System.out.println("Oops Something went wrong!!");
                    menu();
                    }
                    else
                    {
                        System.out.println("Wrong Choice");
                        Exit();
                    }
}
    
}
class guest_member extends main_user
{
    
    
    public void guest_user()
{
    Scanner g_name = new Scanner(System.in);
    System.out.println("Give Your Nickname: ");	
    String guest_name=g_name.nextLine();
    System.out.println("welcome To "+guest_name+"");
    
    
}

}
public class Main
{
    int qus_no;
    String Ques;
    String ans;
    static String creator="xyz person";
    Main(int no,String Question)
    {
        qus_no=no;
        Ques=Question;
    }
    Main(int no,String Question,String answer)
    {
        qus_no=no;
        Ques=Question;
        ans=answer;
    }
    void view()
    {
        System.out.println("questio no is :"+qus_no);
        System.out.println("questio is :"+Ques);
        System.out.println("answer is :"+ans);
        System.out.println("created by :"+creator);
        
    }
    static void change_name()
    {
        creator="ABC Person";
    }
	public static void main(String[] args) 
	{
	    System.out.println("Please Select your Role:");
        Scanner Sel_role=new Scanner(System.in);
        System.out.println("1. Main User ");
        System.out.println("2. Guest ");
         System.out.println("3. view Question ");
        int role=Sel_role.nextInt();
    if(role==1)
    {
        main_user obj=new main_user();
        obj.register();
        obj.menu();
    }
    else if(role==2)
    {
        guest_member obj1=new guest_member();
        obj1.guest_user();
        obj1.Exit();
    }
    else if(role==3)
    {
        Main.change_name();
        Main obj_view=new Main(1,"what is java");
        Main obj_view1=new Main(1,"what is c","programming language");
        obj_view.view();
        obj_view1.view();
        
        
        
        
    }
    else
    {
        System.out.println("please enter valid Choice");
        /*main(); can we call main mathod within main method*/
    }
    
    
      
    }


}





