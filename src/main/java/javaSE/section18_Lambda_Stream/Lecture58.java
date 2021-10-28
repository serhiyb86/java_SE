package javaSE.section18_Lambda_Stream;

public class Lecture58 {


    public static void main(String[] args) {
        Speak speak = () -> System.out.println("Hello");
        speak.say();
        System.out.println();

        Calc calc = ((int1, int2) -> int1 + int2);
        System.out.println("Sum =  " + calc.calc(5, 3));
        System.out.println();
        Calc calc1 = (a, b) -> {

            if (a == 0)
                return 0;
            return a / b;
        };

        System.out.println("Divide " + calc1.calc(19, 8));
        System.out.println();

        StringCalc stringCalc = (str)->{
            String s = "";
            for (int i = str.length()-1; i >= 0; i--) {
                s=s.concat(String.valueOf(str.charAt(i)));
            } return s;
        };

        System.out.println("String reverse "+stringCalc.handler("hello"));
        System.out.println();
        IntHandler intHandler = (a)->{
            int result=1;
            for (int i = 0; i < a; i++) {
                result*=a;
            } return result;
        };

        System.out.println("Factorial " + intHandler.handler(5));
        System.out.println();

        MyGeneric<Integer> myGeneric = (k)->k*2;
        MyGeneric<String> myGeneric1 = (m)->m+111;
        System.out.println("MyGeneric "+myGeneric.genericTest(6));
        System.out.println("MyGeneric "+myGeneric1.genericTest("fff"));



    }




}

@FunctionalInterface
interface Speak {
    void say();
}

@FunctionalInterface
interface Calc {
    int calc(int int1, int int2);
}
@FunctionalInterface
interface StringCalc{
    String handler(String str);
}
@FunctionalInterface
interface IntHandler{
    int handler(int a);
}
@FunctionalInterface
interface MyGeneric<T>{
    T genericTest(T t);
}