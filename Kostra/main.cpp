/*
 * File:   main.cpp
 * Author: mazmart
 *
 * Created on October 8, 2012, 4:51 PM
 */

#include <iostream>
#include <vector>
#include <list>

using namespace std;

int graf[8 * 8];

class Uzel;


class Kostra;


vector<int> hrany;

/*
 *
 */


class Uzel {
    static int n;
    int name;
    int current;

public:
    list<Uzel> hrany;

    void toString() {
        cout << "Uzel " << name << ':';

        for_each(hrany.begin(), hrany.end(), Uzel::coutName);

        cout << "\n";
    }

    void removeUzel(Uzel x) {
        hrany.remove(x);
    }

    bool operator==(Uzel x) {
        return x.getName() == name;
    }

    void push(Uzel x) {
        hrany.push_back(x);
    }

    Uzel(const Uzel & x) {
        name = x.getName();
        hrany = x.hrany;
        current = 0;
    }

    Uzel(int x) {
        name = x + 1;
        current = 0;
    }

    Uzel() {
        name = n++;
        current = 0;
    }

    Uzel spoj() {
        list<Uzel>::iterator it = hrany.begin();
        cout << "Current: " << it->getName() << "\n";
        return NULL;
    }

    static void coutUzly(Uzel u) {
        u.toString();
    }

    static void coutName(Uzel i) {
        cout << " " << i.getName();
    }

    int getName() const {
        return name;
    }

};

int Uzel::n = 1;

class Kostra {
public:
    list<Uzel> kostra;
    Uzel uzly[];

    void add(Uzel x) {
        list<Uzel>::iterator it;
        cout << "adding: ";
        x.toString();
        kostra.push_back(x);
        for (it = kostra.begin(); it != kostra.end(); it++) {
            remove(*it);
            //            it->toString();
        }
    }

    void remove(Uzel x) {
        list<Uzel>::iterator it;
        for (it = kostra.begin(); it != kostra.end(); it++) {
            it->removeUzel(x);
        }
    }

    void next(list<Kostra> & stack) {
        list<Uzel>::iterator it;
        for (it = kostra.begin(); it != kostra.end(); it++) { // 7
            list<Uzel>::iterator i;
            list<Uzel> hrany = it->hrany;
            for (i = hrany.begin(); i != hrany.end(); i++) { // 4 5 6 8
                Kostra k;
                k.kostra = kostra;
                k.add(*i);
                stack.push_back(k);
            }
        }
    }

    void toString() {
        list<Uzel>::iterator it;
        cout << "\nKostra To String\n";
        for (it = kostra.begin(); it != kostra.end(); it++) {
            it->toString();
        }
    }
};

class Stack {
public:
    Kostra s[];
    int usedSize;

    void push(Uzel x) {
    }

    void popFirst() {
    }

    void popLast() {
    }
};

int main(int argc, char ** argv) {
    int graf[8 * 8] = {
        0, 1, 0, 1, 0, 0, 0, 1, // 1
        1, 0, 1, 1, 1, 0, 0, 0, // 2
        0, 1, 0, 0, 1, 1, 0, 0, // 3
        1, 1, 0, 0, 0, 1, 1, 0, // 4
        0, 1, 1, 0, 0, 0, 1, 1, // 5
        0, 0, 1, 1, 0, 0, 1, 0, // 6
        0, 0, 0, 1, 1, 1, 0, 1, // 7
        1, 0, 0, 0, 1, 0, 1, 0 // 8
    };

    // 1 2 3 4 5 6 7 8
    Uzel * uzly = new Uzel[8];


    for (int i = 0; i < 8; i++) {

        for (int j = 0; j < 8; j++) {
            if (graf[i * 8 + j] == 1) {
                uzly[i].push(uzly[j]);
            }
        }

    }
    cout << "\n777777    ";
    uzly[0].hrany.front().toString();
    cout << "\n";

    for (int i = 0; i < 8; i++) {
        uzly[i].toString();
    }



    //
    //    cout << "Start\n";
    //    //    Uzel x(1);
    //    //    Uzel x1(2);
    //    //    Uzel x2(3);
    //    //    x.push(x1);
    //    //    x.push(x2);
    //    //    x.spoj();
    //    //    x.spoj();
    //    //    x.spoj();
    //
    //
    list<Kostra> stack;

    Kostra kostra;
    kostra.add(uzly[6]);
    stack.push_back(kostra);
    list<Kostra>::iterator it;
    stack.front().toString();
    cout << "\n\n NEXT \n";
    stack.front().next(stack);
    stack.pop_front();
    for (it = stack.begin(); it != stack.end(); it++) {
        it->toString();
    };
//    //            stack.front().toString();
//    cout << "\n\n NEXT \n";
//    stack.front().next(stack);
//    for (it = stack.begin(); it != stack.end(); it++) {
//        it->toString();
//    };
    return 0;
}


//~ Formatted by Jindent --- http://www.jindent.com
