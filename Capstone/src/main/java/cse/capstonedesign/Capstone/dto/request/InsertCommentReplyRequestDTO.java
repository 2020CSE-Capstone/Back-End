package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertCommentReplyRequestDTO {
	private String content;
	private int parent_comment_no;
	private int user_id;
	private int community_board_no;
	
	public InsertCommentReplyRequestDTO() {

	}

	public InsertCommentReplyRequestDTO(String content, int parent_comment_no, int user_id, int community_board_no) {
		super();
		this.content = content;
		this.parent_comment_no = parent_comment_no;
		this.user_id = user_id;
		this.community_board_no = community_board_no;
	}
	
	
}
