package Task_1_2_3.allConnectedToProducts.service;

import Task_1_2_3.allConnectedToHumans.buyers.Customer;
import Task_1_2_3.allConnectedToHumans.check.Check;
import Task_1_2_3.allConnectedToProducts.producrExceptions.ProductNotExist;
import Task_1_2_3.allConnectedToProducts.product.Product;
import Task_1_2_3.allConnectedToProducts.producrExceptions.ProductsNotEnough;
import Task_1_2_3.allConnectedToProducts.storage.Storage;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageService {
    private static Storage storage;
    private List<Customer> history;

    public StorageService(Storage storage, List<Customer> history) {
        this.storage = storage;
        this.history = history;
    }

    public StorageService() {

    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<Customer> getHistory() {
        return history;
    }

    public void setHistory(List<Customer> history) {
        this.history = history;
    }
    //-------------------------------------------------------
    public int countProduct(final String name) {
        return (int) storage.getProductList()
                .stream()
                .filter(e -> name.equals(e.getName()))
                .count();
    }

    public void sellProduct(final String productName, final int amount, final Customer customer) {
        int realCount = countProduct(productName);
        if (realCount == 0) {
            throw new ProductNotExist();
        }
        if (amount < realCount) {
            throw new ProductsNotEnough();
        }
        for (Product product : storage.getProductList()) {
            if (product.getName().equals(productName)) {
                product.setAmount(product.getAmount() - amount);
                Product copy = Product.copyProduct(product);
                copy.setAmount(amount);
                productToCheck(customer, copy);
            }
        }
    }

    public void productToCheck(final Customer customer, final Product product) {
        final Check check = new Check(product, LocalDate.now());
        customer.getCustomerCheck().add(check);
    }

    public void sortByName() {
        storage.getProductList()
                .sort(Comparator.comparing(Product::getName));
    }

    public void sortByPrice() {
        storage.getProductList()
                .sort(Comparator.comparing(Product::getPrice));
    }

    public void sortByAmount() {
        storage.getProductList()
                .sort(Comparator.comparing(Product::getAmount));
    }

    public double getAveragePrice() {
        return storage.getProductList()
                .stream()
                .mapToDouble(Product::getPrice)
                .average()
                .getAsDouble();
    }
    public List<Check> getAllCheck() {
        List<Check> check = new ArrayList<>();
        history.forEach(e -> check.addAll(e.getCustomerCheck()));
        return check;
    }

    public Product getProductById(int id) {
        return storage.getProductList()
                .stream()
                .filter(e -> e.getId() == id).findFirst().get();
    }

    public Product getMostPopularProduct() {
        Map<Integer, List<Check>> map;
        map = getAllCheck().stream()
                .collect(Collectors.groupingBy(e -> e.getProduct().getId()));
        List<Product> list;
        Map<Integer, Integer> map1;
        map1 = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream()
                        .mapToInt(e1 -> e1.getProduct().getAmount())
                        .sum()));
        list = map1.entrySet().stream().map(e -> {
            Product copy = getProductById(e.getKey());
            copy.setAmount(e.getValue());
            return copy;
        }).collect(Collectors.toList());
        return list.stream()
                .max(Comparator.comparingDouble(Product::getAmount)).get();
    }
    //-------------------------------------------------------
    public void biggestProfit(){
        System.out.println(storage.getProductList()
                .stream()
                .max(Comparator.comparingDouble(StorageService::profit)));
    }

    private static <T> double profit(T t) {
        double profit = 0;
        for(Product product : storage.getProductList()){
            profit += product.getPrice() * product.getAmount();
        }
        return profit;
    }
    //-------------------------------------------------------
    public double getCustomerSpending(final LocalDate from, final LocalDate to, final Customer customer){
        return customer.getCustomerCheck()
                .stream()
                .filter(e->e.getDate().isAfter(from) && e.getDate().isBefore(to))
                .mapToDouble(e->e.getProduct().getAmount() * e.getProduct().getPrice())
                .sum();
    }
    //-------------------------------------------------------
    public int getCustomerProductAmount(final Customer customer){
        return customer.getCustomerCheck()
                .stream()
                .mapToInt(e->e.getProduct().getAmount())
                .sum();
    }
}
