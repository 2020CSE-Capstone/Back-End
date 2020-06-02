package cse.capstonedesign.Capstone.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Record {
	private int id;
	private double figure;
	private int glass;
	private String drink_date;
	private String drink_name;
	private int user_id;
}
