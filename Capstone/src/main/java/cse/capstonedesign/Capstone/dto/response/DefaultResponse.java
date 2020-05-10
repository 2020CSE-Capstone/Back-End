package cse.capstonedesign.Capstone.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DefaultResponse {
	public static ResponseEntity ok() {
		return DefaultResponse.msg(HttpStatus.OK);
	}

	public static ResponseEntity ok(Object o) {
		return DefaultResponse.msg(HttpStatus.OK, o);
	}

	public static ResponseEntity badRequest() {
		return DefaultResponse.msg(HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity badRequest(Object o) {
		return DefaultResponse.msg(HttpStatus.BAD_REQUEST, o);
	}

	public static ResponseEntity internalServerError() {
		return DefaultResponse.msg(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static ResponseEntity internalServerError(Object o) {
		return DefaultResponse.msg(HttpStatus.INTERNAL_SERVER_ERROR, o);
	}

	public static ResponseEntity msg(HttpStatus httpStatus) {
		return ResponseEntity.status(httpStatus).build();
	}

	public static ResponseEntity msg(HttpStatus httpStatus, Object o) {
		return ResponseEntity.status(httpStatus).body(o);
	}
}
