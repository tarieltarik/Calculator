import java.util.Scanner;

public class Calculator {

    boolean b = false;
    private final String[] romanNum = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

    public String count(String input){
        for(String s : romanNum){
            if(input.contains(s)){
                b=true;
            }
        }

        if(b){
            return romanCount(input);
        }else {
            return simpleCount(input);
        }
    }

    private String simpleCount(String input) throws ArithmeticException{
        String output = "";
        int result = 0;
        int a=0, b=0;

        String[] operators = input.split("[+,*,/,-]");


        if(operators.length>2){
            return "Input Error!";
        }else{
            a = Integer.parseInt(operators[0]);
            b = Integer.parseInt(operators[1]);

            if(a<=10&&a>=1&&b<=10&&b>=1){
                if(input.contains("+")){
                    result = a + b;
                }else if(input.contains("-")){
                    result = a - b;
                }else if(input.contains("*")){
                    result = a * b;
                }else if(input.contains("/")){
                    result = a/b;
                }
            }else{
                return  "Error of input!";
            }
            output += input + " = " + result + "\n";
            return  output;
        }
    }


    private String romanCount(String input) throws ArithmeticException{
        String output = "";
        int result = 0;
        int a=0, b=0;
        String[] operators = input.split("[+,*,/,-]");

        for(int i=0; i<10; i++) {
            if (operators[0].equals(romanNum[i])) {
                a = i + 1;
            }
            if (operators[1].equals(romanNum[i])) {
                b = i + 1;
            }
        }

        if(a<=10&&a>=1&&b<=10&&b>=1){
            if(input.contains("+")){
                result = a + b;
            }else if(input.contains("-")){
                result = a - b;
            }else if(input.contains("*")){
                result = a * b;
            }else if(input.contains("/")){
                result = a/b;
            }
        }
        if(result<=0){
            return "InputError!";
        }else{
            output += input + " = " + convertToRoman(result) + "\n";
            return output;
        }
    }

    private String convertToRoman(int num){
        String romanNum = "";
        while(num>0){
            if(num>=100){
                romanNum += "C";
                num-=100;
            }else if(num>=90){
                romanNum += "XC";
                num-=50;
            }else if(num>=50){
                romanNum += "L";
                num-=50;
            }else if(num>=40){
                romanNum += "XL";
                num-=10;
            }else if(num>=10){
                romanNum += "X";
                num-=10;
            }else if(num>=9){
                romanNum += "IX";
                num-=10;
            }else if(num>=5){
                romanNum += "V";
                num-=5;
            }else if(num>=4){
                romanNum += "IV";
                num-=5;
            }else if(num>=1){
                romanNum += "I";
                num-=1;
            }
        }
        return romanNum;
    }

}

