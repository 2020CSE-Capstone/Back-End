package cse.capstonedesign.Capstone.service;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
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
}
