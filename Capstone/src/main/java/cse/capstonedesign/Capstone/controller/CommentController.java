package cse.capstonedesign.Capstone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.response.CommentResponseDTO;
import cse.capstonedesign.Capstone.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/{board_no}")
	public List<CommentResponseDTO> getAllComments(@PathVariable("board_no") int board_no) {
		return commentService.getAllComments(board_no);
	}

	@GetMapping("/count/{board_no}")
	public int getCommentCount(@PathVariable("board_no") int board_no) {
		return commentService.getCommentCount(board_no);
	}

}
