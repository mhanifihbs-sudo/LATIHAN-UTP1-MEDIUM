import java.util.HashMap;

public class RentalSystem {
    private HashMap<String, Vehicle> data = new HashMap<>();

    public void addVehicle(String tipe, String kode, String nama, int harga) {
        if (data.containsKey(kode)) {
            System.out.println("Kendaraan sudah terdaftar");
            return;
        }

        if (tipe.equals("CAR")) {
            data.put(kode, new Car(kode, nama, harga));
        } else {
            data.put(kode, new Bike(kode, nama, harga));
        }

        System.out.println(tipe + " " + kode + " berhasil ditambahkan");
    }

    public void rentVehicle(String kode, int hari, boolean promo) {
        if (!data.containsKey(kode)) {
            System.out.println("Kendaraan tidak ditemukan");
            return;
        }

        Vehicle v = data.get(kode);

        if (!v.isTersedia()) {
            System.out.println("Kendaraan sedang disewa");
            return;
        }

        int total = v.getHarga() * hari;

        if (promo) {
            if (v instanceof Car) {
                total -= 20000;
            } else {
                total -= 10000;
            }
        }

        if (total < 0) total = 0;

        v.setTersedia(false);
        System.out.println("Total sewa " + kode + ": " + total);
    }

    public void returnVehicle(String kode) {
        if (!data.containsKey(kode)) {
            System.out.println("Kendaraan tidak ditemukan");
            return;
        }

        Vehicle v = data.get(kode);

        if (v.isTersedia()) {
            System.out.println("Kendaraan belum disewa");
            return;
        }

        v.setTersedia(true);
        System.out.println(kode + " berhasil dikembalikan");
    }

    public void detailVehicle(String kode) {
        if (!data.containsKey(kode)) {
            System.out.println("Kendaraan tidak ditemukan");
            return;
        }

        Vehicle v = data.get(kode);

        System.out.println(
            v.getKode() + " | " +
            v.getTipe() + " | " +
            v.getNama() + " | harga: " +
            v.getHarga() + " | status: " +
            v.getStatus()
        );
    }

    public void countVehicle() {
        System.out.println("Total kendaraan: " + data.size());
    }
}