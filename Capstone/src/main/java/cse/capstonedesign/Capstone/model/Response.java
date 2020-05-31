package cse.capstonedesign.Capstone.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private String status;
	private String message;
	private Object data;
}
