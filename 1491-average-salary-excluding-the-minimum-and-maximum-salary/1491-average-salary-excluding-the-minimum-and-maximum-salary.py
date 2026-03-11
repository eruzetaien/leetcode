class Solution:
    def average(self, salary: List[int]) -> float:
        n : int = len(salary) 
        if n <= 2:
            return 0

        min_salary : int = min(salary[0],salary[1])
        max_salary : int = max(salary[0],salary[1])

        sum : int = 0
        count: int = 0
        for sal in salary:
            if (sal == min_salary or sal == max_salary):
                continue
            elif (sal < min_salary):
                sum += min_salary
                min_salary = sal
            elif (sal > max_salary):
                sum += max_salary
                max_salary = sal
            else:
                sum += sal
            count += 1

        return sum / count
