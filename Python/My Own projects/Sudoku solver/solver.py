# solver.py

def solve(variable):
    find = find_empty(variable)
    if not find:
        return True
    else:
        row, col = find

    for i in range(1,10):
        if valid(variable, i, (row, col)):
            variable[row][col] = i

            if solve(variable):
                return True

            variable[row][col] = 0

    return False


def valid(variable, nom, position):
    # Check row
    for i in range(len(variable[0])):
        if variable[position[0]][i] == nom and position[1] != i:
            return False

    # Check column
    for i in range(len(variable)):
        if variable[i][position[1]] == nom and position[0] != i:
            return False

    # Check box
    box_x = position[1] // 3
    box_y = position[0] // 3

    for i in range(box_y*3, box_y*3 + 3):
        for j in range(box_x * 3, box_x*3 + 3):
            if variable[i][j] == nom and (i,j) != position:
                return False

    return True


def print_board(variable):
    for i in range(len(variable)):
        if i % 3 == 0 and i != 0:
            print("- - - - - - - - - - - - - ")

        for j in range(len(variable[0])):
            if j % 3 == 0 and j != 0:
                print(" | ", end="")

            if j == 8:
                print(variable[i][j])
            else:
                print(str(variable[i][j]) + " ", end="")


def find_empty(variable):
    for i in range(len(variable)):
        for j in range(len(variable[0])):
            if variable[i][j] == 0:
                return (i, j)  # row, col

    return None
