package cse.capstonedesign.Capstone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.InsertCommentReplyRequestDTO;
import cse.capstonedesign.Capstone.dto.request.InsertCommentRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UpdateCommentRequestDTO;
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
	public ResponseEntity getAllComments(@PathVariable("board_no") int board_no) {
		return commentService.getAllComments(board_no);
	}

	@GetMapping("/reply")
	public ResponseEntity getAllReplyComments(@RequestParam("board_no") int board_no, @RequestParam("comment_no") int comment_no) {
		return commentService.getAllReplyComments(board_no,comment_no);
	}

	@PostMapping("")
	public ResponseEntity insertComment(@RequestBody InsertCommentRequestDTO newComment) {
		return commentService.insertComment(newComment);
	}

	@PostMapping("/reply")
	public ResponseEntity insertCommentReply(@RequestBody InsertCommentReplyRequestDTO newComment) {
		return commentService.insertCommentReply(newComment);
	}
	
	@PutMapping("/{comment_no}")
	public ResponseEntity updateComment(@PathVariable("comment_no") int comment_no, @RequestBody UpdateCommentRequestDTO updatedComment) {
		return commentService.updateComment(comment_no, updatedComment);
	}

	@DeleteMapping("/{comment_no}")
	public ResponseEntity deleteComment(@PathVariable("comment_no") int comment_no) {
		return commentService.deleteComment(comment_no);
	}
}
