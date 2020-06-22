package cse.capstonedesign.Capstone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.request.InsertSmokeRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.request.MonthRecordRequestDTO;
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
	
	@PostMapping("/drink")
	public ResponseEntity insertDrinkRecord(@RequestBody InsertDrinkRecordRequestDTO new_record) {
		return recordService.insertDrinkRecord(new_record);
	}
	
	@PostMapping("/smoke")
	public ResponseEntity insertSmokeRecord(@RequestBody InsertSmokeRecordRequestDTO new_record) {
		return recordService.insertSmokeRecord(new_record);
	}

	@GetMapping("/drink/total/{user_id}")
	public ResponseEntity getTotalDrink(@PathVariable("user_id") int user_id) {
		return recordService.getTotalDrink(user_id);
	}

	@GetMapping("/smoke/total/{user_id}")
	public ResponseEntity getTotalSmoke(@PathVariable("user_id") int user_id) {
		return recordService.getTotalSmoke(user_id);
	}

	@PostMapping("/drink/month")
	public ResponseEntity getMonthDrinkRecords(@RequestBody MonthRecordRequestDTO monthDrink) {
		return recordService.getMonthDrinkRecords(monthDrink);
	}

	@PostMapping("/smoke/month")
	public ResponseEntity getMonthSmokeRecords(@RequestBody MonthRecordRequestDTO monthSmoke) {
		return recordService.getMonthSmokeRecords(monthSmoke);
	}
}