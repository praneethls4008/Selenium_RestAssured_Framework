package localhost.constants;

public final class Endpoints {
    private Endpoints() {}

    public static final String USERS = "/api/v1/users";
    public static final String USER_BY_ID = "/api/v1/users/{userId}";
    public static final String PRODUCTS = "/api/v1/products";
    public static final String PRODUCT_BY_ID = "/api/v1/products/{id}";
    public static final String PRODUCTS_BY_SLUG = "/api/v1/products/slug/{slug}";
    public static final String PRODUCTS_RELATED = "/api/v1/products/{id}/related";
    public static final String PRODUCTS_UPDATE = "/api/v1/products/{id}";
    public static final String PRODUCTS_DELETE = "/api/v1/products/{id}";

    public static final String CATEGORIES = "/api/v1/categories";

    public static final String LOGIN = "/api/v1/auth/login";
    public static final String PROFILE = "/api/v1/auth/profile";
    public static final String REFRESH = "/api/v1/auth/refresh-token";


}
