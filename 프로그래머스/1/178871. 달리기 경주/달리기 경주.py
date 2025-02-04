def solution(players, callings):
    player_index = { players[index]:index for index in range(len(players)) }
    
    for player in callings :
        original_index = player_index[player]
        front_index = original_index - 1
        front_player = players[front_index]
        
        players[front_index] = player
        players[original_index] = front_player
        
        player_index[player] = front_index
        player_index[front_player] = original_index
        
    
    
    return players