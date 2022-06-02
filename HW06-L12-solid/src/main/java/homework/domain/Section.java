package homework.domain;

public class Section {
    private final int nominal;
    private int quantity;

    public Section(int nominal) {
        this.nominal = nominal;
        quantity = 0;
    }

    public int getNominal() {
        return nominal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int quantity){
        this.quantity = quantity;
    }

    public String toString() {
        return super.toString() + " [nominal:  " + nominal + ", quantity: " + quantity + "]" + "\n";
    }
}
