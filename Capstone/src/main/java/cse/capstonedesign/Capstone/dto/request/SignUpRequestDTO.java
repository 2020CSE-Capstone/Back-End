package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpRequestDTO {
    private String email;
    private String nickname;
    private int age;
    private int drink_average;
    private int smoke_average;
    private String password;
    private String determination;
    
    public SignUpRequestDTO() {

    }

	public SignUpRequestDTO(String email, String nickname, int age, int drink_average, int smoke_average,
			String password, String determination) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.age = age;
		this.drink_average = drink_average;
		this.smoke_average = smoke_average;
		this.password = password;
		this.determination = determination;
	}
    
}
