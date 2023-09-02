import java.util.Scanner;

class StepTracker {
    Converter converter = new Converter();
    MonthData monthData = new MonthData();
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int numberMonth = scanner.nextInt();
        while (true) {
            if (numberMonth > 0 && numberMonth <= 12)
                break;
            else System.out.println("Ошибка. Введите номер месяца от 1 до 12");
            numberMonth = scanner.nextInt();
        }
        // ввод и проверка номера месяца

        System.out.println("Введите день от 1 до 30 (включительно)");
        int numberDay = scanner.nextInt();
        while (true) {
            if (numberDay > 0 && numberDay <= 30)
                break;
            else System.out.println("Ошибка. Такого дня в месяце не существует. Введите день от 1 до 30");
            numberDay = scanner.nextInt();
        }
        // ввод и проверка дня

        System.out.println("Введите количество шагов");
        int quantitySteps = scanner.nextInt();
        while (true) {
            if (quantitySteps > 0)
                break;
            else System.out.println("Ошибка. Введите количество шагов больше 0");
            quantitySteps = scanner.nextInt();
        }
        // ввод и проверка количества шагов

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData [numberMonth - 1];
        // Сохранение полученных данных
        monthData.days[numberDay -1] = quantitySteps;
    }
    void changeStepGoal() {
        System.out.println("Ваша цель шагов за день");
        int goal = scanner.nextInt();
        while (true) {
            if (goal > 0)
                break;
            else System.out.println("Ошибка. Введите цель по количеству шагов больше 0");
            goal = scanner.nextInt();
            goalByStepsPerDay = goal;
        }
    }
    void printStatistic() {

        System.out.println("Введите число месяца");
        int month = scanner.nextInt();

        while (true) {
            if (month > 0 && month <= 12)
                break;
            else System.out.println("Ошибка. Введите число месяца от 1 до 12");
            month = scanner.nextInt();
        }

        monthData = monthToData[month - 1]; // получение соответствующего месяца
        int SumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("За этот месяц вы прошли " + SumSteps + " шагов"); //вывод суммы шагов за месяц
        int maxSteps = monthData.maxSteps(); // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимально пройденное количество шагов за месяц составило " + maxSteps); // вывод среднего пройденного количества шагов за месяц
        int sum = converter.convertToKm(SumSteps);
        System.out.println("За этот месяц вы прошли " + sum + " километров"); // вывод пройденной за месяц дистанции в км
        int sumKilocalories = converter.convertStepsToKilocalories(SumSteps);
        System.out.println("За этот месяц вы сожгли " + sumKilocalories + " килокалорий"); // вывод количества сожжённых килокалорий за месяц
        int finalSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия шагов за месяц" +finalSeries); // вывод лучшей серии

    }
}