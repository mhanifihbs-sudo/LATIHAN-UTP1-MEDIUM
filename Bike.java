public class Bike extends Vehicle {

    public Bike(String kode, String nama, int harga) {
        super(kode, nama, harga);
    }

    @Override
    public String getTipe() {
        return "BIKE";
    }
}