package Task_1_2_3.allConnectedToProducts.producrExceptions;

public class ProductNoName extends RuntimeException{
    public ProductNoName() {
    }

    public ProductNoName(final String output) {
        super(output);
    }

    public ProductNoName(final String output, final Throwable reason) {
        super(output, reason);
    }

    public ProductNoName(final Throwable output) {
        super(output);
    }
}
