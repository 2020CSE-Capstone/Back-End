package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetCommentReplyRequestDTO {
	private int board_no;
	private int parent_comment_no;
}
