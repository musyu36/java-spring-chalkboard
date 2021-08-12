package com.chalkboard.demo.infrastructure.datasource;

import com.chalkboard.demo.application.dto.UserCommentDto;
import com.chalkboard.demo.application.dto.UserCommentReadDto;
import com.chalkboard.demo.domain.model.UserComment;
import com.chalkboard.demo.domain.model.UserCommentRepository;
import com.chalkboard.demo.domain.model.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }

    @Override
    public UserComments select() {
        List<UserCommentReadDto> dtos = mapper.select();
        return UserComments.from(
                dtos.stream().map( dto -> UserComments.UserComment.from(
                        dto.getId(),
                        dto.getName(),
                        dto.getMailAddress(),
                        dto.getComment(),
                        dto.getCreatedAt()
                )).collect(Collectors.toUnmodifiableList())
        );
    }
}