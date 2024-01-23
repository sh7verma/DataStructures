package algorithms.sorting

class SortingAlgo {
    //    WCP= O(n^2)
    //    ACP= O(n^2)
    //    SPACE C= O(1) one temp variable
    fun bubbleSort(array: Array<Int>) {
        if (validateEmpty(array)) return
        val size = array.size
        var temp: Int
        for (i in 0 until size - 1) {
            for (j in 0 until size - i - 1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }

    fun bubbleSortControlledSwap(array: Array<Int>) {
        if (validateEmpty(array)) return
        val size = array.size
        var temp: Int
        var swaps = 1
        var i = 0
        while (i < size - 1 &&S swaps == 1) {
            for (j in 0 until size - i - 1) {
                swaps = 0
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                    swaps = 1
                }
            }
            i++
        }
    }

    fun more(value1: Int, value2: Int): Boolean {
        return value1 > value2
    }


    //    WCP= O(n^2)
    //    ACP= O(n^2)
    //    BCP= O(n)
    //    SPACE C= O(1) one temp variable
    fun insertionSort(array: Array<Int>) {
        if (validateEmpty(array)) return
        val size = array.size
        var temp: Int
        var j: Int
        for (i in 1 until size) {
            temp = array[i]
            j = i - 1
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = temp
        }
    }

    //    WCP= O(n^2)
    //    ACP= O(n^2)
    //    BCP= O(n^2)
    //    SPACE C= O(1) one temp variable
    fun selectionSort(array: Array<Int>) {
        if (validateEmpty(array)) return
        val size = array.size

        for (i in 0 until size - 1) {
            var min = i
            for (j in i + 1 until size) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            if (min != i) {
                array.swap(min, i)
            }
        }


    }


    //    WCP= O(nlogn)
    //    ACP= O(nlogn)
    //    BCP= O(nlogn)
    //    SPACE C= O(n) one temp array variable
    fun mergeSorting(array: Array<Int>) {
        if (validateEmpty(array)) return
        val low = 0
        val high = array.size - 1

        array.mergeSort(low, high)
    }


    fun Array<Int>.mergeSort(low: Int, high: Int) {
        if (low < high) {
            val mid = (low + high) / 2
            mergeSort(low, mid)
            mergeSort(mid + 1, high)
        }
    }

    fun Array<Int>.merge(low: Int, mid: Int, high: Int) {
        val resultArray: Array<Int> = this
        var i = low
        var j = mid + 1
        var k = low

        while (i < mid && j <= high) {
            if (this[j] < this[j]) {
                resultArray[k] = this[i]
                i++
            } else {
                resultArray[k] = this[j]
                j++
            }
            k++
        }
        if (i > mid) {
            while (j <= high) {
                resultArray[k] = this[j]
                k++
                j++
            }
        } else {
            while (i <= mid) {
                resultArray[k] = this[i]
                k++
                i++
            }
        }
        for (y in low until high) {
            this[y]=resultArray[y]
        }
    }


    //    WCP= O(n^2)
    //    ACP= O(nlogn)
    //    BCP= O(nlogn)
    //    SPACE C= O(nlogn) one temp variable
    fun quickSorting(array: Array<Int>) {
        if (validateEmpty(array)) return
        val high = array.size - 1
        array.quickSort(0, high)
    }

    fun Array<Int>.quickSort(low: Int, high: Int) {
        if (low < high) {
            val pivot = this.partition(low, high)
            quickSort(low, pivot - 1)
            quickSort(pivot + 1, high)
        }
    }


    fun Array<Int>.partition(low: Int, high: Int): Int {
        val pivot = this[low]
        var i = low
        var j = high
        while (i < j) {
            while (this[i] <= pivot) i++
            while (this[j] > pivot) j--
            if (i < j)
                this.swap(i, j)
        }
        this.swap(j, low)

        return j;

    }

    companion object {
        private fun validateEmpty(array: Array<Int>?): Boolean {
            return array.isNullOrEmpty()
        }

        fun Array<Int>.swap(first: Int, last: Int) {
            val temp = this[first]
            this[first] = this[last]
            this[last] = temp
        }
    }
}