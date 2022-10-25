package Task_1_2_3.allConnectedToProducts.storage;

import Task_1_2_3.allConnectedToProducts.producrExceptions.ProductNoName;
import Task_1_2_3.allConnectedToProducts.producrExceptions.ProductsNotEnough;
import Task_1_2_3.allConnectedToProducts.product.Product;

import java.util.List;

public class Storage {

 public List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Storage(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        validate();
        this.productList.add(product);
    }

    public void validate() throws ProductNoName, ProductsNotEnough {
        try {
            for (final Product good : productList) {
                validateProduct(good);
            }
        }catch (final ProductsNotEnough productsNotEnough){
            throw  new ProductsNotEnough();
        }catch(final ProductNoName productNoName){
            throw new ProductNoName();
        }
    }

    public void validateProduct(Product product) throws ProductNoName, ProductsNotEnough {
        if(product.getName().isEmpty()) {
            throw new ProductNoName("Product name is empty");
        }
        if(product.getAmount() <= 0){
            throw new ProductsNotEnough("Product amount <= 0");
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "productList=" + productList +
                '}';
    }
}
