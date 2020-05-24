package cse.capstonedesign.Capstone.dto.response;

import java.util.Date;

import cse.capstonedesign.Capstone.model.Writing;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WritingDetailResponseDTO {
	private int board_no;
	private String title;
	private String content;
	private Date write_date;
	private int like_count;
	private int user_id;
	private String nickname;
	private int comment_count;

	public static WritingDetailResponseDTO of(Writing writing) {
		return WritingDetailResponseDTO.builder()
				.board_no(writing.getBoard_no())
				.title(writing.getTitle())
				.content(writing.getContent())
				.write_date(writing.getWrite_date())
				.like_count(writing.getLike_count())
				.user_id(writing.getUser_id())
				.nickname(writing.getNickname())
				.comment_count(writing.getComment_count())
				.build();
	}
}
