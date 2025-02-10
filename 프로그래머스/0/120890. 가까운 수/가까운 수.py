def solution(array, n):
    absolute_distance = [ (abs(i-n), i) for i in array]
    absolute_distance.sort()

    return absolute_distance[0][1]