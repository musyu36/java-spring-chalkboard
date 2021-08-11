package com.chalkboard.demo.infrastructure.datasource;

import com.chalkboard.demo.application.dto.UserCommentDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//　MyBatisがDBとの連携を行う際に使用するMapper
@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql") // 利用するSQLファイルの指定
    void insert(@Param("dto") UserCommentDto dto);
}