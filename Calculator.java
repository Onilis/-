import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите число или строку:");
        Scanner sca = new Scanner(System.in);
        String exp = sca.nextLine();
        char action;
        String [] data;
        if (exp.length() > 10) {
            throw new Exception("Вводная строка не должна быть длиннее 10 символов");
        }
        if (exp.contains("+")) {
            data = exp.split("\\+");
            action = '+';
        } else if (exp.contains("-")) {
            data = exp.split("\\ -");
            action = '-';
        } else if (exp.contains("*")) {
            data = exp.split("\\*");
            action = '*';
        } else if (exp.contains("/")) {
            data = exp.split("\\/");
            action = '/';
        }else {
            throw new Exception("Не корректный знак");
        }
        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Делить или умножать можно только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            printInQuotes(result);
        }else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int newLen = data[0].length()/Integer.parseInt((data[1]));
            String result = data[0].substring(0, newLen);
            printInQuotes(result);
            return;
        }
    }
    static void printInQuotes(String text) {
        System.out.println("\""+text+"\"");
    }
}
