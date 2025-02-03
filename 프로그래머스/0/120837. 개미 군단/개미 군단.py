def solution(hp):
    jangun, m = divmod(hp, 5)
    byeonjeong, m2 = divmod(m, 3)
    il = m2
    answer = jangun + byeonjeong + il
    return answer