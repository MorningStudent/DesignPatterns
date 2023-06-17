public class Laptop extends Product{

    private String CPU;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    @Override
    public String toString() {
        return "Laptop [name=" + getName() + ", price=" + getPrice() + ", CPU=" + CPU + "]";
    }
}
