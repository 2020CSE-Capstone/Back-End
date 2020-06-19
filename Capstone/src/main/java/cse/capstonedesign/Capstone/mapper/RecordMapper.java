package cse.capstonedesign.Capstone.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cse.capstonedesign.Capstone.dto.request.InsertDrinkRecordRequestDTO;
import cse.capstonedesign.Capstone.model.Record;

@Mapper
public interface RecordMapper {

	public List<Record> getAllDrinkRecords(@Param("user_id") int user_id);
	
	public List<Record> getAllSmokeRecords(@Param("user_id") int user_id);

	public int insertDrinkRecord(@Param("record") InsertDrinkRecordRequestDTO record);

}
