def solution(num_list, n):
    
    answer = []
    sub_list = []
    for i in num_list : 
        if len(sub_list) != n :
            sub_list.append(i)
        elif len(sub_list) == n :
            answer.append(sub_list)
            sub_list = []
            sub_list.append(i)
        
    if len(sub_list) > 0 :
        answer.append(sub_list)
    return answer