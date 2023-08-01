package coffeeMachine;

public abstract class Materials {
    boolean state = true;
    int water = 400;
    int milk = 540;
    int bean = 120;
    int cup = 9;
    int money = 50000;
    // 생성자 - 초기화
    // 50000, 400, 540, 120, 9
    // 메소드 - 구매(), 채우기(), 가져가기(), 작동() 남은량출력()
    // 재료 소모량  물 원두 컵 종이컵 가격 - 부모클래스가 가져야 할 속성

    public void buy(){}
    public void fill(){}
    public void takeout(){}
    public void checkLeft(){}

}
