public class KataRun {

    private String divide(int i) {
        String str = "";
        if (i % 3 == 0) {
            str = "Foo";
        }
        if (i % 5 == 0) {
            str += "Bar";
        }
        if (i % 7 == 0) {
            str += "Qix";
        }
        return str;
    }

    private String contain(int i, String divide) {
        String init = String.valueOf(i);
        String str = "";
        for (char c : init.toCharArray()) {
            switch (c) {
                case '3':
                    str += "Foo";
                    break;
                case '5':
                    str += "Bar";
                    break;
                case '7':
                    str += "Qix";
                    break;
                default:
                    break;
            }
        }
        return (str.isEmpty() && divide.isEmpty()) ? init : divide + str;
    }

    public void browseNumber() {
        for (int i = 1; i <= 100; ++i) {
            if (i == 100) {
                System.out.print(contain(i, divide(i)));
            } else {
                System.out.println(contain(i, divide(i)));
            }
        }
    }

    public static void main(String[] args) {
        KataRun kr = new KataRun();
        kr.browseNumber();
    }
}
