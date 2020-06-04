#include "iostream"
#include <time.h>

using namespace std;

#define starter 0 
#define medium 1 
#define pro 2 
#define MAXSIDE 25 
#define MAXMINES 99 
#define MOVESIZE 526 // (25 * 25 - 99) 

int border; // side length of the board 
int MINES; // number of mines on the board 

// A Utility Function to check whether given cell is valid
bool isValid(int row, int col)
{
    // Returns true if row number and column number 
    // is in range 
    return (row >= 0) && (row < border) &&
        (col >= 0) && (col < border);
}

// A Utility Function to check whether given cell has a mine or not. 
bool isMine(int row, int col, char board[][MAXSIDE])
{
    if (board[row][col] == '*')
        return (true);
    else
        return (false);
}

// User Input 
void makeMove(int* x, int* y)
{
    // Take the input move 
    cout << "Enter your move, (row, column) -> ";
    scanf_s("%d %d", x, y);
    return;
}

// A Function to print board
void printBoard(char myBoard[][MAXSIDE])
{
    int i, j;

    printf("    ");

    for (i = 0; i < border; i++)
        printf("%d ", i);

    printf("\n\n");

    for (i = 0; i < border; i++)
    {
        printf("%d   ", i);

        for (j = 0; j < border; j++)
            printf("%c ", myBoard[i][j]);
        printf("\n");
    }
    return;
}

// A Function to count the number of mines
int countAdjacentMines(int row, int col, int mines[][2],
    char realBoard[][MAXSIDE])
{

    int i;
    int count = 0;

    //checks all around the cell

    if (isValid(row - 1, col) == true)
    {
        if (isMine(row - 1, col, realBoard) == true)
            count++;
    }

    if (isValid(row + 1, col) == true)
    {
        if (isMine(row + 1, col, realBoard) == true)
            count++;
    }

    if (isValid(row, col + 1) == true)
    {
        if (isMine(row, col + 1, realBoard) == true)
            count++;
    }

    if (isValid(row, col - 1) == true)
    {
        if (isMine(row, col - 1, realBoard) == true)
            count++;
    }

    if (isValid(row - 1, col + 1) == true)
    {
        if (isMine(row - 1, col + 1, realBoard) == true)
            count++;
    }


    if (isValid(row - 1, col - 1) == true)
    {
        if (isMine(row - 1, col - 1, realBoard) == true)
            count++;
    }


    if (isValid(row + 1, col + 1) == true)
    {
        if (isMine(row + 1, col + 1, realBoard) == true)
            count++;
    }

    if (isValid(row + 1, col - 1) == true)
    {
        if (isMine(row + 1, col - 1, realBoard) == true)
            count++;
    }

    return (count);
}


//place the mines randomly 
void placeMines(int mines[][2], char realBoard[][MAXSIDE])
{
    bool mark[MAXSIDE * MAXSIDE];

    memset(mark, false, sizeof(mark));

    // Continue until all random mines have been created. 
    for (int i = 0; i < MINES; )
    {
        int random = rand() % (border * border);
        int x = random / border;
        int y = random % border;

        // Add the mine if no mine is placed at this 
        // position on the board 
        if (mark[random] == false)
        {
            // Row Index of the Mine 
            mines[i][0] = x;
            // Column Index of the Mine 
            mines[i][1] = y;

            // Place the mine 
            realBoard[mines[i][0]][mines[i][1]] = '*';
            mark[random] = true;
            i++;
        }
    }

    return;
}

// A Recursive Fucntion
bool playMinesweeperUtil(char myBoard[][MAXSIDE], char realBoard[][MAXSIDE],
    int mines[][2], int row, int col, int* movesLeft)
{

    // Base Case of Recursion 
    if (myBoard[row][col] != '-')
        return (false);

    int i, j;

    // You opened a mine 
    // You are going to lose 
    if (realBoard[row][col] == '*')
    {
        myBoard[row][col] = '*';

        for (i = 0; i < MINES; i++)
            myBoard[mines[i][0]][mines[i][1]] = '*';

        printBoard(myBoard);
        printf("\nYou lost!\n");
        return (true);
    }

    else
    {
        // Calculate the number of adjacent mines and put it 
        // on the board 
        int count = countAdjacentMines(row, col, mines, realBoard);
        (*movesLeft)--;

        myBoard[row][col] = count + '0';

        if (!count)
        {
            //checks all around the cell

            if (isValid(row - 1, col) == true)
            {
                if (isMine(row - 1, col, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col, movesLeft);
            }

            if (isValid(row + 1, col) == true)
            {
                if (isMine(row + 1, col, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col, movesLeft);
            }


            if (isValid(row, col + 1) == true)
            {
                if (isMine(row, col + 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row, col + 1, movesLeft);
            }


            if (isValid(row, col - 1) == true)
            {
                if (isMine(row, col - 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row, col - 1, movesLeft);
            }


            if (isValid(row - 1, col + 1) == true)
            {
                if (isMine(row - 1, col + 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col + 1, movesLeft);
            }

            if (isValid(row - 1, col - 1) == true)
            {
                if (isMine(row - 1, col - 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row - 1, col - 1, movesLeft);
            }


            if (isValid(row + 1, col + 1) == true)
            {
                if (isMine(row + 1, col + 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col + 1, movesLeft);
            }


            if (isValid(row + 1, col - 1) == true)
            {
                if (isMine(row + 1, col - 1, realBoard) == false)
                    playMinesweeperUtil(myBoard, realBoard, mines, row + 1, col - 1, movesLeft);
            }
        }

        return (false);
    }
}

// A Function to start 
void initialise(char realBoard[][MAXSIDE], char myBoard[][MAXSIDE])
{
    // Initiate the random number generator so that 
    // the same configuration doesn't arises 
    srand(time(NULL));

    // Assign all the cells as mine-free 
    for (int i = 0; i < border; i++)
    {
        for (int j = 0; j < border; j++)
        {
            myBoard[i][j] = realBoard[i][j] = '-';
        }
    }

    return;
}

//revealing where the mines are 
void cheatMinesweeper(char realBoard[][MAXSIDE])
{
    printf("The mines locations are-\n");
    printBoard(realBoard);
    return;
}


void replaceMine(int row, int col, char board[][MAXSIDE])
{
    for (int i = 0; i < border; i++)
    {
        for (int j = 0; j < border; j++)
        {
            // Find the first location in the board 
            // which is not having a mine and put a mine 
            // there. 
            if (board[i][j] != '*')
            {
                board[i][j] = '*';
                board[row][col] = '-';
                return;
            }
        }
    }
    return;
}

// A Function to play
void play()
{
    // Initially the game is not over 
    bool gameOver = false;

    // Actual Board and My Board 
    char realBoard[MAXSIDE][MAXSIDE], myBoard[MAXSIDE][MAXSIDE];

    int movesLeft = border * border - MINES, x, y;
    int mines[MAXMINES][2]; // stores (x,y) coordinates of all mines. 

    initialise(realBoard, myBoard);

    // Place the Mines randomly 
    placeMines(mines, realBoard);

    /*
    If you want to cheat and know
    where mines are before playing the game
    then uncomment this part

    cheatMinesweeper(realBoard);
    */

    // You are in the game until you have not opened a mine 
    // So keep playing 

    int currentMoveIndex = 0;
    while (gameOver == false)
    {
        printf("Current Status of Board : \n");
        printBoard(myBoard);
        makeMove(&x, &y);

        // This is to guarantee that the first move is 
        // always safe 
        // If it is the first move of the game 
        if (currentMoveIndex == 0)
        {
            // If the first move itself is a mine 
            // then we remove the mine from that location 
            if (isMine(x, y, realBoard) == true)
                replaceMine(x, y, realBoard);
        }

        currentMoveIndex++;

        gameOver = playMinesweeperUtil(myBoard, realBoard, mines, x, y, &movesLeft);

        if ((gameOver == false) && (movesLeft == 0))
        {
            printf("\nYou won !\n");
            gameOver = true;
        }
    }
    return;
}

// A Function to choose the difficulty
void difficultyLevel()
{


    int difficulty;

    printf("Enter the Difficulty Level\n");
    printf("Press 0 for starter (9 * 9 Cells and 10 Mines)\n");
    printf("Press 1 for medium (16 * 16 Cells and 40 Mines)\n");
    printf("Press 2 for pro (24 * 24 Cells and 90 Mines)\n");

    scanf_s("%d", &difficulty);

    if (difficulty == starter)
    {
        border = 9;
        MINES = 10;
    }

    if (difficulty == medium)
    {
        border = 16;
        MINES = 40;
    }

    if (difficulty == pro)
    {
        border = 24;
        MINES = 90;
    }

    return;
}

int main()
{
    difficultyLevel();
    play();

    return (0);
}