package info.javateam.services;

import info.javateam.webservices.Login;

public interface LoginService  
{  
     public Login getLoginDetails(String username, String password);  
}  