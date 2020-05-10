package cse.capstonedesign.Capstone.dto.response;

import cse.capstonedesign.Capstone.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDetailResponseDTO {
	private int id;
	private String email;
	private String name;
	private String phoneNumber;

	public static MemberDetailResponseDTO of(Member member) {
		return MemberDetailResponseDTO.builder()
				.id(member.getId())
				.email(member.getEmail())
				.name(member.getName())
				.phoneNumber(member.getPhoneNumber())
				.build();
	}
}