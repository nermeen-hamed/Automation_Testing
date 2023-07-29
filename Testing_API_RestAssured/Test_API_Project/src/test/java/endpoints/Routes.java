package endpoints;

public class Routes {
    //Routes for Users Module

    public static String baseURL="https://petstore.swagger.io/v2";
    public static String postUserUrl =baseURL+"/user";
    public static String getUserURL =baseURL+"/user/{username}";
    public static String deleteUserUrl =baseURL+"/user/{username}";
    public static String putUserUrl =baseURL+"/user/{username}";

    //Routes for Store Module
    public static String postStoreUrl=baseURL+"/store/order";
    public static String getStoreUrl=baseURL+"/store/order/{orderId}";

    public static String deleteStoreUrl=baseURL+"/store/order/{orderId}";

    public static String getInventoryUrl=baseURL+"/store/inventory";


}
