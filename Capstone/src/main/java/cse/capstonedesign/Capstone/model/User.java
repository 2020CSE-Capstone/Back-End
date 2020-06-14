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
public class User {
    private int id;
    private String email;
    private String nickname;
    private int age;
    private int drink_average;
    private int smoke_average;
    private String password;
    private String determination;
    private String roles;
    
    public User() {
    	
	}

	public User(int id, String email, String nickname, int age, int drink_average, int smoke_average, String password, String determination, String roles) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.age = age;
		this.drink_average = drink_average;
		this.smoke_average = smoke_average;
		this.password = password;
		this.determination = determination;
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