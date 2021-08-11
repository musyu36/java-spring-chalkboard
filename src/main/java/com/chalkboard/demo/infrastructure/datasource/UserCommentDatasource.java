package com.chalkboard.demo.infrastructure.datasource;

import com.chalkboard.demo.application.dto.UserCommentDto;
import com.chalkboard.demo.domain.model.UserComment;
import com.chalkboard.demo.domain.model.UserCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }
}