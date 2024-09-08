package algorithms.searching

import algorithms.validateEmpty

class LinearSearch {


    fun unSortedSearch(array: Array<Int>, value: Int): Int {
        array.apply {
            if (validateEmpty(this)) return -1
            for (i in 0 until this.size) {
                if (value == array[i]) {
                    return i
                }
            }
        }
        return -1
    }

    fun sortedSearch(array: Array<Int>, value: Int): Int {
        array.apply {
            if (validateEmpty(this)) return -1
            for (i in 0 until this.size) {
                if (value == array[i]) {
                    return i
                } else if (value < array[i]) {
                    return -1
                }
            }
        }
        return -1
    }


}