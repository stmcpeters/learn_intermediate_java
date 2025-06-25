class Customer {
//    instance fields
    private String name;
    private int money;

//    constructor
    public Customer(String name, int money){
        this.name = name;
        this.money = money;
    }

//    toString()
    @Override
    public String toString(){
        return "Customer named " + this.name + " has $" + this.money;
    }

//    getters
    public String getCustomerName() {
        return this.name;
    }
    public int getCustomerMoney(){
        return this.money;
    }

//    setters
    public void setCustomerName(String name) {
        this.name = name;
    }
    public void setCustomerMoney(int money) {
        this.money = money;
    }
}