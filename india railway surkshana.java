rimport java.util.Random;

public class Main {
    public static void main(String[] args) {
        int trainWeight = generateRandomWeight();
        int trainSpeed = measureTrainSpeed();
        if (trainWeight <= 10000) {
            sendNormalMessage(trainWeight, trainSpeed);
        } else {
            int crashTime = generateRandomCrashTime();
            double[] crashCoordinates = generateRandomCrashCoordinates();
            sendDangerMessage(trainWeight, trainSpeed, crashTime, crashCoordinates);
        }
    }

    private static int generateRandomWeight() {
        return new Random().nextInt(14000) + 1000;
    }

    private static int measureTrainSpeed() {
        return new Random().nextInt(150);
    }

    private static int generateRandomCrashTime() {
        // Generate a random hour between 0 and 23 for Indian time
        return new Random().nextInt(24);
    }

    private static double[] generateRandomCrashCoordinates() {
        // Generate random latitude and longitude coordinates for the crash location
        double latitude = 12.9716 + (new Random().nextDouble() * (28.6139 - 12.9716));
        double longitude = 77.5946 + (new Random().nextDouble() * (77.5946 - 88.3639));
        return new double[]{latitude, longitude};
    }

    private static void sendNormalMessage(int weight, int speed) {
        System.out.println("Train weight: " + weight + " tons");
        System.out.println("Train speed: " + speed + " km/h");
        System.out.println("Everything is fine.");
    }

    private static void sendDangerMessage(int weight, int speed, int crashTime, double[] crashCoordinates) {
        System.out.println("Train weight: " + weight + " tons");
        System.out.println("Train speed: " + speed + " km/h");
        System.out.println("Danger: Train weight exceeds 10,000 tons!");
        System.out.println("Crash Time (Indian Time): " + crashTime + " hours");
        System.out.println("Crash Coordinates (Latitude, Longitude): " + crashCoordinates[0] + ", " + crashCoordinates[1]);
    }
}
