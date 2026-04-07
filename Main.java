import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalSystem rs = new RentalSystem();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] cmd = sc.nextLine().split(" ");

            switch (cmd[0]) {
                case "ADD":
                    rs.addVehicle(cmd[1], cmd[2], cmd[3], Integer.parseInt(cmd[4]));
                    break;

                case "RENT":
                    boolean promo = cmd.length == 4;
                    rs.rentVehicle(cmd[1], Integer.parseInt(cmd[2]), promo);
                    break;

                case "RETURN":
                    rs.returnVehicle(cmd[1]);
                    break;

                case "DETAIL":
                    rs.detailVehicle(cmd[1]);
                    break;

                case "COUNT":
                    rs.countVehicle();
                    break;
            }
        }
    }
}