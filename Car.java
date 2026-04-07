public class Car extends Vehicle {

    public Car(String kode, String nama, int harga) {
        super(kode, nama, harga);
    }

    @Override
    public String getTipe() {
        return "CAR";
    }
}