def solution(s):
    slist = s.split(" ")
    answer = ''
    for s in slist :
        for i in range(len(s)) :
            if i % 2 == 0 :
                answer += s[i].upper()
            else :
                answer += s[i].lower()
        answer += " "
    return answer[:len(answer)-1]