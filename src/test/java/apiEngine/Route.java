package apiEngine;

public class Route {

    public static final String USERS_LIST = "/users";

    public static String getUsers(){
        return USERS_LIST;
    }
    public static String getSpecificUser(String userID){
        return USERS_LIST+ "/" + userID;
    }

}
