package com.practiceQ1;
class UserService {
	boolean registerUser(String userName,String pwd) {
		if(userName==null || userName.isEmpty() || userName==""){
			throw new InvalidUserNameException("Invalid User Name, Failed to register!");
		}
		else if(pwd.length()<8) {
			throw new InvalidPasswordException("Invalid Password, Failed to register!");
		}
		else {
			System.out.println("User Registered Successfully!");
			return true;
		}
	}	
}
