package cse.capstonedesign.Capstone.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Comment {
	private int comment_no;
	private String content;
	private int parent_comment_no;
	private int seq;
	private Date comment_date;
	private int user_id;
	private int community_board_no;
}
