'''
Created on Dec 16, 2019

@author: Danny Rosen
'''

import sys

def main(args):
    print("yo");

if __name__ == '__main__':
    main(sys.argv)

class mathAlgorithms:
    
    p = "";
    d = "";
    
    def __init__(self, p, d):
        self.p = p;
        self.d = d;
        print(p, d)