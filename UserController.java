package sprint1_files;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UserController {
	 public userModel U;
	 public userView view;
	 public UserController() {
		 this.U=new userModel();
		 this.view=new userView();
	 }
	    @RequestMapping("/register")
	    public void register(String email, String user, String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	        if (email.contains("@") && email.indexOf("@") < email.indexOf(".")) {
	            if (!user.isEmpty()) {
	                if (pass.length() >= 6) {
	                    //U=new userModel();
	                    U.addData(user, email, pass);
	                } else {
	                    System.out.println("this password is short");
	                }
	            } else {
	                System.out.println("this is empty username");
	            }
	        } else {
	            System.out.println("this email is invalid");
	        }

	    }
                  @RequestMapping("/sign_in")
                  public void sign_in(String username, String pass) {
                      //U = new userModel();
                      boolean found = false;
                      if (username.length() > 0) {
                          if (pass.length() >= 6) {
                              found = U.checkIf_user_is_exist(username, pass);
                              if (found) {
                                  System.out.println("Successfully signed in");
                              } else {
                                  System.out.println("incorrect username or password");
                              }
                          }
                          else
                              System.out.println("this is short password");
                      }
                      else
                          System.out.println("this is empty username");

                  }
                  @RequestMapping("/getAllUsers")
                  
                  public void getAllUsers() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
                      //U= new userModel();
                      ArrayList<userModel> users = new ArrayList<userModel>();
                      users = U.getAlldata();
                      for (int i = 0; i < users.size(); i++) {
                          System.out.println(users.get(i).getUserName() + " " + users.get(i).getEmail() + " " + users.get(i).getPassword());
                      }
                  }
                  @RequestMapping("/updateView")

                  public void updateView() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
                      ArrayList<userModel> users = new ArrayList<userModel>();
                      users = U.getAlldata();
                      for (int i = 0; i < users.size(); i++) {
                          view.printUserDetails(users.get(i).getPassword(), users.get(i).getEmail(), users.get(i).getUserName());
                      }
                  }
              }

                  

