import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int numberOfPeople = Input.inputCheckInt(); //проверка ввода
        Calculator.calculate(numberOfPeople); //подсчет и вывод

    }
}

class Input {

    public static int inputCheckInt(){
        int result;
        System.out.println("Привет. Укажите на какое количество человек поделить счет: ");
        while(true) {
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()) {
                result = sc.nextInt();
                if(result%10 > 1 && result%10 < 5){
                    System.out.println("Сумма будет поделена на " + result +" человека.");
                    break;
                }
                else if (result%10 >= 5) {
                    System.out.println("Сумма будет поделена на " + result +" человек.");
                    break;
                }
                else{
                    System.out.println("Количество человек должно быть больше 1, попробуйте снова: ");
                }
            }


            else{
                System.out.println("Пожалуйста, введите ЦЕЛОЕ число: ");
            }
        }
        return result;
    } //проверка на целое число для кол-ва людей
    public static double inputCheckDouble(){
        double resultDouble;
        while(true){
            Scanner priceStuff = new Scanner(System.in);
            if(priceStuff.hasNextDouble()){
                resultDouble = priceStuff.nextDouble();
                if(resultDouble > 0) {
                    break;
                    }
                else {
                    System.out.println("Пожалуйста, введите корректную сумму: ");
                    }
                }
            else{
                System.out.println("Пожалуйста, введите корректную сумму: ");
            }
        }
        return resultDouble;
        } //проверка на дробное для стоимости товара
    public static boolean answerCheck(){
        String resultString;
        while(true){
            Scanner anwserString = new Scanner(System.in);
            resultString = anwserString.nextLine();
            if(resultString.equalsIgnoreCase("завершить")){
                return false;
            }
            else if(resultString.equalsIgnoreCase("да")){
                return true;
            }
            else{
                System.out.println("Пожалуйста, введите одну из доступных команд: ");
            }
        }

    } //проверка на ввод доступных команд
}

class  Stuff {

    String label = "";
    double price = 0;
    public static double addStuff(){
        Stuff npStuff = new Stuff();
        while(true){
            System.out.println("Укажите наименование товара: ");
            Scanner nameStuff = new Scanner(System.in);
            npStuff.label = npStuff.label + "\n" + nameStuff.nextLine();
            System.out.println("Укажите стоимость товара: ");
            double e = Input.inputCheckDouble();
            npStuff.price = npStuff.price + e;
            System.out.println("Товар добавлен. \nХотите добаить еще один товар? \nВведите 'Да', чтобы продолжить и 'Завершить', чтобы закончить");
            if(!Input.answerCheck()){
                break;
            }
        }
        System.out.println("Список товаров: \n" + npStuff.label);

        return npStuff.price;
    } //добавить товар
}

class Calculator {

    public static void calculate(int result){
        double finalPrice = Stuff.addStuff();
        String fullPrice = "\nОбщая стоимость всех товаров: %.2f";
        System.out.println(String.format(fullPrice, finalPrice) + roubles(finalPrice));
        finalPrice = finalPrice/result;
        String message = "\nИтоговая сумма на 1 человека: %.2f";
        System.out.println(String.format(message, finalPrice) + roubles(finalPrice));
    } //подсчет и вывод результата

    public static String roubles(double varPrice){
        String rubResult;
        if(Math.floor(varPrice)%10 == 1 && Math.floor(varPrice) != 11){
            rubResult= "рубль";
        }
        else if(Math.floor(varPrice)%10 >= 2 && Math.floor(varPrice)%10 <= 4 ) {
            rubResult = " рубля";
        }
        else{
            rubResult = " рублей";

        }
        return rubResult;
    } //рубль/ля/лей
}


