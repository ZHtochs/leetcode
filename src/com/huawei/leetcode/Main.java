package com.huawei.leetcode;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @program: offer
 * @author: zhuhe
 * @create: 2021-08-11 21:01
 **/
public class Main {
    static Observer<String> stringObserver=new Observer<String>() {
        @Override
        public void onSubscribe(Disposable disposable) {
            System.out.println("==============");
            System.out.println(Thread.currentThread());
            System.out.println("onSubscribe");
        }

        @Override
        public void onNext(String s) {
            System.out.println("==============");
            System.out.println(Thread.currentThread());
            System.out.println("onNext");
            System.out.println(s);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            System.out.println("==============");
            System.out.println(Thread.currentThread());
            System.out.println("onComplete");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        String[] names = {"123", "456"};
        Observable.fromArray(names)
                .observeOn(Schedulers.single())
                .subscribeOn(Schedulers.newThread())
                .subscribe(stringObserver);
        Thread.sleep(2000);
    }
}