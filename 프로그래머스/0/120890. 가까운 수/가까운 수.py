def solution(array, n):
    absolute_distance = [ abs(i-n) for i in array]
    min_index = absolute_distance.index(min(absolute_distance))


    answer = n - absolute_distance[min_index]
    if answer not in array :
        answer = n + absolute_distance[min_index]

    return answer