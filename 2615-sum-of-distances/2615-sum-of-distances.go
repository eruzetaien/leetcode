func distance(nums []int) []int64 {
    n := len(nums)
    arr := make([]int64, n)
    indexMap := make(map[int][]int)

    for i, num := range nums {
        indexMap[num] = append(indexMap[num], i)
    }

    for _, indices := range indexMap {
        size := len(indices)
        if size == 1 {
            continue
        }

        leftSum := make([]int, size)
        rightSum := make([]int, size)

        for i := 1; i < size; i++ {
            leftSum[i] = leftSum[i-1] + (indices[i] - indices[i-1]) * i
        }

        for i := size - 2; i >= 0; i-- {
            rightSum[i] = rightSum[i+1] + (indices[i+1] - indices[i]) * (size - i - 1)
        }

        for i, idx := range indices {
            arr[idx] = int64(leftSum[i] + rightSum[i])
        }

    }

    return arr
}