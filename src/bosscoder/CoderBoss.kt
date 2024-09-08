package bosscoder

import java.lang.Math.abs

class CoderBoss() {


    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex
        val result = intArrayOf(-1, -1)
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                result[0] = left
                result[1] = right
                return result
            } else {
                left++
                right--
            }
        }
        return result

    }

    fun isPalindrome(
        s: String

    ): Boolean {
        var left = 0
        var rignt = s.lastIndex
        while (left <= rignt) {
            if (s[left] == s[rignt]) {
                left++
                rignt--
            } else {
                return false
            }
        }
        return true
    }

    fun removeNonAlphabetic(str: String): String {
        return str.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()
    }

    // [1,2,3,4,5,10,6,7,8,9]
    //-1,1,-2,2,-3,3,-4,4
    fun canArrange(arr: IntArray, k: Int): Boolean {
        var start = 0
        var end = arr.lastIndex

        while (start < end) {
            if ((arr[start] + arr[end]) % k == 0) {
                start++
                end--
            } else {
                return false
            }
        }
        return true
    }

    fun trailingZeroes(n: Int): Int {
        var count = 0
        var i = 5
        while (n / i >= 1) {
            count += n / i
            i *= 5
        }
        return count
    }

    fun calculateFactorial(number: Int): Long {
        var factorial = 1L
        for (i in 1..number) {
            factorial *= i
        }
        return factorial
    }

    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val lengthA = abs(ax2 - ax1)
        val widthA = abs(ay2 - ay1)

        val lenghtB = abs(bx2 - bx1)
        val widthB = abs(by2 - by1)


        var lengthOverlapped = 0
        var withOverlapped = 0

        lengthOverlapped = (minOf(ax2, bx2) - maxOf(ax1, bx1))
        withOverlapped = (minOf(ay2, by2) - maxOf(ay1, by1))

        var areaOverlapped = 0
        if (lengthOverlapped > 0 && withOverlapped > 0) {
            areaOverlapped = area(lengthOverlapped, withOverlapped)
        }

        return (area(lengthA, widthA) + area(lenghtB, widthB)) - areaOverlapped
    }


    fun area(l: Int, b: Int): Int {
        return l * b;
    }

}