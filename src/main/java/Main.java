
public class Main {
    /*
     * 1 Прачечная.
     =====================================
     * В прачечную приходят клиенты с целью воспользоваться стиральными машинами.
     * Каждому клиенты требуется указанное число минут на стирку.
     * Как только машинка освобождается с ней тут же начинает работать следующий клиент.
     * Найти сколько минут потребуется прачечной, чтобы обслужить всех клиентов.
     * На входе имеем:
     * целочисленный массив — сколько минут требуется клиенту на стирку своих вещей.
     * Число стиральных машин в прачечной.
     =====================================
     Например:
     * f([3, 7, 8, 4], 1) => 22, то есть все клиенты обслуживаются последовательно,
     * f([3, 15, 2, 6], 2) => 15, так как пока второй клиент 15 минут стирается во второй машинке,
     * первая машинка справится со всеми оставшимися клиентами.
     */
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 7, 8, 4};
        int[] arr2 = new int[]{3, 15, 2, 6};
        int[] times1 = new int[]{1, 2, 3, 4, 5};
        int[] times2 = new int[]{1, 1, 1, 1};
        System.out.println("Пример 1: " + f(arr1, 1));
        System.out.println("Пример 2: " + f(arr2, 2));
        System.out.println("Тест 1: " + f(times1, 2));
        System.out.println("Тест 2: " + f(times2, 15));
    }
    public static int f(int[] times, int washingMachinesCount) {
        int[] washingMachines = new int[washingMachinesCount];
        int sz = times.length;
        int time = 0;
        int tmpMax = 0;
        int tmpMin = times[0];
        int step = Math.min(sz, washingMachinesCount);
        for (int index = 0; index < sz; tmpMin = 0) {
            for (int i = 0; index < sz && i < washingMachinesCount; i++) {
                if (washingMachines[i] == 0) {
                    washingMachines[i] = times[index];
                    index++;
                    if (washingMachines[i] > tmpMax) {
                        time = index <= step? washingMachines[i] : time + washingMachines[i]-tmpMax;
                        tmpMax = washingMachines[i];
                    }
                }
                if (tmpMin == 0 || washingMachines[i] < tmpMin) tmpMin = washingMachines[i];
            }
            for (int i = 0; i < washingMachinesCount; i++) {
                if (washingMachines[i] == tmpMax) {
                    tmpMax = washingMachines[i] - tmpMin;
                }
                washingMachines[i] -= tmpMin;
            }
        }
        return time;
    }
}
