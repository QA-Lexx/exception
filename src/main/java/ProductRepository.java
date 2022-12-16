public class ProductRepository {
    private static Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] removeProductById(int idRemove) {
        if (findById(idRemove) == null) {
            throw new NotFoundException(idRemove);
        }


        Product[] tmp = new Product[products.length - 1];
        int indexInsert = 0;
        for (Product product : products) {
            if (product.getId() != idRemove) {
                tmp[indexInsert] = product;
                indexInsert++;
            }
            products = tmp;
        }
        return tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static Product[] findAll() {
        return products;
    }
}