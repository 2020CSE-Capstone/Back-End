package cse.capstonedesign.Capstone.dto.response;

import java.util.Date;

import cse.capstonedesign.Capstone.model.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SmokeTotalResponseDTO {
	private int total_piece;
	private int total_price;
}
