// Singly linked list 
class Node<T> {
    var data: T
    var nextNode: Node<T>?

    init(data: T){
        self.data = data
    }
}

class SingleLinkedList<T> {
    private var head: Node<T>?

    // Check Length of single Linked List 
    func isEmpty() -> Bool{
        head == nil ? true : false
    }

    func size() -> Int {
        var size = 0
        if var pointer = head {
            while(pointer.nextNode != nil) {
                pointer = pointer.nextNode!
                size = size + 1
            }
            return size + 1
        }

        return size 
    }

    // func adding element to linked list 
    func append(_ value: T){
        let newNode = Node<T>(data: value)
        newNode.nextNode = nil
        if var pointer = head {
            while pointer.nextNode != nil {
                pointer = pointer.nextNode!
            }
            pointer.nextNode = newNode
        } else {
            head = newNode
        }
    }
    // function to remove first
    func removeFirst() {
        if head != nil {
            if let headTemp = head, let newhead = headTemp.nextNode {
                head = newhead
            } else {
                head = nil
            }
        } else {
            print("Link List is empty")
        }
    } 

    // function to remove the last
    func removeLast() {
        if var pointer = head {
            var tempPointer: Node<T>!
            while(pointer.nextNode != nil){
                tempPointer = pointer
                pointer = pointer.nextNode!
            }
            tempPointer.nextNode = nil
        } else {
          print("Link List is empty")  
        }
    }

    // function to insert at a index
    func appendAt(_ at: Int, _ data: T){
        if head == nil || size() <= at {
            print("Index out of bound")
        } else {
            var count = 0
            var tempPointer: Node<T>!
            if var pointer = head {
                while(count != at){
                    count = count + 1
                    tempPointer = pointer
                    pointer = pointer.nextNode!
                }
                let newNode = Node<T>(data: data)
                newNode.nextNode = pointer
                tempPointer!.nextNode = newNode
            }
        }
    }
    // MARK:- Finish these questions after implementing the data structure and algo
    // TODO:: Implement deleting the center node of a linked list 
    // TODO:: Implement deleting a given node 
    // TODO:: Implementing reverse of linked list 

    // function to print all the nodes
    func printLinkedList(){
        if var pointer = head {
            while pointer.nextNode != nil {
                print(pointer.data)
                pointer = pointer.nextNode!
            }
            print(pointer.data)
        } else {
            print("linked List is empty")
        }
    }
}

// Driver function
var linkedList = SingleLinkedList<String>()
linkedList.printLinkedList()
linkedList.append("Neeraj")
linkedList.append("Kumar")
linkedList.append("Mishra")
linkedList.printLinkedList()
print(linkedList.size())
print("--------------------------------")
linkedList.removeFirst()
linkedList.printLinkedList()
print("--------------------------------")
linkedList.removeLast()
linkedList.printLinkedList()
print("--------------------------------")
linkedList.append("Neeraj")
linkedList.append("Kumar")
linkedList.append("Mishra")
linkedList.appendAt(1, "Hello")
linkedList.printLinkedList()
print("--------------------------------")
print(linkedList.isEmpty())