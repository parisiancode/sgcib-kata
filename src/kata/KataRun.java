package kata;

import java.io.PrintStream;

public class KataRun {

	public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QIX = "Qix";

    private String divide(int i) {
        String str = "";
        if (i % 3 == 0) {
            str += FOO;
        }
        if (i % 5 == 0) {
            str += BAR;
        }
        if (i % 7 == 0) {
            str += QIX;
        }
        return str;
    }

    private String contain(int i, String divide) {
        String init = String.valueOf(i);
        StringBuilder sb = new StringBuilder();
        for (char c : init.toCharArray()) {
            switch (c) {
                case '3':
                    sb.append(FOO);
                    break;
                case '5':
                    sb.append(BAR);
                    break;
                case '7':
                    sb.append(QIX);
                    break;
                default:
                    break;
            }
        }
        return (sb.toString().isEmpty() && divide.isEmpty()) ? init : divide + sb.toString();
    }

    public void browseNumber() {
    	PrintStream out = System.out;
        for (int i = 1; i <= 100; ++i) {
            if (i == 100) {
                out.print(contain(i, divide(i)));
            } else {
                out.println(contain(i, divide(i)));
            }
        }
    }

    public static void main(String[] args) {
        KataRun kr = new KataRun();
        kr.browseNumber();
    }
}
