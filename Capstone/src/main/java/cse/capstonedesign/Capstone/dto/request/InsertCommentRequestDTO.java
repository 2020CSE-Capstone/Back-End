package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertCommentRequestDTO {
	private String content;
	private int user_id;
	private int community_board_no;
	
	public InsertCommentRequestDTO() {

	}

	public InsertCommentRequestDTO(String content, int user_id, int community_board_no) {
		super();
		this.content = content;
		this.user_id = user_id;
		this.community_board_no = community_board_no;
	}
}
