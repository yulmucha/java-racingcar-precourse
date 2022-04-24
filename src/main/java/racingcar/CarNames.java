package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final List<CarName> names;

    public CarNames(String[] names) {
        List<CarName> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(new CarName(name));
        }
        this.names = carNames;
    }

    public List<CarName> getNames() {
        return names;
    }
}
