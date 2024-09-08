package bosscoder

import algorithms.validateEmpty
import java.lang.Math.ceil
import kotlin.math.abs

class BinarySearch {

    // [3,6,7,11], h = 8
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (calTotalHrs(piles, mid) <= h) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun calTotalHrs(piles: IntArray, mid: Int): Int {
        var sum = 0
        piles.forEach {
            sum += ceil(it.toDouble() / mid).toInt()
        }
        return abs(sum)
    }

    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()
        var left = 1
        var right = position.lastIndex

        while (left + 1 < right) {
            val mid = left + (right - left) / 2

            if (isValid(mid, position, m)) left = mid
            else right = mid - 1
        }

        return if (isValid(right, position, m)) right else left
    }

    fun isValid(mid: Int, position: IntArray, m: Int): Boolean {
        var res = 1
        var start = position.first()

        position.forEach {
            if (start + mid <= it) {
                res++
                start = it
            }
        }

        return res >= m
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (numsArray in matrix) {
            var left = 0
            var right = numsArray.lastIndex
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (numsArray[mid] == target) {
                    return true
                }
                if (numsArray[mid] < target) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return false
    }

    //153. Find Minimum in Rotated Sorted Array
//    [3,4,5,1,2]
//     4,5,1,2,3
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[left] < nums[right]) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return nums[left]
    }


    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()
        var left = 0
        var right = nums.lastIndex
        var targetPosition = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (target == nums[mid]) {
                targetPosition = mid
                break
            }
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        if (targetPosition == -1) {
            return emptyList()
        }
        left = targetPosition
        right = targetPosition

        val returnArray = mutableListOf<Int>()
        returnArray.add(targetPosition)
        while (left > 0 && nums[left - 1] == target) {
            left--
            returnArray.add(left)
        }
        while (right < nums.lastIndex && nums[right + 1] == target) {
            right++
            returnArray.add(right)
        }
        returnArray.sort()
        return returnArray
    }

    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    fun search(nums: IntArray, target: Int): Int {
        nums.apply {
            var high = this.lastIndex
            var low = 0
            while (low <= high) {
                val mid = low + (high - low) / 2
                if (this[mid] == target) {
                    return mid
                }
                if (this[low] <= this[mid]) {
                    if (target >= this[low] && target < this[mid]) {
                        high = mid - 1
                    } else {
                        low = mid + 1
                    }
                } else {
                    if (target > this[mid] && target <= this[high]) {
                        low = mid + 1
                    } else {
                        high = mid - 1
                    }
                }
            }
        }
        return -1
    }


    fun searchRange(nums: Array<Int>, target: Int): IntArray {
        var left = 0
        var right = nums.lastIndex

        val returnArray = intArrayOf(-1, -1)
        if (nums.isEmpty()) {
            return returnArray
        }
        var ansPosition = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                ansPosition = mid
                println(ansPosition)
                break
            } else if (target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        returnArray.forEach {
            println(it)
        }
        if (ansPosition == -1) {
            return returnArray
        }
        left = ansPosition
        right = ansPosition
        while (right < nums.lastIndex && target == nums[right + 1]) {
            right++
        }
        while (left > 0 && target == nums[left - 1]) {
            left--
        }
        returnArray[0] = left
        returnArray[1] = right
        returnArray.forEach {
            println(it)
        }
        return returnArray
    }

    //  Time C= O(logn)
    fun search(array: Array<Int>, value: Int): Int {
        array.apply {
            if (validateEmpty(this)) return -1
            var high = this.size - 1
            var low = 0
            while (low <= high) {
                val mid = (low + high) / 2
                if (this[mid] == value) {
                    return mid
                } else if (value > this[mid]) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
        }
        return -1
    }

    fun searchInInfiniteArray(array: Array<Int>, value: Int): Int {
        array.apply {
            if (validateEmpty(this)) return -1
            var high = 1
            var low = 0
            val exponent = 2

            try {
                while (this[high] < value) {
                    low = high
                    high *= exponent
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                e.printStackTrace()
            }


            while (low <= high) {
                val mid = (low + high) / 2
                if (this[mid] == value) {
                    return mid
                } else if (value > this[mid]) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
        }
        return -1
    }

}