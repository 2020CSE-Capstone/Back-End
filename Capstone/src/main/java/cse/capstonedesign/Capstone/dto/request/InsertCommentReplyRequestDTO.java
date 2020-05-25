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
}
