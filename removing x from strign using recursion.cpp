#include <iostream>

using namespace std;

/*Question:
Remove all the x occuring characters from the string*/
/*this function is calculating the length of the string*/
int length(char input[]){
    int len=0;
    for(int i=0;input[i]!='\0';i++){
        len++;
    }
    return len;
}
/*This helper function would recursively check each character of the string 
If the existing charcter if 'x' then the length of the pending string is calculated and every character is moved 
one index forward*/
void helper(char input[],int start){
    if(input[start]=='\0'){
        return;
    }
    //helper(input,start+1);
    if(input[start]=='x'){
        int end=length(input);
        int i;
        for(i=start;i<end-1;i++){
            input[i]=input[i+1];            
        }
        input[i]='\0';
        helper(input,start);
        
    }
    else{
    	helper(input,start+1);
    }
}
void removeX(char input[]) {
    helper(input,0);
    // Write your code here

}
int main() {
    char input[100];
    cin.getline(input, 100);
    removeX(input);
    cout << input << endl;
}
