package com.chalkboard.demo.application.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/*
* @Dataアノテーションをつけることで、getter/setterを同時に作成する
* データを受け渡すためのオブジェクトのみに使用すべき
* */
@Data
public class CommentForm {
    @Nullable
    @Length(max=20)
    private String name;
    @Nullable
    @Email
    @Length(max=100)
    private String mailAddress;
    @NotNull
    @Length(min=1, max=400)
    private String comment;
}