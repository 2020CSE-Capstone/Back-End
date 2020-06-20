package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MonthRecordRequestDTO {
	private int user_id;
	private int month;
	
	public MonthRecordRequestDTO() {
	}

	public MonthRecordRequestDTO(int user_id, int month) {
		super();
		this.user_id = user_id;
		this.month = month;
	}
}
