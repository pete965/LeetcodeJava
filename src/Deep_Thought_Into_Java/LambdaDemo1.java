package Deep_Thought_Into_Java;

import java.io.PrintWriter;

public class LambdaDemo1 {
    interface Printer{
        void print(String val);
    }

    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo = new LambdaDemo1();
        String string = "Hi";

//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                System.out.println(val);
//            }
//        };
        Printer printer = val -> System.out.println(val);
        lambdaDemo.printSomething(string,printer);
    }
}
