package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void drive() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            distance++;
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " : ");
        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
