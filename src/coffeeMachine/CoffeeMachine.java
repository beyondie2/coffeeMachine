package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        //CoffeeMachine coffeeMachine = new CoffeeMachine();
        //CoffeeMachine coffeeMachine = new CoffeeMachine(new Water(400), new Milk(540), new Bean(120), new Cup(9), new Money(50000));
        boolean state = true;
        int water = 400;
        int milk = 540;
        int bean = 120;
        int cups = 9;
        int money = 50000;

        Scanner scanner = new Scanner(System.in);

        while (state){
            System.out.println("현재 커피머신 상태: ");
            System.out.println("남은 재료와 돈 상태: ");
            System.out.println("물: " + water + " ml");
            System.out.println("우유: " + milk + " ml");
            System.out.println("원두: " + bean + " g");
            System.out.println("일회용 컵: " + cups + " 개");
            System.out.println("돈: " + money + " 원");

            System.out.println("옵션을 선택하세요.");
            System.out.println("[1.구매|2.채우기|3.가져오기|4.종료]");
            System.out.print("선택>");

            int myChoice = scanner.nextInt();

            switch(myChoice) {
                case 1:
                    System.out.println("구매를 선택했습니다.");
                    System.out.println("어떤 커피를 구매하시겠습니까?");
                    System.out.println("1. 에스프레소 (가격: 4000원)");
                    System.out.println("2. 라떼 (가격: 7000원)");
                    System.out.println("1. 카푸치노 (가격: 6000원)");
                    System.out.print("선택>");

                    int myCoffee = scanner.nextInt();

                    switch(myCoffee) {
                        case 1:
                            System.out.println("에스프레소를 선택했습니다.");
                            water = water - 100;
                            System.out.println("물의 양은 " + water + "입니다." );
                            if(water<400){
                                System.out.println("물이 부족합니다.");
                            }
                            break;
                        case 2:
                            System.out.println("라떼를 선택했습니다.");
                            water = water - 100;
                            if(water<400){
                                System.out.println("물이 부족합니다.");
                            }
                            break;
                        case 3:
                            System.out.println("카푸치노를 선택했습니다.");
                            water = water - 100;
                            if(water<400){
                                System.out.println("물이 부족합니다.");
                            }
                            break;
                        case 4:
                            System.out.println("종료를 선택했습니다.");
                            break;
                        default:
                            System.out.println("오류");
                            break;
                    } //switch(myCoffee) 끝

                    if(water < 0 ) {
                        state = false;
                    }
                    break;
                case 2:
                    System.out.println("채우기를 선택했습니다.");
                    water = 400;
                    milk = 540;
                    bean = 120;
                    cups = 9;
                    System.out.println("소모품을 다 채웠습니다.");
                    break;
                case 3:
                    System.out.println("가져오기를 선택했습니다.");
                    System.out.println("돈은 " + money + "입니다.");

                    break;
                case 4:
                    System.out.println("종료를 선택했습니다.");
                    state = false;
                    break;

                default:
                    System.out.println("오류");
                    break;
            }

            if(myChoice==1){
            }
        } // while 끝
    } // main 끝
}
