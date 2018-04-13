package com.javaeeproject.classes;

public class User {
	
    private String username;
    private String password;
    
    public User()
    {}

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean login()
    {
        return "Tejean".equalsIgnoreCase(username) && "hello".equals(password);
    }
}
