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
        
        rows, cols = 7,13
        self.board = [[""]*cols]*rows
        for i in range(rows):
            if(i%2==0):
                for j in range(cols):
                    if(j%4==0):
                        self.board[i][j] = "+"
                    else:
                        self.board[i][j] = "-"
            else:
                for j in range(cols):
                    if(j%4==0):
                        self.board[i][j] = "|"
                        #print("here")
                    else:
                        self.board[i][j] = " "
        self.draw()
    def draw(self):
        for i in range(7):
            #print(i)
            for j in range(13):
                print(self.board[i][j], end = "")
            print()
        print(self.board)
    
if __name__ == "__main__":
    run = Run()

