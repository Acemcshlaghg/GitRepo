import math;

def findFirstZero(grid):
    for r in range(9):
        for c in range(9):
            if(grid[r][c] == 0):
                return [r,c];
            elif(r == 8 and c == 8 and grid[r][c] != 0):
                print(grid);
                return False;
    
grid = [
[3, 0, 6, 5, 0, 8, 4, 0, 0],
[5, 2, 0, 0, 0, 0, 0, 0, 0],
[0, 8, 7, 0, 0, 0, 0, 3, 1],
[0, 0, 3, 0, 1, 0, 0, 8, 0],
[9, 0, 0, 8, 6, 3, 0, 0, 5],
[0, 5, 0, 0, 9, 0, 6, 0, 0],
[1, 3, 0, 0, 0, 0, 2, 5, 0],
[0, 0, 0, 0, 0, 0, 0, 7, 4],
[0, 0, 5, 2, 0, 6, 3, 0, 0]];
tempGrid = grid;
def isPossible(r, c, val, gridVar):
    if(gridVar[r][c] == val):
        return True;
    elif(val > 9):
        return False;
    elif(gridVar[r][c] != 0):
        return False;
    for x in range(9):
        if(gridVar[r][x] == val or gridVar[x][c] == val):
            return False;
    for segX in range(math.floor(r/3) * 3, math.floor(r/3) * 3 + 3):
            for segY in range(math.floor(c / 3) * 3, math.floor(c / 3) * 3 + 3):
                if(gridVar[segX][segY] == val):
                    return False;
    return True;


def solve(tempGridVar):
    firstZero = findFirstZero(tempGridVar);
    if(firstZero == False):
        grid = tempGridVar;
        return True;
    
    r, c = firstZero[0], firstZero[1];
    val = 1;
    while(isPossible(r, c, val, tempGridVar) == False):
        val += 1;
    print(val);
    tempGridVar[r][c] = val;
    solve(tempGridVar);


for x in range(grid.__len__()):
        print(grid[x]);
        
solve(tempGrid);

# print grid

