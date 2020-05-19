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
	private String user_id;
}
