package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    boolean isRun = true;
    Water water;
    Milk milk;
    CoffeeBean coffeeBean;
    Cup cup;

    Money money;
    Ingredient[] ingredients;

    // 생성자
    public CoffeeMachine(Water water, Milk milk, CoffeeBean coffeeBean, Cup cup, Money money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBean = coffeeBean;
        this.cup = cup;
        this.money = money;
        this.ingredients = new Ingredient[]{this.water, this.milk, this.coffeeBean, this.cup, this.money};
    }

    // 메소드
    void takeOut(){};
    void work(){
        System.out.println("커피머신이 작동했습니다!");
        output();
        //boolean isRun = true;
        while (isRun){
            int answer = userResponse("1. 구매 2. 채우기 3. 가져가기 > ");

            switch (answer){
                case 1 -> buy();
                case 2 -> fill();
                case 3 -> take();
            }
        }
    }

    private void buy(){
        // boolean isRun = true;
        while (isRun){
            int answer = userResponse("1. 에스프레소 2. 라떼 3. 카푸치노 4. 안마심> ");

            switch (answer){
                case 1 -> calculate(250, 0, 16);
                case 2 -> calculate(350, 75, 20);
                case 3 -> calculate(200, 100, 12);
                case 4 -> end();
            }

        }

    }

    void end(){
        isRun = false;
    }
    private void calculate(int water, int milk, int bean){
        System.out.println("물은 " + water + "이 필요합니다.");
        System.out.println("우유는 " + milk + "이 필요합니다.");
        System.out.println("원두는 " + bean + "이 필요합니다.");
    }
    private void fill(){
        System.out.println("꽉 채웠습니다.");
    }

    private void take(){
        int takenMoney = userResponse("얼마를 꺼내시겠어요? > ");
        this.money.removeAmount(takenMoney);
        System.out.println(takenMoney + "만큼 꺼냈습니다.");
    }

    int userResponse(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int inputAnswer = Integer.parseInt(scanner.nextLine());
        return inputAnswer;
    }

    void output(){
        for(Ingredient ingredient:ingredients){
            System.out.println(ingredient.name + " : " + ingredient.getAmount() + " " + ingredient.unit);
        }
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(new Water(400),
                new Milk(540), new CoffeeBean(120),
                new Cup(9), new Money(50000));
        coffeeMachine.work();
    }
}



abstract class Ingredient {
    private int amount;
    protected String name;
    protected String unit;

    public Ingredient(int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    void addAmount(int amount){
        this.amount += amount;
    }

    void removeAmount(int amount){
        this.amount -= amount;
    }
}

class Money extends Ingredient {
    public Money(int amount) {
        super(amount);
        this.name = "돈";
        this.unit = "원";
    }
}

class CoffeeBean extends Ingredient {
    public CoffeeBean(int amount) {
        super(amount);
        this.name = "원두";
        this.unit = "g";
    }
}
class Cup extends Ingredient {
    public Cup(int amount) {
        super(amount);
        this.name = "종이컵";
        this.unit = "개";
    }
}
class Water extends Ingredient {
    public Water(int amount) {
        super(amount);
        this.name = "물";
        this.unit = "ml";
    }
}
class Milk extends Ingredient {
    public Milk(int amount) {
        super(amount);
        this.name = "우유";
        this.unit = "ml";
    }
}