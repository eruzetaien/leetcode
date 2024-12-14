func increasingTriplet(nums []int) bool {
    first := nums[0]
    currFirst := first

    second := -1
    for i:= 1; i < len(nums); i++ {
        third := nums[i]
        if third < currFirst {
            currFirst = third
        } else if third > currFirst || third > first {
            if second == -1{
                second = third
            } else {
                if third > second {
                    return true
                } else {
                    second = third
                }
            }            
        }
    }
    return false
}