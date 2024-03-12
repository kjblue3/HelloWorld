import pandas as pd
"""def main():
    # Prompt the user to enter their name
    name = input("What's your name? ")

    # Greet the user
    print("Hello, " + name + "! Welcome to Python.")
    """
class Run:
    def __init__(self):
        #main()
        self.counter = 0
        self.tictac = [[" " for i in range(3)]for i in range(3)]
        self.rows, self.cols = 7,13
        self.board = [[""for i in range(self.cols)]for i in range(self.rows)]
        for i in range(self.rows):
            if(i%2==0):
                for j in range(self.cols):
                    if(j%4==0):
                        self.board[i][j] = "+"
                        #print(j)
                    else:
                        self.board[i][j] = "-"
                        #print("top else")
            else:
                for j in range(self.cols):
                    if(j%4==0):
                        self.board[i][j] = "|"
                        #print("here")
                    else:
                        self.board[i][j] = " "
                        #print("bottom else")
            #print(self.board)
        #self.draw()
        self.run()
    def draw(self):
        for i in range(self.rows):
            #print(i)
            for j in range(self.cols):
                print(self.board[i][j], end = "")
            print()
        #print(self.board)
    def input(self, x, y, player):
        if(self.board[(x*2)-1][(y*4)-2] == " "):
            self.board[(x*2)-1][(y*4)-2] = player
        else:
            print("enter a valid position")
            self.counter -=1
    def checkWon(self)->bool:
        """boardAct = [[" "for i in range(3)]for j in range(3)]
        for i in range(self.rows):
            for j in range(self.cols):
                if(i%2 ==1 and (j-2)%4==0):
                    boardAct[(int((i+1)/2))-1][(int((j+2)/4))-1] = self.board[i][j]
        for i in range(3):
            if(boardAct[0][i] == boardAct[1][i] == boardAct[2][i]):
                return True
            if(boardAct[i][0] == boardAct[i][1] == boardAct[i][2]):
                return True
        if(boardAct[0][0] == boardAct[1][1] == boardAct[2][2]):
            return True
        if(boardAct[0][2] == boardAct[1][1] == boardAct[2][0]):
            return True
        return False
        """
        for i in range(3):
            if(self.tictac[0][i]==self.tictac[1][i] and self.tictac[1][i]==self.tictac[2][i] and self.tictac[1][i] != " "):
                return True
            if(self.tictac[i][0]==self.tictac[i][1] and self.tictac[i][1]==self.tictac[i][2])and self.tictac[i][1] != " ":
                return True
        if(self.tictac[0][0]==self.tictac[1][1] and self.tictac[1][1]==self.tictac[2][2]and self.tictac[1][1] != " "):
                return True
        if(self.tictac[0][2]==self.tictac[1][1] and self.tictac[1][1]==self.tictac[2][0] and self.tictac[1][1]!= " "):
                return True
        return False
    def run(self):
        running = True
        while(running ):
            if (self.counter %2 == 0):
                player = "X"
            else:
                player = "O"
            x = int(input("enter the row you want to play in: "))
            y = int(input("enter the column you want to play in: "))
            self.tictac[x-1][y-1] = player
            self.input(x,y,player)
            self.draw() 
            self.counter +=1
            running = not self.checkWon()
        print(player + " won!")

if __name__ == "__main__":
    run = Run()

