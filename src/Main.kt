import algorithms.sorting.SortingAlgo

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val algo = SortingAlgo()

        val array= arrayOf(1, 3, 4, 5, 8 ,7, 9)
        algo.mergeSorting(array)

        for(data in array){
            println(data)
        }

    }
}