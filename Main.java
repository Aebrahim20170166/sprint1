package sprint1_files;

import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	  public static void main(String[] args) throws Exception {
	    userModel dao = new userModel();
	    dao.connect();
	    Scanner input=new Scanner(System.in);
        UserController user=new UserController();
        boolean exit=true;
        int num;
        while(exit)
        {
            System.out.println("Welcome to our online store");
            System.out.println("1-To register in our online store please inter 1");
            System.out.println("2-To signIn in our online store please inter 2");
            System.out.println("3-To list all users in our online store please inter 3");
            System.out.println("4-if you want to exit inter 4");
            num=input.nextInt();
            switch(num)
            {
                case 1:
                {
                    System.out.println("please inter your username");
                    String username=input.next();
                    System.out.println("please inter your email");
                    String email=input.next();
                    System.out.println("please inter your password");
                    String password=input.next();
                    user.register(email, username, password);
                    break;
                }
                case 2:
                {
                    System.out.println("please inter your username");
                    String username=input.next();
                    System.out.println("please inter your password");
                    String password=input.next();
                    user.sign_in(username, password);
                    break;
                }
                case 3:
                {
                    user.getAllUsers();
                    break;
                }
                case 4:
                {
                    exit=false;
                    break;
                }
                default:
                {
                    System.out.println("incorrect choice please try again");
                    break;
                }
            }
        }
        input.close();
    }
	  }