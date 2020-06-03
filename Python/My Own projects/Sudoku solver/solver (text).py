# solver.py
"""
@author christian Sfeir
Done because i had nothing better to do
"""
def solve(variable):
    """
    Solves a sudoku board using backtracking
    :param variable: 2d list of ints
    :return: solution
    """
    find = find_empty(variable)
    if find:
        row, col = find
    else:
        return True

    for i in range(1,10):
        if valid(variable, (row, col), i):
            variable[row][col] = i

            if solve(variable):
                return True

            variable[row][col] = 0

    return False


def valid(variable, position, nom):
    """
    Returns if the attempted move is correct or valid
    2 dimentional list of integers
    position is the (rows, cols)
    nom is an integer
    this function returns a boolean
    """

    # Check row
    for i in range(0, len(variable)):
        if variable[position[0]][i] == nom and position[1] != i:
            return False


    # Check Col
    for i in range(0, len(variable)):
        if variable[i][position[1]] == nom and position[1] != i:
            return False


    # Check box
    box_x = position[1]//3
    box_y = position[0]//3


    for i in range(box_y*3, box_y*3 + 3):
        for j in range(box_x*3, box_x*3 + 3):
            if variable[i][j] == nom and (i,j) != position:
                return False

    return True


def find_empty(variable):
    """
    finds an empty space in the board
    :param variable: partially complete board
    :return: (int, int) row col
    """

    for i in range(len(variable)):
        for j in range(len(variable[0])):
            if variable[i][j] == 0:
                return (i, j)

    return None


def print_board(variable):
    """
    prints the board
    :param variable: 2d List of ints
    :return: None
    """
    for i in range(len(variable)):
        if i % 3 == 0 and i != 0:
            print("- - - - - - - - - - - - - -")
        for j in range(len(variable[0])):
            if j % 3 == 0:
                print(" | ",end="")

            if j == 8:
                print(variable[i][j], end="\n")
            else:
                print(str(variable[i][j]) + " ", end="")

