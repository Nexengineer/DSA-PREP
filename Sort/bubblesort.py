arr=[5,3,2,4,1]


def bubblesort(arr):

    for i in range(0,len(arr)-1,1):
        for j in range(0,len(arr)-1,1):
            if(arr[j]>arr[j+1]):
                temp=arr[j]
                arr[j]=arr[j+1]
                arr[j+1]=temp
                
    print(arr)
bubblesort(arr)