class Solution:
    def hIndex(self, citations: List[int]) -> int:
        sorted_citations = sorted(citations, reverse=True)

        if (sorted_citations[0] <= 0):
            return 0

        if (len(citations) == 1):
            return 1
        
        paper_with_citation_count = 0
        for i, citation in enumerate(sorted_citations):
            if (citation == 0):
                return paper_with_citation_count
            else :
                paper_with_citation_count +=1

            if (i + 1 >= citation):
                if (citation > paper_with_citation_count -1):
                    return citation
                else :
                    return paper_with_citation_count -1

        return paper_with_citation_count