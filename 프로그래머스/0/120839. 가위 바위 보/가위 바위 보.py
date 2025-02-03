def solution(rsp):
    """
    가위 2 바위 0
    바위 0 보 5
    보 5 가위 2
    """
    alwaysWin = { '2' : '0', '0' : '5', '5' : '2'}
    return ''.join(alwaysWin[i] for i in rsp)