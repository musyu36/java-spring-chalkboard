package com.chalkboard.demo.domain.model;

import com.chalkboard.demo.domain.type.Comment;
import com.chalkboard.demo.domain.type.MailAddress;
import com.chalkboard.demo.domain.type.Name;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserComment {
    private final Name name;
    private final MailAddress mailAddress;
    private final Comment comment;

    public static UserComment from(String name, String mailAddress, String comment) {
        // ファクトリメソッドを使って各インスタンスを生成
        return new UserComment(
                Name.from(name),
                MailAddress.from(mailAddress),
                Comment.from(comment)
        );
    }

    /**
     * 名前が[!omikuji]ならばおみくじの結果を返す.
     * そうでないならばNameをそのまま返す.
     * @return なまえ
     */
    public Name getName() {
        if(!name.equals("!omikuji")) return name;

        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                return Name.from("大吉");
            case 1:
                return Name.from("中吉");
            default:
                return Name.from("小吉");
        }
    }
}