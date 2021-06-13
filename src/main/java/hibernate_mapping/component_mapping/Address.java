package hibernate_mapping.component_mapping;

public class Address {
    private String commune;
    private String district;
    private String province;

    public String getCommune() {
        return commune;
    }

    @Override
    public String toString() {
        return "Address{" +
                "commune='" + commune + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
