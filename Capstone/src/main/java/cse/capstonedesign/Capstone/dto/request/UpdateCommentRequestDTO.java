package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCommentRequestDTO {
	private String content;
	
	public UpdateCommentRequestDTO() {
		this.content = "¾øÀ½";
	}
	
	public UpdateCommentRequestDTO(String content) {
		this.content = content;
	}
}
