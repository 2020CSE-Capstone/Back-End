package cse.capstonedesign.Capstone.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.request.MonthRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.dto.response.DrinkTotalResponseDTO;
import cse.capstonedesign.Capstone.dto.response.RecordResponseDTO;
import cse.capstonedesign.Capstone.mapper.RecordMapper;
import cse.capstonedesign.Capstone.model.Response;

@Service
public class RecordService {

	private final RecordMapper recordMapper;

	public RecordService(RecordMapper recordMapper) {
		this.recordMapper = recordMapper;
	}

	public ResponseEntity getAllDrinkRecords(@PathVariable("user_id") int user_id) {
		Response response;

		response = new Response("200", "기록 리스트 조회 성공", recordMapper.getAllDrinkRecords(user_id).stream()
				.map(RecordResponseDTO::of).collect(Collectors.toList()));
		return DefaultResponse.ok(response);

	}

	public ResponseEntity getAllSmokeRecords(@PathVariable("user_id") int user_id) {
		Response response;

		response = new Response("200", "기록 리스트 조회 성공", recordMapper.getAllSmokeRecords(user_id).stream()
				.map(RecordResponseDTO::of).collect(Collectors.toList()));
		return DefaultResponse.ok(response);
	}

	public ResponseEntity insertDrinkRecord(@RequestBody InsertDrinkRecordRequestDTO new_record) {
		Response response;

		if (recordMapper.insertDrinkRecord(new_record) != 0) {
			response = new Response("200", "기록 삽입 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "기록 삽입 실패", false);
			return DefaultResponse.badRequest(response);
		}
	}

	public ResponseEntity getTotalDrink(@PathVariable("user_id") int user_id) {
		Response response;

		response = new Response("200", "음주 총합 조회 성공", recordMapper.getTotalDrink(user_id));

		return DefaultResponse.ok(response);
	}

	public ResponseEntity getTotalSmoke(@PathVariable("user_id") int user_id) {
		Response response;

		response = new Response("200", "흡연 총합 조회 성공", recordMapper.getTotalSmoke(user_id));

		return DefaultResponse.ok(response);
	}

	public ResponseEntity getMonthDrinkRecords(@RequestBody MonthRecordRequestDTO monthDrink) {
		Response response;
		String month;

		if (monthDrink.getMonth() >= 1 && monthDrink.getMonth() <= 9)
			month = ".0" + monthDrink.getMonth() + ".";
		else
			month = "." + monthDrink.getMonth() + ".";

		if (monthDrink.getMonth() >= 1 && monthDrink.getMonth() <= 12) {
			response = new Response("200", "월별 기록 리스트 조회 성공",
					recordMapper.getMonthDrinkRecords(monthDrink.getUser_id(), month));
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "1월 ~ 12월만 조회해주세요.", null);
			return DefaultResponse.ok(response);
		}
	}

	public ResponseEntity getMonthSmokeRecords(@RequestBody MonthRecordRequestDTO monthSmoke) {
		Response response;
		String month;

		if (monthSmoke.getMonth() >= 1 && monthSmoke.getMonth() <= 9)
			month = ".0" + monthSmoke.getMonth() + ".";
		else
			month = "." + monthSmoke.getMonth() + ".";

		if (monthSmoke.getMonth() >= 1 && monthSmoke.getMonth() <= 12) {
			response = new Response("200", "월별 기록 리스트 조회 성공",
					recordMapper.getMonthSmokeRecords(monthSmoke.getUser_id(), month));
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "1월 ~ 12월만 조회해주세요.", null);
			return DefaultResponse.ok(response);
		}
	}
}
