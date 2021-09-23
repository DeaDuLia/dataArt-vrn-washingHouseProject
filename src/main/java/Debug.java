public class Debug {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("]");
    }

    public static void printStats (String action, int[] washingMachines, int time, int tmpMax, int tmpMin) {
        System.out.println(action);
        printArray(washingMachines);
        switch (action) {
            default:
            case "add":
                System.out.println("time:" + time);
                System.out.println("tmpMax:" + tmpMax);
                System.out.println("tmpMin:" + tmpMin);
                break;
            case "min":
                System.out.println("tmpMin:" + tmpMin);
                break;
            case "max":
            case "removeMin":
                System.out.println("tmpMax:" + tmpMax);
                break;
        }
    }
}
