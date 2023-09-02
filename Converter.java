public class Converter {

    int distance = 75;
    int calories = 50;

    int convertToKm(int SumSteps) {
        int sumKm = (distance * SumSteps) / 100000;
        return sumKm;
    }

    int convertStepsToKilocalories(int SumSteps) {
        int sumKilocalories = SumSteps * calories / 1000;
        return sumKilocalories;
    }
}