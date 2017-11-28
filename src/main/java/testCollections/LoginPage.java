package testCollections;

public class LoginPage {
	private String username = ".//*[@id='exampleInputEmail1']" ;
	private String password = ".//*[@id='exampleInputPassword1']";
	private String login;
	private String forgotpassword;
	private String registernow;
	public LoginPage(String u_Name, String u_Password){
		username = u_Name;
		password = u_Password;
	}
	public String uname(){
		return username;
	}
	public String password(){
		return password;
	}
	public void login(){
		System.out.println("Logged in successfully");
	}
		public void forgot_your_password(){
			System.out.println("Reset password");	
	}
		public void register_now(){
			System.out.println("Register now");
	}
}