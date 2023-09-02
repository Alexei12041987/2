import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// создание нового экземпляра
        StepTracker stepTracker = new StepTracker(scanner);
        //void changeStepGoal();
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();// здесь будет логика команды 1
            } else if (command == 2) {
                stepTracker.changeStepGoal();// здесь будет логика команды 2
            } else if (command == 3) {
                stepTracker.printStatistic();// здесь будет логика команды 3
            } else if (command == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
        // здесь будет работа с командами

    }
    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1- Ввести количество шагов за определённый день");
        System.out.println("2- Изменить цель по количеству шагов в день");
        System.out.println("3- Напечатать статистику за определённый месяц");
        System.out.println("4- Выйти из приложения");
    }

}