package cse.capstonedesign.Capstone.dto.response;

import java.util.Date;

import cse.capstonedesign.Capstone.model.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecordResponseDTO {
	private int id;
	private double figure;
	private int glass;
	private String drink_date;
	private String drink_name;
	private int user_id;

	public static RecordResponseDTO of(Record record) {
		return RecordResponseDTO.builder()
				.id(record.getId())
				.figure(record.getFigure())
				.glass(record.getGlass())
				.drink_date(record.getDrink_date())
				.drink_name(record.getDrink_name())
				.user_id(record.getUser_id())
				.build();
	}
}
