package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertWritingRequestDTO {
	private String title;
	private String content;
	private int user_id;
	
	public InsertWritingRequestDTO() {

	}

	public InsertWritingRequestDTO(String title, String content, int user_id) {
		super();
		this.title = title;
		this.content = content;
		this.user_id = user_id;
	}
	
}
