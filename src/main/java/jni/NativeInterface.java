package jni;

public class NativeInterface {
    static {
        System.loadLibrary("JNI");
    }


    public native void invoke();

    public native String handle(String param);

    public static native double f(int i, String s);

    public static void main(String[] args) {
        NativeInterface nativeInterface = new NativeInterface();
        nativeInterface.invoke();

        System.out.println("nativeInterface.handle(\"NIL\") = " + nativeInterface.handle("NIL"));

        String s = "FIRST";
        System.out.println("nativeInterface.f(1, \"first\") = " + f(1, s));
    }
}
