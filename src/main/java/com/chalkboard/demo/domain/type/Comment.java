package com.chalkboard.demo.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/*
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)で
private finalなフィールドについて、プライベートなコンストラクタを作成
自分のクラスの中でしかnewできない
*/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Comment {
    private final String value;

    // 唯一 Commentをnewできるファクトリメソッド
    public static Comment from(String comment) {
        return new Comment(comment);
    }

    @Override
    public String toString() {
        return value;
    }
}
