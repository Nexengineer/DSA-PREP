import UIKit

var str = "Hello, playground"

var array = [String]()
array.append("some")

for i in 0...10{
    print("Some value")
}

let array1 = str.components(separatedBy: ",")
print(array1)

var hasmap = [String: String]()
hasmap["neeraj"] = "mishra"
print(hasmap["neeraj"]!)


class LinkedList<T: Equatable> {
    var value:T
    var nextNode:LinkedList<T>?
    
    init(value: T) {
        self.value = value
        self.nextNode = nil
    }
    
    func insert(_ root: LinkedList, _ value: T) {
        var temp = root
        while temp.nextNode != nil {
            temp = temp.nextNode!
        }
        let newNode = LinkedList<Int>(value: value as! Int)
        temp.nextNode! = newNode as! LinkedList<T>
        return
    }
}

let root = LinkedList<Int>(value: 12)

