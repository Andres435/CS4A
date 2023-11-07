/*
    Design a class named StopWatch. The class contains:
    
    Private data fields startTime and endTime with getter methods.
    A no-arg constructor that initializes startTime with the current time.
    A method named start() that resets the startTime to the current time.
    A method named stop() that sets the endTime to the current time.
    A method named getElapsedTime() that returns the elapsed time for the
    stopwatch in milliseconds.
    
    The program measures the execution time of sorting 100,000 numbers using
    selection sort
*/
public class HW9_6 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        java.util.Random random = new java.util.Random();
        int[] numbers = new int[100000];
        
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        StopWatch stopWatch = new StopWatch();
        selectionSort(numbers);
        stopWatch.stop();

        System.out.println("Sorting 100,000 numbers took " + 
                            stopWatch.getElapsedTime() + " milliseconds");
    }
    
    
    /** 
     * @param list
     */
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) { 
            int min = list[i]; 
            int minIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (min > list[j]) {
                    min = list[j];
                    minIndex = j;
                }
            }   

            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
}


class StopWatch {
    private long startTime = System.currentTimeMillis();
    private long endTime = startTime;


    public StopWatch() {
        this.startTime = 0;
        this.endTime = 0;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}
