package Task_1_2_3.allConnectedToProducts.producrExceptions;


public class ProductsNotEnough extends RuntimeException{
    public ProductsNotEnough() {
    }

    public ProductsNotEnough(final String output) {
        super(output);
    }

    public ProductsNotEnough(final String output, final Throwable reason) {
        super(output, reason);
    }

    public ProductsNotEnough(final Throwable output) {
        super(output);
    }
}
