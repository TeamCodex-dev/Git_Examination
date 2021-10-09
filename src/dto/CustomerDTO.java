package dto;

public class CustomerDTO {
    private String name;
    private String address;
    private String mobileNumber;
    private String nic;

    public CustomerDTO(String name, String address, String mobileNumber, String nic) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.nic = nic;
    }

    public CustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
