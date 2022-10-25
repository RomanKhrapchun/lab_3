package Task_1_2_3.allConnectedToProducts.producrExceptions;

public class ProductNotExist extends RuntimeException{
    public ProductNotExist() {
    }

    public ProductNotExist(final String output) {
        super(output);
    }

    public ProductNotExist(final String output, final Throwable reason) {
        super(output, reason);
    }

    public ProductNotExist(final Throwable output) {
        super(output);
    }
}
