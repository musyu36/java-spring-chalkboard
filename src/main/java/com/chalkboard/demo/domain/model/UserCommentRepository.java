package com.chalkboard.demo.domain.model;

// Repository は永続化の抽象、具体的な実装は infrastructure 層にて
public interface UserCommentRepository {
    void save(UserComment userComment);
}
