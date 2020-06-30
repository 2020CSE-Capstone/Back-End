package cse.capstonedesign.Capstone.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SmokeRecord {
	private int id;
	private double figure;
	private int piece;
	private String smoke_date;
	private String smoke_name;
	private int user_id;
}
