public class HeapSort {

    public void sort(int[] array) {
        int n = array.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // Функция для преобразования поддерева в кучу
    void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализируем наибольший как корень
        int left = 2 * i + 1; // левый = 2*i + 1
        int right = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Если правый дочерний элемент больше, чем наибольший на данный момент
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Если наибольший не корень
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивно преобразуем в кучу затронутое поддерево
            heapify(array, n, largest);
        }
    }

    // Вспомогательная функция для вывода массива
    static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Основной метод для проверки алгоритма
    public static void main(String[] args) {
        int[] array = {123, 211, 143, 185, 46, 75};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);

        System.out.println("Sorted array is");
        printArray(array);
    }

}
