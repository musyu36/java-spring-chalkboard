package com.chalkboard.demo.application.usecase;

import com.chalkboard.demo.application.form.CommentForm;
import com.chalkboard.demo.domain.model.UserComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommentUseCase {

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
    }
}
