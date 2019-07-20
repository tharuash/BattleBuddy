package com.b127.demo.dto;

public class UserDTO extends SuperDTO {
	
	private int UserId;
    private String name;
    private String userName;
    private String password;
    private String email;

    public UserDTO() {
    }

    public UserDTO(int userId, String name, String userName, String password, String email) {
        this.UserId = userId;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getEmail() {
		return email;
	}
}
