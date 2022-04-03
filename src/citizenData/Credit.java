package citizenData;

public class Credit {
    private Bank bank;
    private double total;

    public Credit(Bank bank, double total) {
        this.bank = bank;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "bank=" + bank +
                ", total=" + total +
                '}';
    }
}
