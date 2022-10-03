#include <iostream>

using namespace std;

/*Implementation of merge Sort*/



void merge(int input[],int start,int end,int mid){
    int b[start+end-1];
    int l1=start;
    int l2=mid+1;
    int k=0;
    while(l1<=mid&&l2<=end){
        if(input[l1]<input[l2]){
            b[k++]=input[l1++];
        }
        else{
            b[k++]=input[l2++];
        
        }
    }
    while(l1<=mid){
        b[k++]=input[l1++];
    }
    while(l2<=end){
        b[k++]=input[l2++];
    }
    int j=0;
    for(int i=start;i<=end;i++){
        input[i]=b[j++];
    }
}
void helper(int input[],int si,int ei){
    if(si>=ei){
        return;
    }
    int mid=(si+ei)/2;
    helper(input,si,mid);
    helper(input,mid+1,ei);
    merge(input,si,ei,mid);
}
void mergeSort(int input[], int size){
    int start=0;
    int end=size-1;
    helper(input,start,end);
	
        
}

int main() {
  int length;
  cin >> length;
  int* input = new int[length];
  for(int i=0; i < length; i++)
    cin >> input[i];
  mergeSort(input, length);
  for(int i = 0; i < length; i++) {
    cout << input[i] << " ";
  }
}