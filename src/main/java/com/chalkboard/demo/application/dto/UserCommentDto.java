package com.chalkboard.demo.application.dto;

import com.chalkboard.demo.domain.model.UserComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
* 独自クラス(バリューオブジェクトやドメインオブジェクト)をそのままではDBに渡せないので
* DTOで単純なオブジェクトにする
* TypeHandlerで独自クラスをどう扱うかをDBに教える
* 以上のどちらかをする
*
* 今回はDTOを利用する
* アプリケーション側の要件が変更されてもDTOで影響を吸収できる
* */

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentDto {
    private final String name;
    private final String mailAddress;
    private final String comment;

    public static UserCommentDto from(
            UserComment userComment) {
        return new UserCommentDto(
                userComment.getName().toString(),
                userComment.getMailAddress().toString(),
                userComment.getComment().toString()
        );
    }
}