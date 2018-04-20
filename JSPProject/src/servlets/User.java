package servlets;

public class User {
	
    private String username;
    private String password;
    private String birthday;
    private String address;
    
    public User()
    {}

    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
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

    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean login()
    {
    	if("Tejean".equalsIgnoreCase(username) && "hello".equals(password)) {
    		this.birthday = "January";
    		this.address  = "QC";
    		return true;
    	}
        return false;
    }
}
