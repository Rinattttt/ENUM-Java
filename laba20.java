public class Main {
    public static void main(String[] args) {
        Clothing[] elements = {
                new T_Shirt(clothes.XS, 260, "Желтый"),
                new T_Shirt(clothes.XXS, 250, "Белый"),
                new Pants(clothes.M, 560, "Синий"),
                new Skirt(clothes.L, 8000, "Красный"),
                new Tie(clothes.S, 70, "Зеленый")};

        Atelier object = new Atelier(elements);

        object.dressed_Woman();

        object.dressed_Male();
    }
}

enum clothes {
    XXS(32) {
        @Override
        String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(40),
    L(42);
    // перечисление ^
    String getDescription() {
        return "Взрослый размер";
    }
    final int euroSize;
    clothes(int euroSize) { //конструктор принимающий размер
        this.euroSize = euroSize;
    }
}

interface Male_Clothes {
    void dressed_Male();
}

interface Woman_Clothes {
    void dressed_Woman();
}

abstract class Clothing {
    clothes size;
    double price;
    String color;

    public Clothing(clothes size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

class T_Shirt extends Clothing implements Male_Clothes, Woman_Clothes {
    public T_Shirt(clothes size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressed_Male() {
        System.out.println("Размер мужской футболки: " + size + ", цена: " + price + ", цвет: " + color);
    }

    @Override
    public void dressed_Woman() {
        System.out.println("Размер женской футболки: " + size + ", цена: " + price + ", цвет: " + color);
    }
}

class Pants extends Clothing implements Male_Clothes {
    public Pants(clothes size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressed_Male() {
        System.out.println("Размер мужских штанов: " + size + ", цена: " + price + ", цвет: " + color);

    }
}

class Skirt extends Clothing implements Woman_Clothes {
    public Skirt(clothes size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressed_Woman() {
        System.out.println("Размер женской юбки: " + size + ", цена: " + price + ", цвет: " + color);
    }
}

class Tie extends Clothing implements Male_Clothes {
    public Tie(clothes size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressed_Male() {
        System.out.println("Размер мужского галстука: " + size + ", цена: " + price + ", цвет: " + color);
    }
}

class Atelier implements Woman_Clothes, Male_Clothes {
    Clothing[] elements;
    Atelier (Clothing[] elements) {
        this.elements = elements;
    }

    @Override
    public void dressed_Woman() {
        for (Clothing element: elements) {
            if (element instanceof Woman_Clothes) {
                ((Woman_Clothes) element).dressed_Woman();
            }
        }
    }

    @Override
    public void dressed_Male() {
        for (Clothing element : elements) {
            if (element instanceof Male_Clothes) {
                ((Male_Clothes) element).dressed_Male();
            }
        }
    }
}