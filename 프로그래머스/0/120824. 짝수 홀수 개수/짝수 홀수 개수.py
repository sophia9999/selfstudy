def solution(num_list):
    odd = list()
    even = list()
    for i in num_list :
        if i % 2 == 0 :
            even.append(i)
        else :
            odd.append(i)
            
    answer = [len(even), len(odd)]
    
    return answer