package cse.capstonedesign.Capstone.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InsertDrinkRecordRequestDTO {

	private double figure;
	private int glass;
	private String drink_date;
	private String drink_name;
	private int user_id;

	public InsertDrinkRecordRequestDTO() { }

	public InsertDrinkRecordRequestDTO(double figure, int glass, String drink_date, String drink_name, int user_id) {
		this.figure = figure;
		this.glass = glass;
		this.drink_date = drink_date;
		this.drink_name = drink_name;
		this.user_id = user_id;
	}
}
