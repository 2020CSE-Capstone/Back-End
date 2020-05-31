package cse.capstonedesign.Capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cse.capstonedesign.Capstone.dto.request.InsertWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.dto.response.WritingDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.WritingSimpleResponseDTO;
import cse.capstonedesign.Capstone.mapper.CommunityMapper;
import cse.capstonedesign.Capstone.model.Response;

@Service
public class CommunityService {

	private final CommunityMapper communityMapper;

	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	public ResponseEntity getRecentAllWritings() {
		Response response;

		if (!communityMapper.getRecentAllWritings().isEmpty()) {
			response = new Response("200", "최신 게시글 리스트 조회 성공", communityMapper.getRecentAllWritings().stream()
					.map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "최신 게시글 리스트가 존재하지 않습니다.", null);
			return DefaultResponse.ok(response);
		}
	}

	public ResponseEntity getLikeAllWritings() {
		Response response;

		if (!communityMapper.getLikeAllWritings().isEmpty()) {
			response = new Response("200", "인기 게시글 리스트 조회 성공", communityMapper.getLikeAllWritings().stream()
					.map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		} else {
			response = new Response("200", "인기 게시글 리스트가 존재하지 않습니다.", null);
			return DefaultResponse.ok(response);
		}
	}

	public ResponseEntity getUserAllWritings(@PathVariable("user_id") int user_id) {
		Response response;

		if (!communityMapper.getUserAllWritings(user_id).isEmpty()) {
			response = new Response("200", "내가 작성한 게시글 리스트 조회 성공", communityMapper.getUserAllWritings(user_id).stream()
					.map(WritingSimpleResponseDTO::of).collect(Collectors.toList()));
			return DefaultResponse.ok(response);
		} else {
			response = new Response("200", "내가 작성한 게시글 리스트가 존재하지 않습니다.", null);
			return DefaultResponse.ok(response);
		}
	}

	public ResponseEntity getWritingDetailByNo(@PathVariable("board_no") int board_no) {
		Response response = new Response("200", "게시글 불러오기 성공",
				WritingDetailResponseDTO.of(communityMapper.getWritingDetailByNo(board_no)));
		return DefaultResponse.ok(response);
	}

	public ResponseEntity insertWriting(@RequestBody InsertWritingRequestDTO newWriting) {
		Response response;
		
		if (communityMapper.insertWriting(newWriting) != 0) {
			response = new Response("200", "게시글 삽입 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "게시글 삽입 실패", false);
			return DefaultResponse.badRequest(response);
		}
	}

	public ResponseEntity updateWriting(@PathVariable("board_no") int board_no, @RequestBody UpdateWritingRequestDTO updated_writing) {
		Response response;
		
		if (communityMapper.updateWriting(board_no, updated_writing) != 0) {
			response = new Response("200", "게시글 수정 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "게시글 수정 실패", false);
			return DefaultResponse.badRequest(response);
		}
	}

	public ResponseEntity deleteWriting(@PathVariable("board_no") int board_no) {
		Response response;
		
		if (communityMapper.deleteWriting(board_no) != 0) {
			response = new Response("200", "게시글 삭제 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "게시글 삭제 실패", false);
			return DefaultResponse.badRequest(response);
		}
	}
}
