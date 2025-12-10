package prac23;

public class QueueTest {
    public static void main(String[] args) {
        testArrayQueueModule();
        testArrayQueueADT();
        testOOPQueue(new ArrayQueue(), "ArrayQueue");
        testOOPQueue(new LinkedQueue(), "LinkedQueue");
    }

    private static void testArrayQueueModule() {
        System.out.println("=== Testing ArrayQueueModule ===");
        ArrayQueueModule.clear();
        for (int i = 1; i <= 5; i++) {
            ArrayQueueModule.enqueue(i);
        }
        System.out.println("size = " + ArrayQueueModule.size()); // 5
        System.out.println("first element = " + ArrayQueueModule.element()); // 1

        while (!ArrayQueueModule.isEmpty()) {
            System.out.println("dequeue -> " + ArrayQueueModule.dequeue());
        }
        System.out.println("isEmpty = " + ArrayQueueModule.isEmpty()); // true
        System.out.println();
    }

    private static void testArrayQueueADT() {
        System.out.println("=== Testing ArrayQueueADT ===");
        ArrayQueueADT q = new ArrayQueueADT();
        for (int i = 10; i <= 50; i += 10) {
            ArrayQueueADT.enqueue(q, i);
        }
        System.out.println("size = " + ArrayQueueADT.size(q)); // 5
        System.out.println("first element = " + ArrayQueueADT.element(q)); // 10

        while (!ArrayQueueADT.isEmpty(q)) {
            System.out.println("dequeue -> " + ArrayQueueADT.dequeue(q));
        }
        System.out.println("isEmpty = " + ArrayQueueADT.isEmpty(q)); // true
        System.out.println();
    }

    private static void testOOPQueue(Queue queue, String name) {
        System.out.println("=== Testing " + name + " ===");
        queue.clear();
        for (int i = 100; i <= 300; i += 50) {
            queue.enqueue(i);
        }
        System.out.println("size = " + queue.size());
        System.out.println("first element = " + queue.element());

        while (!queue.isEmpty()) {
            System.out.println("dequeue -> " + queue.dequeue());
        }
        System.out.println("isEmpty = " + queue.isEmpty());
        System.out.println();
    }
}
