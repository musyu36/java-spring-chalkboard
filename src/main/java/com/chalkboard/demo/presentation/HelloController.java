package com.chalkboard.demo.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
* @ナントカ はアノテーション機能
* クラスに対して付与するマーカーとして機能し
* そのマーカーのついたクラスに対して様々な効果を別のプログラムが及ぼす
*
* @Controllerというアノテーションは、SpringFrameworkのDIコンテナへこのクラスを登録する
* DIコンテナはSpringFrameworkが提供する機能の一つで
* @Controller, @Repository, @Service...など
* いくつかのアノテーションでマークされたクラスのインスタンスを予め生成し保管している箱
* 予めインスタンスが生成され、必要な箇所に適宜分配されるので逐一newしなくてもインスタンスを利用できる
*
* @RequiredArgsConstructorはLombokの提供するアノテーション
* 次の条件いずれかにハマるフィールドを初期化するコンストラクタを生成
* final フィールドであること
* @NonNullアノテーションであること
*
* @GetMapping
* @PostMapping
* @PutMapping
* @DeleteMapping
* @PatchMapping
* それぞれHTTPメソッドに対応したルートマッピング用のアノテーション
* HTTPメソッドと、URLのパスが一致したときにそのControllerが採用される
* 今回は@Getmappingアノテーションでhelloメソッドに/helloを指定しているので
* helloメソッドが呼ばれる
* */
@Controller
@RequiredArgsConstructor
public class HelloController {
    @GetMapping("/hello") // localhost:8080/helloはここにアクセスが来る
    public String hello(Model model){
        return "hello";
    }
}