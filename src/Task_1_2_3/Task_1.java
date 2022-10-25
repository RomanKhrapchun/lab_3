package Task_1_2_3;

import Task_1_2_3.allConnectedToHumans.buyers.Customer;

import Task_1_2_3.allConnectedToHumans.check.Check;
import Task_1_2_3.allConnectedToProducts.product.Product;
import Task_1_2_3.allConnectedToProducts.service.StorageService;
import Task_1_2_3.allConnectedToProducts.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_1 {
    public static void main(String[] args) throws Exception {
        List<Check> history = new ArrayList<>();

        List<Product> products = new ArrayList<>() {{
                add(new Product("Banana", 10, 10));
                add(new Product("Orange", 14, 10));
                add(new Product("Apple", 10, 10));
            }
        };
        System.out.println("--------------");
        System.out.println(products);
        System.out.println("--------------");

        Storage storage = new Storage(products);
        storage.addProduct(new Product("Water", 10, 10));

        System.out.println(products);
        System.out.println("--------------");

        Product productTime1 = new Product("Apple", 20, 5);
        Product productTime2 = new Product("Banana", 40, 4);

        LocalDate time = LocalDate.of(2022, 10, 20);
        LocalDate time2 = LocalDate.of(2022, 11, 20);

        Check firstCheck = new Check(productTime1, time);
        Check secondCheck = new Check(productTime2, time2);
        System.out.println(firstCheck);
        System.out.println("--------------");
        System.out.println(secondCheck);
        System.out.println("--------------");

        Customer customer = new Customer("Roma", history);

        StorageService storageService = new StorageService(storage, Stream.of(customer).collect(Collectors.toList()));
        storageService.sellProduct("Water", 2, customer);
        storageService.sellProduct("Apple", 9, customer);

        System.out.println(customer);
        System.out.println("--------------");
        System.out.println(storageService.getAveragePrice());
        System.out.println("--------------");
        System.out.println(storageService.getMostPopularProduct());
        System.out.println("--------------");
        storage.getProductList().forEach(System.out::println);
        storageService.sortByName();
        //storageService.sortByPrice
        //storageService.sortByAmount
        System.out.println("--------------");
        storage.getProductList().forEach(System.out::println);
        System.out.println("--------------");
        System.out.println(storageService.getMostPopularProduct());
        System.out.println("--------------");
        System.out.println(storageService.getCustomerSpending(time,time2,customer));
        System.out.println("--------------");
        storageService.biggestProfit();
        System.out.println("--------------");
        System.out.println(storageService.getCustomerProductAmount(customer));
    }
}
