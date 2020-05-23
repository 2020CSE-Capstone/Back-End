package cse.capstonedesign.Capstone.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Writing {
	private int board_no;
	private String title;
	private String content;
	private Date write_date;
	private int like_count;
	private int user_id;
	private String nickname;
}
