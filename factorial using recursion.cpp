
#include <iostream>
using namespace std;

/*
Computing the factorial of a number using LL*/

int factorial(int n){
    if(n==1){
        return 1;
    }
    return(n*factorial(n-1));
}
int main(){
    int n;
    cout<<"Enter the number:\n";
    cin>>n;
    cout<<factorial(n);
    return 0;
}
