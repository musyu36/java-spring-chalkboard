package com.chalkboard.demo.application.usecase;

import com.chalkboard.demo.application.form.CommentForm;
import com.chalkboard.demo.domain.model.UserComment;
import com.chalkboard.demo.domain.model.UserCommentRepository;
import com.chalkboard.demo.domain.model.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommentUseCase {
    private final UserCommentRepository repository; // UserCommentRepository をDI

    /**
     * ユーザの書き込みをDBに反映し、表示するデータをプレゼンテーション層に渡す
     * @param commentForm ユーザの入力データ
     * @return 表示するデータ
     */
    public void write(CommentForm commentForm) {
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getMailAddress(),
                commentForm.getComment()
        );

        repository.save(userComment);
    }

    /**
     * 投稿の取得
     * @return 投稿のリスト
     */
    public UserComments read(){
        return repository.select();
    }
}
