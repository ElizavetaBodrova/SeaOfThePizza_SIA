package lizun.dto;

public class CustomerDto {
    private String phone;
    private String role;
    private Integer countOfOrders;
    private Integer sumOfAllOrders;


    public CustomerDto(String phone, String role, Integer countOfOrders, Integer sumOfAllOrders) {
        this.phone = phone;
        this.role = role;
        this.countOfOrders = countOfOrders;
        this.sumOfAllOrders = sumOfAllOrders;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
    }

    public Integer getSumOfAllOrders() {
        return sumOfAllOrders;
    }

    public void setSumOfAllOrders(Integer sumOfAllOrders) {
        this.sumOfAllOrders = sumOfAllOrders;
    }

}
