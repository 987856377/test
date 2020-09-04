package jni;

public class NativeInterface {
    static {
        System.loadLibrary("JNI");
    }


    public native static void invoke();

    public static void main(String[] args) {
        invoke();
    }
}
