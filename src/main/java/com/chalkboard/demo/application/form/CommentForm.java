package com.chalkboard.demo.application.form;

import lombok.Data;

/*
* @Dataアノテーションをつけることで、getter/setterを同時に作成する
* データを受け渡すためのオブジェクトのみに使用すべき
* */
@Data
public class CommentForm {
    private String name;
    private String mailAddress;
    private String comment;
}