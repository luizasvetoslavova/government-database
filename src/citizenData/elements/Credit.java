package citizenData.elements;

import accounts.users.bank.Bank;

public class Credit {

    private Citizen obligee;
    private Bank bank;
    private double total;

    public Credit(Citizen obligee, Bank bank, double total) {
        this.obligee = obligee;
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
