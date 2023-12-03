package com.tencent.wxcloudrun.bat.extendsandimpl;

public class ImplSon extends Impl1 implements IntefaceTest{


    @Override
    public void foo() {
        System.out.println("implson ");
        super.foo();
    }

    public static void main(String[] args) {
        ImplSon implSon = new ImplSon();
        implSon.foo();
    }
}
