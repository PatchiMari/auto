// Интерфейс ТорговыйАвтомат
interface ТорговыйАвтомат {
    ГорячийНапиток getProduct(int name, int volume, int temperature);
}

// Базовый класс ГорячийНапиток
class ГорячийНапиток {
    private int name;
    private int volume;

    public ГорячийНапиток(int name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public int getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

// Наследник класса ГорячийНапиток с дополнительным полем температура
class ГорячийНапитокСТемпературой extends ГорячийНапиток {
    private int temperature;

    public ГорячийНапитокСТемпературой(int name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

// Класс ГорячихНапитковАвтомат, реализующий интерфейс ТорговыйАвтомат
class ГорячихНапитковАвтомат implements ТорговыйАвтомат {
    @Override
    public ГорячийНапитокСТемпературой getProduct(int name, int volume, int temperature) {
        return new ГорячийНапитокСТемпературой(name, volume, temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        ГорячихНапитковАвтомат автомат = new ГорячихНапитковАвтомат();

        ГорячийНапитокСТемпературой кофе = автомат.getProduct(1, 250, 85);
        ГорячийНапитокСТемпературой чай = автомат.getProduct(2, 300, 90);

        System.out.println("Кофе: " + кофе.getName() + ", объем: " + кофе.getVolume() + ", температура: " + кофе.getTemperature());
        System.out.println("Чай: " + чай.getName() + ", объем: " + чай.getVolume() + ", температура: " + чай.getTemperature());
    }
}