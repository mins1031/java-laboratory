package java_lab.callbook.vo;

public class CallBookVo {

    private String name;
    private String phone;

    public CallBookVo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
