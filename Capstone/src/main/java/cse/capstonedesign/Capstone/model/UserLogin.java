package cse.capstonedesign.Capstone.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLogin {
    private int id;
    private String email;
    private String password;
    private String roles;
    
    public UserLogin() {
    	
	}

	public UserLogin(int id, String email, String password,  String roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles= roles;
	}
	
	public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }

        return new ArrayList<>();
    }

//    public List<String> getPermissionList(){
//        if(this.permissions.length()>0){
//            return Arrays.asList(this.permissions.split(","));
//        }
//
//        return new ArrayList<>();
//    }
}