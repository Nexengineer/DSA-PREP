#include <iostream>
using namespace std;

/*Problem:Tower of Hanoi*/
/*Objective:
The objective of this problem is to move each disk from source to destination using auxiliary rod*/

/*Rule:
1) Only one disk can be moved at a time.
2) A disk can be moved only if it is on the top of a rod.
3) No disk can be placed on the top of a smaller disk.
*/

void towerOfHanoi(int n, char source, char auxiliary, char destination) {
    
    if(n==0){
        return;
    }
    towerOfHanoi(n-1,source,destination,auxiliary);
    cout<<source<<" "<<destination<<endl;
    towerOfHanoi(n-1,auxiliary,source,destination);

}

int main() {
    int n;
    cout<<"Enter the number of disks:\n";
    
    cin >> n;
    towerOfHanoi(n, 'a', 'b', 'c');
}
