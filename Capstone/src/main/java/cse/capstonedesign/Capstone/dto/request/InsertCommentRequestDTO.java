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
}
