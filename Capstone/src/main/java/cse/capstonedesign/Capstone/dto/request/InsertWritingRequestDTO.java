package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertWritingRequestDTO {
	private String title;
	private String content;
	private int user_id;
}
