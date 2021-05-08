package authenticate;

public enum option {
    Admin, Employee;

    private option(){}

    public String value(){
        return name();
    }

    public static option fromValue(String r){
        return valueOf(r);
    }
}
