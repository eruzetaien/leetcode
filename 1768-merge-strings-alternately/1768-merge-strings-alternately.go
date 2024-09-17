func mergeAlternately(word1 string, word2 string) string {
    result := ""
	word1Pointer := 0
	word2Pointer := 0

	for word1Pointer < len(word1) && word2Pointer < len(word2) {
		result += string(word1[word1Pointer])
		result += string(word2[word2Pointer])

		word1Pointer++
		word2Pointer++
	}

	for word1Pointer < len(word1) {
		result += string(word1[word1Pointer])
		word1Pointer++
	}

	for word2Pointer < len(word2) {
		result += string(word2[word2Pointer])
		word2Pointer++
	}

	return result
}