import math;

def firstZero(firstZeroGrid):
    for r in range(9):
        for c in range(9):
            if(firstZeroGrid[r][c] == 0):
                return [r,c];#location of first zero
    return True;  # no zeros, puzzle solved
            

def solve(solveGrid):
    if(firstZero(solveGrid) == True):  # if puzzle is solved
        print("Solved:")
        for x in range(solveGrid.__len__()):  # print solved puzzle
            print(solveGrid[x]);
        return True;
    elif(gameOver(solveGrid) == True):
        print("False:");
        for x in range(solveGrid.__len__()):  # print solved puzzle
            print(solveGrid[x]);
        return False;
    r,c = firstZero(solveGrid);
    val = 1;
    solveGrid[r][c] = val;
    while(solve(solveGrid) == False):
        val = val + 1;
        solveGrid[r][c] = val;


def gameOver(gameOverGrid):
        r, c = firstZero(gameOverGrid);
        for val in range(1, 10):
            if(isPossible(r, c, val, gameOverGrid)):
                return False;
        return True;

    
def isPossible(r, c, val, gridVar):  # checks if value is possible at location
    if(gridVar[r][c] == val):
        return True;
    elif(val > 9):
        return False;
    elif(gridVar[r][c] != 0):
        return False;
    for x in range(9):
        if(gridVar[r][x] == val or gridVar[x][c] == val):
            return False;
    for segX in range(math.floor(r / 3) * 3, math.floor(r / 3) * 3 + 3):
            for segY in range(math.floor(c / 3) * 3, math.floor(c / 3) * 3 + 3):
                if(gridVar[segX][segY] == val):
                    return False;
    return True;


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

for x in range(grid.__len__()):
    print(grid[x]);
    
solve(grid);
print("run");
