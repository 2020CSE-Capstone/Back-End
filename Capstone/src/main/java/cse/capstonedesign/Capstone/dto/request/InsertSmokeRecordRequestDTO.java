package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertSmokeRecordRequestDTO {

	private double figure;
	private int piece;
	private String smoke_date;
	private String smoke_name;
	private int user_id;

	public InsertSmokeRecordRequestDTO() { }

	public InsertSmokeRecordRequestDTO(double figure, int piece, String smoke_date, String smoke_name, int user_id) {
		super();
		this.figure = figure;
		this.piece = piece;
		this.smoke_date = smoke_date;
		this.smoke_name = smoke_name;
		this.user_id = user_id;
	}

}
