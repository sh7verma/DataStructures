package arrays

import kotlin.math.max
import kotlin.math.min

class QuestionsArray {


    fun fizzBuzz(n: Int): List<String> {
        val array = Array(n) { "" }
        for (i in 0..n) {
            array[i] = checkConditions(n)
        }
        return array.toList()
    }

    fun checkConditions(n: Int): String {
        return if (n / 3 == 0 && n / 5 == 0) "FizzBuzz"
        else if (n / 3 == 0) "Fizz"
        else if (n / 5 == 0) "Buzz"
        else n.toString()
    }


    fun maxArea(height: IntArray): Int {
        var total = 0

        for (i in height.indices) {
            for (j in i until height.size) {
                if (area(min(height[i], height[j]), j - i) > total) {
                    total = area(min(height[i], height[j]), j - i)
                }
            }
        }
        return total
    }

    //    [2,3,-2,4]
    fun maxProduct(nums: IntArray): Int {
        var maxProduct = nums.max()
        for (i in 1 until nums.size) {
            if (nums[i - 1] != 0) {
                nums[i] = nums[i - 1] * nums[i]
            } else {
                nums[i] = 1 * nums[i]
            }
            println(nums[i])
            if (nums[i] > maxProduct) {
                maxProduct = nums[i]
            }
        }
        println(maxProduct)
        return maxProduct
    }

//    val chars = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).toIntArray()

    fun maxSubArray(nums: IntArray): Int {
//        var maxSum = 0
//        var currentSum = 0
//        for (data in nums) {
//            currentSum += data
//            if (currentSum > maxSum) {
//                maxSum = currentSum
//            }
//        }
//        return maxSum
        var maxSum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i]
            }
            if (nums[i] > maxSum) {
                maxSum = nums[i]
            }
        }
        return maxSum
    }

    fun maxOperations(nums: IntArray, k: Int): Int {
        var leftPointer = 0
        var rightPointer = nums.lastIndex
        nums.sort()
        var count = 0
        while (leftPointer < rightPointer) {
            val left = nums[leftPointer]
            val right = nums[rightPointer]
            val sum = left + right
            if (sum == k) {
                count++
                leftPointer++
                rightPointer--
            } else if (sum < k) leftPointer++
            else rightPointer--
        }
        println(count)
        return count
    }

    fun maxAreaTwoPointers(height: IntArray): Int {
        var leftPointer = 0
        var rightPointer = height.lastIndex
        var total = 0

        while (leftPointer < rightPointer) {
            val left = height[leftPointer]
            val right = height[rightPointer]
            total = maxOf(total, (rightPointer - leftPointer) * minOf(left, right))
            if (left <= right) leftPointer++
            else rightPointer--
        }
        return total
    }


    fun area(l: Int, b: Int): Int {
        return l * b
    }

    fun increasingTriplet(nums: IntArray): Boolean {
        val leftArray = IntArray(nums.size)
        val rightArray = IntArray(nums.size)
        leftArray[0] = nums[0]
        for (i in 1 until leftArray.size) {
            leftArray[i] = min(leftArray[i - 1], nums[i])
        }
        leftArray.forEach {
            print("$it ")
        }

        println("-------")
        rightArray[nums.lastIndex] = nums[nums.lastIndex]
        for (i in nums.lastIndex - 1 downTo 0) {
            rightArray[i] = max(rightArray[i + 1], nums[i])
        }
        rightArray.forEach {
            print("$it ")
        }

        println("-------")
        for (i in nums.indices) {
            if (leftArray[i] < nums[i] && nums[i] < rightArray[i]) {
                println("true")
                return true
            }
        }
        println("false")
        return false
    }

    fun increasingTriplet2(nums: IntArray): Boolean {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE

        for (num in nums) {
            if (num <= first) {
                first = num
            } else if (num <= second) {
                second = num
            } else {
                return true
            }
        }
        return false
    }


    fun isSubsequence(s: String, t: String): Boolean {
        var result = ""
        var compare = s
        for (item in t.toCharArray()) {
            if (compare.startsWith(item)) {
                result = "$result${item}"
                if (compare.isNotEmpty())
                    compare = compare.substring(1)
            }
        }
        println("result: $result")
        println("compare: $compare")

        println(result == s)
        return result == s

    }

    fun moveZeroes(nums: IntArray): Unit {
        var nonZero = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[nonZero] = nums[i]
                nonZero++
            }
        }
        for (i in nonZero until nums.size) {
            nums[i] = 0
        }
    }

    //    height = [0,1,0,2,1,0,1,3,2,1,2,1]

    //    leftArray
//    1 1 2 2 1 1 3 3 2 2 2 rightArray
//    2 2 2 3 3 1 1 2 2 1 1
    fun trap(height: IntArray): Int {
        val leftArray = IntArray(height.size)
        val rightArray = IntArray(height.size)
        leftArray[0] = height[0]
        rightArray[height.lastIndex] = height.last()
        println("leftArray")
        for (i in 1 until height.size) {
            leftArray[i] = Math.max(leftArray[i - 1], height[i])
            print(leftArray[i].toString() + " ")
        }
        println("rightArray")
        for (i in (height.size - 2) downTo 0) {
            rightArray[i] = Math.max(rightArray[i + 1], height[i])
            print(rightArray[i].toString() + " ")
        }

        var totalWater = 0
        for (i in leftArray.indices) {
            totalWater += min(leftArray[i], rightArray[i]) - height[i]
        }

        println("totalWater")
        println(totalWater)

        return totalWater
    }

//    |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        val a = IntArray(arr1.size)
        val b = IntArray(arr1.size)
        val c = IntArray(arr1.size)
        val d = IntArray(arr1.size)

        for (i in arr1.indices) {
            a[i] = i + arr1[i] + arr2[i]
            b[i] = i + arr1[i] - arr2[i]
            c[i] = i - arr1[i] + arr2[i]
            d[i] = i - arr1[i] - arr2[i]
        }

        return maxOf(
            (findMax(a) - findMin(a)),
            (findMax(b) - findMin(b)),
            (findMax(c) - findMin(c)),
            (findMax(d) - findMin(d))
        )

    }

    fun findMax(arr: IntArray): Int {
        var max = arr[0]
        for (num in arr) {
            if (num > max) {
                max = num
            }
        }
        return max
    }

    fun findMin(arr: IntArray): Int {
        var min = arr[0]
        for (num in arr) {
            if (num < min) {
                min = num
            }
        }
        return min
    }


    fun getConcatenation(nums: IntArray): IntArray {
        val array = IntArray(nums.size * 2) { 0 }
        var position = 0
        var smallPosition = 0
        while (position <= array.size - 1) {
            array[position] = nums[smallPosition]
            if (position == nums.size - 1) {
                smallPosition = 0
            } else {
                smallPosition++
            }
            position++
        }
        return array
    }

    fun mostWordsFound(sentences: Array<String>): Int {
        var maxLength = -1
        for (data in sentences) {
            if (data.split(" ").size > maxLength) {
                maxLength = data.split(" ").size
            }
        }
        return maxLength
    }


    fun productExceptSelf(nums: IntArray): IntArray {
        val array = IntArray(nums.size) { 1 }
        println("nums")
        for (data in nums) {
            println(data)
        }
        // post
        var prefix = 1
        for (i in nums.indices) {
            array[i] = prefix
            prefix *= nums[i]
        }
        println("prefix")
        for (data in array) {
            println(data)
        }

        println("postFix")
        var postFix = 1
        for (i in nums.size - 1 downTo 0) {
            array[i] *= postFix
            postFix *= nums[i]
        }

        for (data in array) {
            println(data)
        }
        return array
    }

//    fun tappingWaterPointer(chars: CharArray): Int {
//        var ans: nt = 0
//        var l = 0
//        var r: Int = n - 1
//        var lmax: Int = INT_MIN
//        var rmax: Int = INT_MIN
//        while (l < r) {
//            lmax = max(lmax, h.get(l))
//            rmax = max(rmax, h.get(r))
//            if (lmax < rmax) {
//                ans += lmax - h.get(l)
//                l++
//            } else {
//                ans += rmax - h.get(r)
//                r--
//            }
//        }
//        return ans
//    }

    fun compress(chars: CharArray): Int {
        var output = chars
        var compressedString = chars[0].toString()
        var value = chars[0]
        var count = 0
        for (data in chars) {
            if (value != data) {
                value = data
                if (count > 1)
                    compressedString = compressedString + count.toString() + value
                else
                    compressedString += value
                count = 0
            }
            count++
        }
        if (count > 1)
            compressedString += count

        println(compressedString)
        println(compressedString.length)

        output = compressedString.toCharArray()


        for (dat in output) {
            println(dat)
        }
        return output.size
    }

    fun reverseWords(s: String): String {
        val wordArray = s.split(" ").toTypedArray()
        var first = 0
        var last = wordArray.size - 1
        while (first < last) {
            wordArray.swap(first, last)
            first++
            last--
        }
        return wordArray.filter { it.trim().isNotEmpty() }.joinToString(" ")
    }


    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var sum = 0
        for (i in mat.indices) {
            sum += mat[i][i] + mat[i][n - i - 1]
        }
        if (n % 2 == 0) {
            sum -= mat[n / 2][n / 2]
        }
        return sum
    }

    fun Array<String>.swap(first: Int, last: Int) {
        val temp = this[first]
        this[first] = this[last]
        this[last] = temp
    }

    fun reverseVowels(s: String): String {
        val vovels = "aeiou"
        val value = StringBuilder()
        var array = s.toCharArray().filter { vovels.contains(it.lowercaseChar()) }
        array = array.reversed()

        var j = 0
        for (i in s.toCharArray().indices) {
            if (vovels.contains(s.toCharArray()[i].lowercaseChar())) {
                value.append(array[j])
                j++
            } else {
                value.append(s.toCharArray()[i])
            }
        }

        return value.toString()
    }

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val array = flowerbed
        var count = 0
        if (array.size == 1 && array[0] == 0) {
            count++
        } else {
            if (array.size >= 2 && array[0] == 0 && array[1] == 0) {
                array[0] = -1
                count++
            }
            for (i in 1 until array.size - 1) {
                if (array[i - 1] == 0 && array[i + 1] == 0) {
                    if (array[i] != 1) {
                        array[i] = -1
                        count++
                    }
                }
            }
            if (array.size >= 2 && array[array.size - 1] == 0 && array[array.size - 2] == 0) {
                count++
            }
        }
        for (da in array) {
            println(da)
        }
        return count >= n
    }

    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {

        val max = candies.max()
        val booleanArray = mutableListOf<Boolean>()

        for (i in candies.indices) {
            candies[i] = candies[i] + extraCandies
            if (candies[i] > max) {
                booleanArray.add(i, true)
            } else {
                booleanArray.add(i, false)
            }
        }

        return booleanArray
    }

    fun gcdOfStrings2(str1: String, str2: String): String {
        // Check if gcd exists
        if (str1 + str2 != str2 + str1) {
            return ""
        }

        // Count gcd of string lengths
        var l1 = str1.length
        var l2 = str2.length
        while (l1 != l2) {
            if (l1 > l2) l1 -= l2
            else l2 -= l1
        }

        return str1.substring(0, l1)
    }

    fun mergeAlternately(word1: String, word2: String): String {
        var finalWord = ""
        for (i in 0 until word1.toCharArray().size) {
            finalWord += (word1.toCharArray()[i])
            if (i <= (word2.length - 1)) {
                finalWord += (word2.toCharArray()[i])
            }
        }
        if (word1.length < word2.length) {
            finalWord += word2.substring(word1.length, word2.length)
        }
        return finalWord
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        var largestDivisor = ""
        for (i in str1.indices) {
            val divisor = str1.substring(0, i + 1)
            if (str1.replace(divisor, "").isEmpty() && str2.replace(divisor, "").isEmpty()) {
                largestDivisor = divisor
            }
        }
        println("largestDivisor:" + largestDivisor.length)
        println("str1:" + str1.length)
        println("str2:" + str2.length)
        return largestDivisor
    }
}