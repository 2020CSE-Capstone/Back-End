package cse.capstonedesign.Capstone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.service.RecordService;

@RestController
@RequestMapping("/api/record")
public class RecordController {

	private final RecordService recordService;

	public RecordController(RecordService recordService) {
		this.recordService = recordService;
	}

	@GetMapping("/drink/{user_id}")
	public ResponseEntity getAllDrinkRecords(@PathVariable("user_id") int user_id) {
		return recordService.getAllDrinkRecords(user_id);
	}

	@GetMapping("/smoke/{user_id}")
	public ResponseEntity getAllSmokeRecords(@PathVariable("user_id") int user_id) {
		return recordService.getAllSmokeRecords(user_id);
	}
	
	@PostMapping("")
	public ResponseEntity insertDrinkRecord(@RequestBody InsertDrinkRecordRequestDTO new_record) {
		return recordService.insertDrinkRecord(new_record);
	}

//	@GetMapping("/{board_no}")
//	public ResponseEntity getWritingDetailByNo(@PathVariable("board_no") int board_no) {
//		return communityService.getWritingDetailByNo(board_no);
//	}
//
//	@PostMapping("")
//	public ResponseEntity insertWriting(@RequestBody InsertWritingRequestDTO newWriting) {
//		return communityService.insertWriting(newWriting);
//	}
}