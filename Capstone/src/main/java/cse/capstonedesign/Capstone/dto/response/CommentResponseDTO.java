package cse.capstonedesign.Capstone.dto.response;

import java.util.Date;

import cse.capstonedesign.Capstone.model.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentResponseDTO {
	private int comment_no;
	private String content;
	private int parent_comment_no;
	private int seq;
	private Date comment_date;
	private int user_id;
	private int community_board_no;
	private String nickname;
	private int del_flag;

	public static CommentResponseDTO of(Comment comment) {
		return CommentResponseDTO.builder()
				.comment_no(comment.getComment_no())
				.content(comment.getContent())
				.parent_comment_no(comment.getParent_comment_no())
				.seq(comment.getSeq())
				.comment_date(comment.getComment_date())
				.user_id(comment.getUser_id())
				.community_board_no(comment.getCommunity_board_no())
				.nickname(comment.getNickname())
				.del_flag(comment.getDel_flag())
				.build();
	}
}
