package bosscoder

object Recursion {


    private lateinit var ans: MutableList<MutableList<Int>>

    //    46. Permutations
    fun permute(nums: IntArray): List<List<Int>> {
        ans = mutableListOf()
        helper(nums, mutableListOf())
        return ans
    }

    private fun helper(arr: IntArray, used: MutableList<Int>) {
        if (arr.size == used.size) {
            if (!ans.contains(ArrayList(used))) {
                ans.add(ArrayList(used))
            }
            return
        }
        for (element in arr) {
            if (!used.contains(element)) {
                used.add(element)
                helper(arr, used)
                used.remove(element)
            }
        }
    }

    //    47. Permutations II
    fun permute2(nums: IntArray): List<List<Int>> {
        ans = mutableListOf()
        nums.sort()
        helper2(nums, mutableListOf(), BooleanArray(nums.size))
        return ans
    }

    private fun helper2(arr: IntArray, used: MutableList<Int>, visibility: BooleanArray) {
        if (arr.size == used.size) {
            if (!ans.contains(ArrayList(used))) {
                ans.add(ArrayList(used))
            }
            return
        }
        for (i in arr.indices) {
            if (visibility[i] || (i > 0 && arr[i] == arr[i - 1] && !visibility[i - 1]))
                continue

            if (!used.contains(arr[i])) {
                used.add(arr[i])
                helper2(arr, used, visibility)
                used.removeLast()
            }
        }
    }

//    78. Subsets
//    Input: nums = [1,2,3]
//    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    fun subsets(nums: IntArray): List<List<Int>> {
        ans = mutableListOf()
        helper3(nums, mutableListOf(), 0)
        return ans
    }

    private fun helper3(arr: IntArray, currentSet: MutableList<Int>, idx: Int) {
        if (idx == arr.size) {
            ans.add(ArrayList(currentSet))
            return
        }
        currentSet.add(arr[idx])
        helper3(arr, currentSet, idx + 1)
        currentSet.removeLast()
        helper3(arr, currentSet, idx + 1)

    }


    fun print(a: Int) {
        if (a == 0) return
        println(a)
        print(a - 1)
        println(a)
    }

    fun ifPalan(string: String, a: Int, b: Int): Boolean {
        if (a >= b) {
            return true
        }
        if (string[a] != string[b]) {
            return false
        } else {
            ifPalan(string, a + 1, b - 1)
        }
        return false
    }

    fun fact(n: Int): Int {
        return if (n > 1) (n * fact(n - 1)) else 1
    }

    fun powe(a: Int, b: Int): Int {
        if (b == 1) return a
        return a * powe(a, b - 1)
    }

    fun multiply(a: Int, b: Int): Int {
        if (b == 0) return 0
        return a + multiply(a, b - 1)
    }


    fun fib(n: Int): Int {
        if (n == 0 || n == 1) return n
        return fib(n - 2) + fib(n - 1)
    }

}