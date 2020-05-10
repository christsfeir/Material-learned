#pragma once
class Bed{
private:
    static int id;
public:
    
    Bed(int id = 0) {
    }
    bool flag;

    int getID() {
        id++;
        return id;
    }
    int getIds() {
        return id;
    }
};

