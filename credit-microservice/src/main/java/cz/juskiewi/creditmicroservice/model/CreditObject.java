package cz.juskiewi.creditmicroservice.model;

public class CreditObject {

    Customer customer;
    Product product;
    Credit credit;

    public CreditObject() {
    }

    public CreditObject(Customer customer, Product product, Credit credit) {
        this.customer = customer;
        this.product = product;
        this.credit = credit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "CreditObject{" +
                "customer=" + customer +
                ", product=" + product +
                ", credit=" + credit +
                '}';
    }
}
