package homework.domain;

public class Banknote {
    private final int nominal;
    private final int quantity;

    public Banknote(int nominal, int quantity) {
        this.nominal = nominal;
        this.quantity = quantity;
    }

    public int getNominal() {
        return nominal;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return super.toString() + " [nominal:  " + nominal + ", quantity: " + quantity + "]" + "\n";
    }
}
