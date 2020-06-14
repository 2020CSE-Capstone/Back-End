package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.model.User;

@Mapper
public interface UserMapper {

	public List<User> getAllUsers();
	
    public User findByEmail(@Param("email") String email);

	public int insertUser(@Param("user") SignUpRequestDTO user);
}