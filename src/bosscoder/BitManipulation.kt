package bosscoder

import kotlin.math.abs

class BitManipulation {

    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE

        val sign = if ((dividend < 0) xor (divisor < 0)) -1 else 1
        var dividendUnsigned = abs(dividend)
        val divisorUnsigned = abs(divisor)
        var result = 0

        while (dividendUnsigned >= divisorUnsigned) {
            var temp = divisorUnsigned
            var multiple = 1

            while (dividendUnsigned >= temp shl 1) {
                temp = temp shl 1
                multiple = multiple shl 1
            }

            dividendUnsigned -= temp
            result += multiple
        }

        return result * sign
    }

    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var count = 0
        for (i in words.indices) {
            for (item in allowed) {
                words[i] = words[i].replace(item.toString(), "")
            }
            if (words[i].isEmpty()) {
                count++
            }
        }
        return count
    }

    fun printBinaryWithZeros(number: Int, length: Int) {
        val binaryString = Integer.toBinaryString(number)
        val formattedBinary = binaryString.padStart(length, '0')
        println(formattedBinary)
    }

    fun singleNumber2(nums: IntArray): Int {
        var ones = 0
        var twice = 0
        for (num in nums) {
            ones = ones xor (num and twice.inv())
            twice = twice xor (num and ones.inv())
        }
        return ones

    }

    fun evenOddBit(n: Int): Boolean {
        return (n and 1) == 0
    }

    fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
        var sum = 0
        for (indices in nums.indices) {
            var count = 0
            var number = indices
            while (number != 0) {
                number = number and (number - 1)
                count++
            }
            if (count == k) {
                sum += nums[indices]
            }
        }
        return sum
    }

    fun findIthBit(number: Int, i: Int): Int {
        val mask = 1 shl i
        if ((number and mask) == 0)
            return 0
        return 1
    }

    fun bitSwap(a: Int, b: Int) {
        var first = a
        var second = b
        println("Before: a $first and b $second")
        first = first xor second
        second = first xor second
        first = first xor second
        println("After: a $first and b $second")
    }

    // find count of 1
    fun hammingWeight(n: Int): Int {
        var count = 0
        var number = n
        while (number != 0) {
            number = number and (number - 1)
            count++
        }
        return count
    }


    fun xorOperation(n: Int, start: Int): Int {
        var sum = 0
        for (i in 0 until n) {
            sum = sum xor (start + 2 * i)
        }
        return sum
    }

    fun decode(encoded: IntArray, first: Int): IntArray {
        val resultArr = IntArray(encoded.size + 1)
        resultArr[0] = first
        for (i in encoded.indices) {
            resultArr[i + 1] = (resultArr[i] xor encoded[i])
        }
        return resultArr
    }


    fun singleNumber3(nums: IntArray): IntArray {
        var diff = 0
        for (num in nums) {
            diff = diff xor num
        }
        val rightmostSetBit = diff and diff.inv()

        var num1 = 0
        var num2 = 0
        for (num in nums) {
            if (num and rightmostSetBit == 0) {
                num1 = num1 xor num
            } else {
                num2 = num2 xor num
            }
        }
        return intArrayOf(num1, num2)
    }



    fun totalHammingDistance(nums: IntArray): Int {
        var totalDistance = 0

        for (i in 0 until 32) { // Iterate over each bit position
            var countOnes = 0

            for (num in nums) {
                countOnes += (num ushr i) and 1 // Count '1's at the current bit position
            }

            val countZeros = nums.size - countOnes // Calculate '0's as the complement of '1's
            totalDistance += countOnes * countZeros // Update total distance
        }

        return totalDistance
    }

    fun totalHammingDistanceBF(nums: IntArray): Int {
        var sum = 0
        for (i in nums.indices) {
            for (j in i until nums.size) {
                if(nums[i]!=nums[j]) {
                    sum += minBitFlips(nums[i], nums[j])
                    println("${nums[i]}, ${nums[j]}")
                }
            }
        }
        return sum
    }

    fun minBitFlips(start: Int, goal: Int): Int {
        var num = start xor goal
        var count = 0
        while (num != 0) {
            num = num and (num - 1)
            count++
        }
        return count
    }

    fun addBinary(a: String, b: String): String {
        var carry = 0
        val result = StringBuilder()
        var i = a.lastIndex
        var j = b.lastIndex

        while (i >= 0 || j >= 0 || carry > 0) {
            val sum = (if (i >= 0) (a[i] - '0') else 0) + (if (j >= 0) (b[j] - '0') else 0) + carry
            result.insert(0, sum % 2)
            carry = sum / 2
            i--
            j--
        }
        return result.toString()
    }

    fun numberOfSteps(num: Int): Int {
        var count = 0
        var number = num
        while (number != 0) {
            if ((number and 1) == 0) {
                number /= 2
            } else {
                number -= 1
            }
            count++
        }
        return count
    }
}