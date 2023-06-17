public class Phone extends Product{

    private int diagonal;

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Phone [name=" + getName() + ", price=" + getPrice() + ", diagonal=" + diagonal + "]";
    }
    
}
