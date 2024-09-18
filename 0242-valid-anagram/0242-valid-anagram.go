func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    freq := [26]int{}

    for _, char := range s {
        freq[char-'a']++
    }

    for _, char := range t {
        freq[char-'a']--
        if freq[char-'a'] < 0 {
            return false
        }
    }

    return true
}