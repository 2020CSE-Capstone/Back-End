package cse.capstonedesign.Capstone.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MonthRecords {
	private String date;
	private int total_amount;
}
