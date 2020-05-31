package cse.capstonedesign.Capstone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.InsertWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateWritingRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.dto.response.WritingDetailResponseDTO;
import cse.capstonedesign.Capstone.dto.response.WritingSimpleResponseDTO;
import cse.capstonedesign.Capstone.model.Response;
import cse.capstonedesign.Capstone.service.CommunityService;

@RestController
@RequestMapping("/api/community")
public class CommunityController {

	private final CommunityService communityService;

	public CommunityController(CommunityService communityService) {
		this.communityService = communityService;
	}

	@GetMapping("/recent")
	public ResponseEntity getRecentAllWritings() {
		return communityService.getRecentAllWritings();
	}
	
	@GetMapping("/popular")
	public ResponseEntity<List<WritingSimpleResponseDTO>> getLikeAllWritings() {
		List<WritingSimpleResponseDTO> list = communityService.getLikeAllWritings();
		
		return new ResponseEntity<List<WritingSimpleResponseDTO>>(list, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/mypage/{user_id}")
	public List<WritingSimpleResponseDTO> getUserAllWritings(@PathVariable("user_id") int user_id) {
		return communityService.getUserAllWritings(user_id);
	}

	@GetMapping("/{board_no}")
	public WritingDetailResponseDTO getWritingDetailByNo(@PathVariable("board_no") int board_no) {
		return communityService.getWritingDetailByNo(board_no);
	}

	@PostMapping("")
	public boolean insertWriting(@RequestBody InsertWritingRequestDTO newWriting) {
		return communityService.insertWriting(newWriting);
	}

	@PutMapping("/{board_no}")
	public boolean updateWriting(@PathVariable("board_no") int board_no, @RequestBody UpdateWritingRequestDTO updated_writing) {
		return communityService.updateWriting(board_no, updated_writing);
	}

	@DeleteMapping("/{board_no}")
	public boolean deleteWriting(@PathVariable("board_no") int board_no) {
		return communityService.deleteWriting(board_no);
	}
}